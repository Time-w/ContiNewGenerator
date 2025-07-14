package top.continew.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TableHeaderEnum {
	INDEX(0, "序号", false, false),
	NAME(1, "列名", false, false),
	CODE_PROPERTY(2, "字段名称", false, true),
	TYPE(3, "类型", false, false),
	CODE_TYPE(4, "Java类型", false, true),
	DESCRIPTION(5, "描述", false, true),

	ADD_FIELD(6, "列表", true, true),
	EDIT_FIELD(7, "表单", true, true),
	REQUIRED(8, "必填", true, true),
	QUERY_FIELD(9, "查询", true, true),
	QUERY_TYPE(10, "查询方式", false, true),
	LIST_SHOW(11, "表单类型", false, true),
	RELATION_DICT(12, "关联字典", false, true),
	Hidden_1(13, "长度", false, false);

	private final int index;
	private final String description;
	private final boolean checkbox;
	private final boolean editable;

}
