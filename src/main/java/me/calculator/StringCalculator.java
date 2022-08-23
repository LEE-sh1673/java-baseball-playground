package me.calculator;

public class StringCalculator {

	private final StatementCalculator calculator;

	public StringCalculator(final String statement) {
		String[] words = StatementSplitter.split(statement);
		StatementParser parser = new StatementParser(words);
		this.calculator = new StatementCalculator(
			parser.getOperators(),
			parser.getOperands());
	}

	public int compute() {
		return calculator.compute();
	}
}
