package me.lee_sh1673;

import java.util.Arrays;

public class StringCalculator {

	private final String[] operators;

	private final int[] operands;

	public StringCalculator(String expression) {
		final String[] statements = expression.split(" ");

		this.operators = Arrays.stream(statements)
			.filter(s -> s.matches("[+*-/]"))
			.toArray(String[]::new);

		this.operands = Arrays.stream(statements)
			.filter(s -> s.matches("[0-9]"))
			.mapToInt(Integer::parseInt)
			.toArray();
	}

	private void validateExpressions() {

		if (operators.length >= operands.length) {
			throw new ArrayIndexOutOfBoundsException(
				"Invalid Expression received. Please check your input.");
		}
	}

	public int compute() {
		validateExpressions();

		int agregate = operands[0];
		int idx = 1;

		for (final String operator : operators) {
			agregate = Calculator.compute(agregate, operands[idx], operator);
			idx++;
		}
		return agregate;
	}

	public int[] getOperands() {
		return operands;
	}

	public String[] getOperators() {
		return operators;
	}
}
