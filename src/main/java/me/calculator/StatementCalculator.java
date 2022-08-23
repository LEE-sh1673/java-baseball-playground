package me.calculator;

public class StatementCalculator {

	private final StatementParser statementParser;

	public StatementCalculator(final StatementParser statementParser) {
		this.statementParser = statementParser;
	}

	public int compute() {
		String[] operators = statementParser.getOperators();
		int[] operands = statementParser.getOperands();

		int result = operands[0];
		for (int i = 0; i < operators.length; i++) {
			result = Calculator.compute(result, operands[i+1], operators[i]);
		}
		return result;
	}
}
