package top.continew.persistent.table;

import lombok.Data;

/**
 * @author lww
 * @date 2025-11-07 16:54
 */
@Data
public class FieldProperties {

	/**
	 * 字段名称
	 */
	private String codeName;

	/**
	 * Java类型
	 */
	private String codeType;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 响应
	 */
	private boolean tableList;

	/**
	 * 请求
	 */
	private boolean tableForm;

	/**
	 * 必填
	 */
	private boolean required;

	/**
	 * 查询
	 */
	private boolean queryField;

	/**
	 * 查询方式
	 */
	private String queryType;

	/**
	 * 表单类型
	 */
	private String formShowType;

	/**
	 * 关联字典
	 */
	private String relationDict;

}
