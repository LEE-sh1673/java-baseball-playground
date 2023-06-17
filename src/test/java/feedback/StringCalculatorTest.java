package feedback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringCalculatorTest {

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
        final String[] words, final int[] expected) {

        StatementParser parser = new StatementParser(words);
        int[] operands = parser.getOperands();
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
    @DisplayName("주어진 피연산자 중 음수가 존재하는 경우 예외를 발생시켜야 한다.")
    void testGetOperands_givenNegativeNumbers_shouldThrowIllegalArgumentException() {
        String statement = "-4 + 10";
        String[] words = StatementSplitter.split(statement);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new StatementParser(words))
            .withMessageContaining("숫자는 양수만 가능합니다.");
    }

    @Test
    @DisplayName("주어진 단어들로부터 연산자를 얻어올 수 있다.")
    void testGetOperators_givenSplitWords_shouldReturnOperands() {
        String STATEMENT = "2 + 3 * 4 / 2";
        StatementParser parser = new StatementParser(StatementSplitter.split(STATEMENT));
        String[] operators = parser.getOperators();

        assertThat(operators.length).isEqualTo(3);
        assertThat(operators).containsExactly("+", "*", "/");
    }

    @ParameterizedTest
    @MethodSource("provideStatementsForCompute")
    @DisplayName("주어진 문자열로부터 사칙연산을 수행할 수 있다.")
    void testCompute_givenStatement_shouldReturnComputedValue(
        final String statement, final int expected) {
        StringCalculator calculator = new StringCalculator(statement);
        assertThat(calculator.compute()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStatementsForCompute() {
        return Stream.of(
            Arguments.of("2 + 3 * 4 / 2", 10),
            Arguments.of("3 - 10 * 2 + 100", 86)
        );
    }
}
