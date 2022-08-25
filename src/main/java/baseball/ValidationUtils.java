package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationUtils {

	private static final int BALLS_SIZE = 3;

	public static void validateList(final List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);
	}

	static void validateDuplicate(final List<Integer> numbers) {
		Set<Integer> hashSet = new HashSet<>(numbers);

		if (hashSet.size() != BALLS_SIZE) {
			throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
		}
	}

	static void validateSize(final List<Integer> numbers) {

		if (numbers.size() != BALLS_SIZE) {
			throw new IllegalArgumentException("숫자는 3자리어야 합니다.");
		}
	}

	static void validateSize(final String input) {

		if (input.length() != BALLS_SIZE) {
			throw new IllegalArgumentException("숫자는 3자리어야 합니다.");
		}
	}
}
