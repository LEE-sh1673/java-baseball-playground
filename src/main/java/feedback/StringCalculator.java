package feedback;

public class StringCalculator {

    private final int[] operands;

    private final String[] operators;

    public StringCalculator(final String statement) {
        String[] words = StatementSplitter.split(statement);
        StatementParser parser = new StatementParser(words);
        this.operands = parser.getOperands();
        this.operators = parser.getOperators();
    }

    public int compute() {
        int total = operands[0];
        for (int i = 0; i < operators.length; i++) {
            total = Calculator.compute(total, operands[i+1], operators[i]);
        }
        return total;
    }
}
