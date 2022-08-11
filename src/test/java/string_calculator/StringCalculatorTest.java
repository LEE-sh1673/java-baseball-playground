package string_calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@DisplayName("공백 문자열 파싱 검증")
	@Test
	void should_parse_empty_string() {
		StringCalculator cal = new StringCalculator();
		assertThat(cal.add("")).isEqualTo(0);
		assertThat(cal.add(null)).isEqualTo(0);
	}
}
