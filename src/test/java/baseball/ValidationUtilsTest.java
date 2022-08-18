package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

	@Test
	@DisplayName("숫자 검증 테스트 (1~9)")
	void should_validate_number() {
		assertThat(ValidationUtil.validateNumber(9)).isTrue();
		assertThat(ValidationUtil.validateNumber(1)).isTrue();
		assertThat(ValidationUtil.validateNumber(0)).isFalse();
	}

}
