package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private final StringCalculator cal = new StringCalculator();

    @Test
    @DisplayName("주어진 두 숫자에 대한 덧셈을 수행할 수 있다.")
    void add_twoNumber_ReturnAddValue() {
        assertThat(cal.calculate("2 + 3")).isEqualTo(5);
        assertThat(cal.calculate("0 + 1")).isEqualTo(1);
        assertThat(cal.calculate("2 + 10")).isEqualTo(12);
    }

    @Test
    @DisplayName("주어진 두 숫자에 대한 뺄셈을 수행할 수 있다.")
    void sub_twoNumber_ReturnSubValue() {
        assertThat(cal.calculate("2 - 10")).isEqualTo(-8);
        assertThat(cal.calculate("20 - 17")).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 두 숫자에 대한 곱셈을 수행할 수 있다.")
    void mul_twoNumber_ReturnMulValue() {
        assertThat(cal.calculate("2 * 10")).isEqualTo(20);
        assertThat(cal.calculate("200 * 10")).isEqualTo(2000);
        assertThat(cal.calculate("15 * 15")).isEqualTo(225);
    }

    @Test
    @DisplayName("주어진 두 숫자에 대한 나눗셈을 수행할 수 있다.")
    void div_twoNumber_ReturnDivValue() {
        assertThat(cal.calculate("10 / 2")).isEqualTo(5);
        assertThat(cal.calculate("4 / 4")).isEqualTo(1);
        assertThat(cal.calculate("44 / 2")).isEqualTo(22);
    }


    @Test
    @DisplayName("주어진 두 숫자 이상에 대한 연산을 수행할 수 있다.")
    void add_threeNumber_ReturnAddValue() {
        assertThat(cal.calculate("2 + 3 + 4")).isEqualTo(9);
        assertThat(cal.calculate("2 + 3 * 4")).isEqualTo(20);
        assertThat(cal.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
