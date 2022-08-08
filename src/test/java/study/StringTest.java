package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void replace() {
		String actual = "abc".replace("b", "d");
		assertThat(actual).isEqualTo("adc");
	}

	@Test
	void split() {
		String[] values = "1".split(",");
		assertThat(values).contains("1");
		assertThat(values.length).isEqualTo(1);
		values = "1,2".split(",");
		assertThat(values).containsExactly("1", "2");
	}

	@Test
	void charAt() {
		String value = "abc";
		char c = value.charAt(0);
		assertThat(c).isEqualTo('a');

		assertThatThrownBy(() -> value.charAt(value.length()))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}

	@Test
	void substring() {
		String input = "(1,2)";
		String substring = input.substring(1, input.length() - 1);
		assertThat(substring).isEqualTo("1,2");
	}
}
