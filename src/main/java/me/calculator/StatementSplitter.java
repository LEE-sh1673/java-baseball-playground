package me.calculator;

public class StatementSplitter {

	private static final String DEFAULT_DELIMITER = " ";

	public static String[] split(final String statement) {
		return statement.split(DEFAULT_DELIMITER);
	}
}
