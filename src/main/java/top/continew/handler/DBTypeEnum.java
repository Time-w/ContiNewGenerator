package top.continew.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author lww
 * @date 2025-08-03 14:28
 */
@Getter
@RequiredArgsConstructor
public enum DBTypeEnum {
	MySQL("com.mysql.cj.jdbc.Driver", MySQLHandler.getInstance()),
	PostgreSQL("org.postgresql.Driver", PostgreSQLHandler.getInstance()),
	//
	;

	private final String driver;
	private final QueryHandler handler;
}
