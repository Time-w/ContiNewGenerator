package top.continew.config;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts.ConfigurableName;
import javax.swing.JComponent;
import org.jetbrains.annotations.Nullable;

/**
 * @author Administrator
 * @date 2025-08-17 23:59
 */
public class ContiNewGeneratorConfig implements Configurable {

	private ContiNewGeneratorConfigUI contiNewGeneratorConfigUI;

	@Override
	public @ConfigurableName String getDisplayName() {
		return "ContiNew Config";
	}

	@Override
	public @Nullable JComponent createComponent() {
		if (contiNewGeneratorConfigUI == null) {
			contiNewGeneratorConfigUI = new ContiNewGeneratorConfigUI();
		}
		return contiNewGeneratorConfigUI.createComponent();
	}

	@Override
	public boolean isModified() {
		if (contiNewGeneratorConfigUI == null) {
			return false;
		}
		return contiNewGeneratorConfigUI.isModified();
	}

	@Override
	public void apply() throws ConfigurationException {
		if (contiNewGeneratorConfigUI == null) {
			return;
		}
		contiNewGeneratorConfigUI.apply();
	}

	@Override
	public void reset() {
		if (contiNewGeneratorConfigUI == null) {
			return;
		}
		contiNewGeneratorConfigUI.reset();
	}

	@Override
	public void disposeUIResources() {
		contiNewGeneratorConfigUI = null;
	}
}
