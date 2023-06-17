package feedback;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
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
            Arguments.of("2 + 3 * 4 / 2", new String[] { "2", "+", "3", "*", "4", "/", "2"}),
            Arguments.of("3 - 10 + 100", new String[] { "3", "-", "10", "+", "100"})
        );
    }
}
