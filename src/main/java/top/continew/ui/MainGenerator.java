package top.continew.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vfs.VirtualFile;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jetbrains.annotations.Nullable;
import org.yaml.snakeyaml.Yaml;
import top.continew.utils.FileChooseUtils;
import top.continew.utils.PluginIconsUtils;

/**
 * @author lww
 * @date 2025-06-30 11:28
 */
public class MainGenerator extends DialogWrapper {

	private JPanel rootPanel;
	private JTextField projectPathTextField;
	private JButton selectPathButton;
	private JLabel projectPathLabel;
	private JLabel authorLabel;
	private JTextField authorTextField;
	private JLabel packageNameLabel;
	private JTextField packageNameTextField;
	private JLabel tablePrefixLabel;
	private JTextField tablePrefixTextField;
	private JTextField versionTextField;
	private JLabel versionLabel;
	private JTextField createTimeTextField;
	private JTextField updateTimeTextField;
	private JLabel createTimeLabel;
	private JLabel updateTimeLabel;
	private JTextField logicDeleteTextField;
	private JLabel logicDeleteLabel;
	private AutoCompleteComboBox tableNameTextField;
	private JLabel tableLabel;
	private JButton cancelButton;
	private JButton nextButton;
	private JTextField configFilePathTextField;
	private JButton configFilePathButton;
	private JLabel configFilePathLabel;

	private static final MainGenerator instance = null;

	public static MainGenerator getInstance(Project project) {
		if (instance == null) {
			return new MainGenerator(project);
		}
		return instance;
	}

	protected MainGenerator(@Nullable Project project) {
		super(project);
		setTitle("ContiNew Generator");
		setModal(true);
		setResizable(false);
		this.init();

		configFilePathButton.setIcon(PluginIconsUtils.propertiesFile);
		configFilePathButton.addActionListener(e -> {
			FileChooseUtils uiComponentFacade = FileChooseUtils.getInstance(project);
			VirtualFile baseDir = null;
			if (project != null) {
				baseDir = ProjectUtil.guessProjectDir(project);
			}
			final VirtualFile vf = uiComponentFacade.showSingleFileSelectionDialog("选择配置文件", baseDir, baseDir);
			if (null != vf) {
				String path = vf.getPath();
				this.configFilePathTextField.setText(path);

				List<Map<String, Object>> docsList = new ArrayList<>();
				try (InputStream inputStream = vf.getInputStream()) {
					Yaml yaml = new Yaml();
					Iterable<Object> docs = yaml.loadAll(inputStream);
					for (Object doc : docs) {
						if (doc instanceof Map) {
							docsList.add((Map<String, Object>) doc);
						}
					}
					Optional<Map<String, Object>> first = docsList.stream().filter(dl -> dl.get("spring") != null).findFirst();
					if (first.isPresent()) {
						Map<String, Object> map = first.get();
						Map<String, Object> datasource = (Map<String, Object>) map.get("datasource");
						if (datasource != null) {
							String url = (String) datasource.get("url");
							String username = (String) datasource.get("username");
							String password = (String) datasource.get("password");
							System.out.println("DB URL: " + url);
							System.out.println("DB User: " + username);
							System.out.println("DB Password: " + password);
						} else {
							System.out.println("获取数据库失败11111");
						}
					} else {
						first = docsList.stream().filter(dl -> dl.get("spring.datasource") != null).findFirst();
						if (first.isPresent()) {
							Map<String, Object> datasource = first.get();
							Map<String, Object> ds = (Map<String, Object>) datasource.get("spring.datasource");
							String type = (String) ds.get("type");
							String url = (String) ds.get("url");
							String replaceUrl = url.replace("p6spy:", "")
									.replace("${DB_HOST:", "")
									.replace("${DB_PORT:", "")
									.replace("${DB_NAME:", "")
									.replace("}", "");
							String username = (String) ds.get("username");
							String replaceUsername = username
									.replace("${DB_USER:", "")
									.replace("}", "");
							String password = (String) ds.get("password");
							String replacePassword = password
									.replace("${DB_PWD:", "")
									.replace("}", "");
							System.out.println("DB URL: " + replaceUrl);
							System.out.println("DB User: " + replaceUsername);
							System.out.println("DB Password: " + replacePassword);

							Class.forName("com.mysql.cj.jdbc.Driver");
							HikariConfig config = new HikariConfig();
							config.setJdbcUrl(replaceUrl);
							config.setUsername(replaceUsername);
							config.setPassword(replacePassword);
							config.setDriverClassName("com.mysql.cj.jdbc.Driver");
							config.setMaximumPoolSize(10);
							HikariDataSource dataSource = new HikariDataSource(config);
							System.out.println("DB Connection Success!");
							Connection connection = dataSource.getConnection();
							System.out.println("DB Connection: " + connection);
						} else {
							System.out.println("获取数据库失败22222");
						}
					}
				} catch (Exception err) {
					err.printStackTrace();
				}
			}

		});
		selectPathButton.setIcon(PluginIconsUtils.projectStructure);
		selectPathButton.addActionListener(e -> {
			FileChooseUtils uiComponentFacade = FileChooseUtils.getInstance(project);
			VirtualFile baseDir = null;
			if (project != null) {
				baseDir = ProjectUtil.guessProjectDir(project);
			}
			final VirtualFile vf = uiComponentFacade.showSingleFolderSelectionDialog("选择项目路径", baseDir, baseDir);
			if (null != vf) {
				this.projectPathTextField.setText(vf.getPath());
			}
		});

		nextButton.setIcon(PluginIconsUtils.promptInput);
		cancelButton.setIcon(PluginIconsUtils.testFailed);
		cancelButton.addActionListener(e -> dispose());

	}

	@Override
	protected @Nullable JComponent createCenterPanel() {
		return rootPanel;
	}

	@Override
	protected void dispose() {
		super.dispose();
	}

	@Override
	protected Action[] createActions() {
		return new Action[0];
	}

}
