package feedback;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringCalculatorTest {

    private final String STATEMENT = "2 + 3 * 4 / 2";

    @DisplayName("주어진 문장으로부터 단어들을 얻어올 수 있다.")
    @ParameterizedTest
    @MethodSource("provideStatementsForSplit")
    void testSplit_providedStatement_shouldReturnSplitWords(
        final String statement, final String[] expected) {

        String[] words = StatementSplitter.split(statement);
        assertThat(words.length).isEqualTo(expected.length);
        assertThat(words).containsExactly(expected);
    }

    private static Stream<Arguments> provideStatementsForSplit() {
        return Stream.of(
            Arguments.of("2 + 3 * 4 / 2", new String[]{"2", "+", "3", "*", "4", "/", "2"}),
            Arguments.of("3 - 10 + 100", new String[]{"3", "-", "10", "+", "100"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideSplitWordsForGetOperands")
    @DisplayName("주어진 단어들로부터 피연산자를 얻어올 수 있다.")
    void testGetOperands_givenSplitWords_shouldReturnOperands(
        final String[] words,
        final int[] expected) {

        StatementParser parser = new StatementParser(words);
        int[] operands = parser.getOperands();

        System.out.println("operands = " + Arrays.toString(operands));

        assertThat(operands.length).isEqualTo(expected.length);
        assertThat(operands).containsExactly(expected);
    }

    private static Stream<Arguments> provideSplitWordsForGetOperands() {
        return Stream.of(
            Arguments.of(
                new String[]{"2", "+", "3", "*", "4", "/", "2"},
                new int[]{2, 3, 4, 2}
            ),
            Arguments.of(
                new String[]{"3", "-", "10", "+", "100"},
                new int[]{3, 10, 100}
            )
        );
    }

    @Test
    @DisplayName("주어진 단어들로부터 연산자를 얻어올 수 있다.")
    void testGetOperands_givenSplitWords_shouldReturnOperands() {
        String[] words = StatementSplitter.split(STATEMENT);
        StatementParser parser = new StatementParser(words);
        String[] operators = parser.getOperators();

        assertThat(operators.length).isEqualTo(3);
        assertThat(operators).containsExactly("+", "*", "/");
    }
}
