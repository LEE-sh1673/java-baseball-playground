package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

    @Test
    @DisplayName("replace() - 'abc'를 'adc'로 바꿀 수 있다.")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split() - '1,2'를 ','로 분리할 수 있다.")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual.length).isEqualTo(2);
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split() - 하나의 문자에 대해 길이가 1인 배열을 반환할 수 있다.")
    void testSplit_oneLetter_then_returnOnlyOne() {
        String[] actual = "1".split(",");
        assertThat(actual.length).isEqualTo(1);
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("substring() - 괄호를 제거한 값을 반환할 수 있다.")
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("charAt() - 특정 위치의 문자를 가져올 수 있다.")
    @ParameterizedTest
    @CsvSource(value={"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAt(final int index, final char expected) {
        char actual = "abc".charAt(index);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt() - 범위에서 벗어난 위치 값 요청 시 StringIndexOutOfBoundException")
    void testCharAt_selectOutOfBoundIndex_then_throwOutOfBoundException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> "abc".charAt(3))
            .withMessage("String index out of range: 3");
    }
}
