package me.calculator;

import java.util.Arrays;

public class StatementParser {

	private static final String OPERAND_DELIMITER = "-?\\d";

	private static final String OPERATOR_DELIMITER = "[+*/]|(?<=\\s)-";

	private final String[] words;

	public StatementParser(String[] words) {
		this.words = words;
	}

	public int[] getOperands() {
		return Arrays.stream(this.words)
			.filter(StatementParser::isDigit)
			.mapToInt(StatementParser::toPositive)
			.toArray();
	}

	private static int toPositive(final String value) {
		int number = Integer.parseInt(value);

		if (number < 0) {
			throw new RuntimeException("숫자는 양수만 가능합니다.");
		}
		return number;
	}

	private static boolean isDigit(final String word) {
		return word.matches(OPERAND_DELIMITER);
	}

	public String[] getOperators() {
		return Arrays.stream(this.words)
			.filter(StatementParser::isOperator)
			.toArray(String[]::new);
	}

	private static boolean isOperator(final String word) {
		return word.matches(OPERATOR_DELIMITER);
	}
}
