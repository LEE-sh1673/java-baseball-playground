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

	@DisplayName("커스텀 구분자 구분 검증")
	@Test
	void should_get_correct_custom_delimiter() {
		assertThat(cal.getDelimiter("1,2:3"))
			.isEqualTo("[,:]");
		assertThat(cal.getDelimiter("//;\n1;2;3"))
			.isEqualTo(";");
	}

	@DisplayName("커스텀 구분자 파싱 검증")
	@Test
	void should_parse_custom_delimiter() {
		assertThat(cal.add("//-\n1-2-3")).isEqualTo(6);
		assertThat(cal.add("//*\n1*2*3")).isEqualTo(6);
		assertThat(cal.add("//+\n1+2+3")).isEqualTo(6);
		assertThat(cal.add("//^\n1^2^3")).isEqualTo(6);
	}

	@DisplayName("음수를 포함하는 문자열 검증")
	@Test
	void should_assert_negative_number() {
		assertThatThrownBy(() -> cal.add("1:-2:3"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("숫자는 양수만 가능합니다.");
	}
}
