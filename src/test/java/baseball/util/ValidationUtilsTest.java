package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.utils.ValidationUtils;

public class ValidationUtilsTest {

	@DisplayName("입력 중복 검증 테스트")
	@Test
	void should_validate_duplicate_correctly() {
		assertThatThrownBy(() ->
				ValidationUtils
					.validateList(Arrays.asList(1, 1, 2))
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("입력 크기 검증 테스트")
	@Test
	void should_validate_size_correctly() {
		assertThatThrownBy(() ->
			ValidationUtils
				.validateList(Arrays.asList(1, 1))
		).isInstanceOf(IllegalArgumentException.class);
	}
}
