package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

	@DisplayName("숫자 범위 검증 테스트")
	@Test
	void should_get_correct_number() {
		assertThat(ValidationUtils.validateNumber(9)).isTrue();
		assertThat(ValidationUtils.validateNumber(1)).isTrue();
		assertThat(ValidationUtils.validateNumber(0)).isFalse();
	}

}
