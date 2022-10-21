package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.utils.NumberGenerator;

public class RandomNumberTest {

	@DisplayName("랜덤 숫자 생성 테스트")
	@Test
	void should_generate_random_number() {
		int num1 = NumberGenerator.createRandomNumber();
		int num2 = NumberGenerator.createRandomNumber();
		int num3 = NumberGenerator.createRandomNumber();
		assertThat(num1).isBetween(1, 9);
		assertThat(num2).isBetween(1, 9);
		assertThat(num3).isBetween(1, 9);
	}

	@DisplayName("랜덤 3자리 숫자 생성 테스트")
	@Test
	void should_generate_non_duplicated_number() {
		List<Integer> numbers = NumberGenerator.createNonDuplicatedNumber();
		assertThat(numbers.size()).isEqualTo(3);
	}
}
