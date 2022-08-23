package me.calculator;

public class StringCalculator {

	private final String[] operators;

	private final int[] operands;

	public StringCalculator(final String statement) {
		String[] words = StatementSplitter.split(statement);
		StatementParser parser = new StatementParser(words);
		this.operators = parser.getOperators();
		this.operands = parser.getOperands();
	}

	public int compute() {
		int result = operands[0];
		for (int i = 0; i < operators.length; i++) {
			result = Calculator.compute(result, operands[i+1], operators[i]);
		}
		return result;
	}
}
