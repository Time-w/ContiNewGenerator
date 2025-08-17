package top.continew.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author lww
 * @date 2025-07-01 10:41
 */
@Getter
@RequiredArgsConstructor
public enum JavaTypeEnum implements BaseEnum<Integer> {

	String(1, "String"),
	Integer(2, "Integer"),
	Long(3, "Long"),
	Float(4, "Float"),
	Double(5, "Double"),
	Boolean(6, "Boolean"),
	BigDecimal(7, "BigDecimal"),
	LocalDate(8, "LocalDate"),
	LocalTime(9, "LocalTime"),
	LocalDateTime(10, "LocalDateTime"),
	;

	private final Integer value;
	private final String description;
}
