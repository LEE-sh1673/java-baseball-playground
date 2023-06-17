package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("주어진 두 숫자에 대한 덧셈을 수행할 수 있다.")
    void add_twoNumber_ReturnAddValue() {
        StringCalculator cal = new StringCalculator();
        assertThat(cal.calculate("2 + 3")).isEqualTo(5);
        assertThat(cal.calculate("0 + 1")).isEqualTo(1);
        assertThat(cal.calculate("2 + 10")).isEqualTo(12);
    }
}
