package string_calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	StringCalculator cal;

	@BeforeEach
	void setUp() {
		cal = new StringCalculator();
	}

	@DisplayName("공백 문자열 파싱 검증")
	@Test
	void should_parse_empty_string() {
		assertThat(cal.add("")).isEqualTo(0);
		assertThat(cal.add(null)).isEqualTo(0);
	}

	@DisplayName("기본 구분자 파싱 검증")
	@Test
	void should_parse_default_delimiter() {
		assertThat(cal.add("1,2")).isEqualTo(3);
		assertThat(cal.add("1,2,3")).isEqualTo(6);
		assertThat(cal.add("1,2:3")).isEqualTo(6);
	}
}
