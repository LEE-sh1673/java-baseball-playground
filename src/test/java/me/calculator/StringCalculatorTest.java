package me.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	static final String STATEMENT = "2 + 3 * 4 / 2";

	@DisplayName("문자열 파싱 테스트")
	@Test
	void should_parse_correctly() {
		String[] words = StatementSplitter.split(STATEMENT);
		assertThat(words.length).isEqualTo(7);
		assertThat(words).containsExactly("2", "+", "3", "*", "4", "/", "2");
	}
}
