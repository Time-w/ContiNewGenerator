package top.continew.persistent;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import java.util.Map;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.continew.persistent.table.FieldProperties;

/**
 * @author lww
 * @date 2025-11-08 00:59
 */
@Data
@Service
@State(name = "TableGeneratePersistent", storages = @Storage("top.continew.tableGeneratePersistent.xml"))
public final class TableGeneratePersistent implements PersistentStateComponent<TableGeneratePersistent> {

	//表名 字段名 字段属性
	private Map<String, Map<String, FieldProperties>> fieldPropertiesMap;

	public static TableGeneratePersistent getInstance(Project project) {
		TableGeneratePersistent config = project.getService(TableGeneratePersistent.class);
		if (config == null) {
			config = new TableGeneratePersistent();
		}
		return config;
	}

	@Override
	public @Nullable TableGeneratePersistent getState() {
		return this;
	}

	@Override
	public void loadState(@NotNull TableGeneratePersistent state) {
		XmlSerializerUtil.copyBean(state, this);

	}
}