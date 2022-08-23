package me.calculator;

public class StatementCalculator {

	private final String[] operators;
	private final int[] operands;

	public StatementCalculator(final String[] operators, final int[] operands) {
		this.operators = operators;
		this.operands = operands;
	}

	public int compute() {
		int result = operands[0];
		for (int i = 0; i < operators.length; i++) {
			result = Calculator.compute(result, operands[i+1], operators[i]);
		}
		return result;
	}
}
