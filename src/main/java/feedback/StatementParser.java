package feedback;

import java.util.Arrays;

public class StatementParser {

    private final int[] operands;

    public StatementParser(final String[] words) {
        this.operands = mapOperands(words);
    }

    private int[] mapOperands(final String[] words) {
        return Arrays.stream(words)
            .filter(StatementParser::isDigit)
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    private static boolean isDigit(final String word) {
        return word.matches("[0-9]+");
    }

    public int[] getOperands() {
        return operands;
    }
}
