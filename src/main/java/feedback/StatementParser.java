package feedback;

import java.util.Arrays;

public class StatementParser {

    private static final String OPERAND_DELIMITER = "-?[0-9]+";

    private static final String OPERATOR_DELIMITER = "[-+*/]|(?<=\\s)";

    private final int[] operands;

    private final String[] operators;

    public StatementParser(final String[] words) {
        this.operands = mapOperands(words);
        this.operators = mapOperators(words);
    }

    private int[] mapOperands(final String[] words) {
        return Arrays.stream(words)
            .filter(StatementParser::isDigit)
            .mapToInt(StatementParser::toPositive)
            .toArray();
    }

    private static boolean isDigit(final String word) {
        return word.matches(OPERAND_DELIMITER);
    }

    private static int toPositive(final String word) {
        int number = Integer.parseInt(word);

        if (number < 0) {
            throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
        }
        return number;
    }

    private String[] mapOperators(final String[] words) {
        return Arrays.stream(words)
            .filter(StatementParser::isOperator)
            .toArray(String[]::new);
    }

    private static boolean isOperator(final String word) {
        return word.matches(OPERATOR_DELIMITER);
    }

    public int[] getOperands() {
        return operands;
    }

    public String[] getOperators() {
        return operators;
    }
}
