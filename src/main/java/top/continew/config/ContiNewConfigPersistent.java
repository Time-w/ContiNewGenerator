package top.continew.config;

import com.intellij.openapi.application.*;
import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.*;
import lombok.*;
import org.jetbrains.annotations.*;

/**
 * @author Administrator
 * @date 2025-08-18 0:19
 */
@Data
@State(name = "ContiNewConfigPersistent", storages = {@Storage("ContiNewConfigPersistent.xml")})
public class ContiNewConfigPersistent implements PersistentStateComponent<ContiNewConfigPersistent> {

	private Boolean hightLight;
	private String requestExcludeText;
	private String responseExcludeText;
	private String requiredExcludeText;
	private String queryExcludeText;
	private String stringType;
	private String numberType;
	private String dateType;
	private String booleanType;

	public static ContiNewConfigPersistent getInstance() {
		ContiNewConfigPersistent config = ApplicationManager.getApplication().getService(ContiNewConfigPersistent.class);
		if (config == null) {
			config = new ContiNewConfigPersistent();
		}
		if (config.getHightLight() == null) {
			config.setHightLight(true);
		}
		if (config.getRequestExcludeText() == null) {
			config.setRequestExcludeText("createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (config.getResponseExcludeText() == null) {
			config.setResponseExcludeText("id,createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (config.getRequiredExcludeText() == null) {
			config.setRequiredExcludeText("id,createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (config.getQueryExcludeText() == null) {
			config.setQueryExcludeText("createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (config.getStringType() == null) {
			config.setStringType("LIKE '%s%'");
		}
		if (config.getNumberType() == null) {
			config.setNumberType("=");
		}
		if (config.getDateType() == null) {
			config.setDateType("BETWEEN");
		}
		if (config.getBooleanType() == null) {
			config.setBooleanType("=");
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
