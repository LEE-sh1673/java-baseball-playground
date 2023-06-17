package feedback;

public class StatementSplitter {

    private static final String SPLIT_WORD_REGEX = "\\s";

    public static String[] split(final String statement) {
        return statement.split(SPLIT_WORD_REGEX);
    }
}
