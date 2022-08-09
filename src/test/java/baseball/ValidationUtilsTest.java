package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

	@DisplayName("야구 숫자 1~9 검증")
	@Test
	void should_Get_Number_BetweenOneToNine() {
		assertThat(ValidationUtils.validateNumber(0)).isFalse();
		assertThat(ValidationUtils.validateNumber(1)).isTrue();
		assertThat(ValidationUtils.validateNumber(9)).isTrue();
	}
}
