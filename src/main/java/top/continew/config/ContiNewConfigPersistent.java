package top.continew.config;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @author Administrator
 * @date 2025-08-18 0:19
 */
@Data
@State(name = "ContiNewConfigPersistent", storages = {@Storage("ContiNewConfigPersistent.xml")})
public class ContiNewConfigPersistent implements PersistentStateComponent<ContiNewConfigPersistent> {

	private boolean hightLight = true;
	private String requestExcludeText;
	private String responseExcludeText;
	private String requiredExcludeText;
	private String queryExcludeText;
	private String stringType;
	private String numberType;
	private String dateType;
	private String booleanType;

	public static ContiNewConfigPersistent getInstance(Project project) {
		ContiNewConfigPersistent config = project.getService(ContiNewConfigPersistent.class);
		if (config == null) {
			config = new ContiNewConfigPersistent();
		}
		return config;
	}

	@Override
	public ContiNewConfigPersistent getState() {
		return this;
	}

	@Override
	public void loadState(@NotNull ContiNewConfigPersistent state) {
		XmlSerializerUtil.copyBean(state, this);
	}
}
