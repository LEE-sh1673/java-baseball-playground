package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationUtils {

	private static final int BALLS_SIZE = 3;

	public static void validateDuplicate(final List<Integer> numbers) {
		Set<Integer> hashSet = new HashSet<>(numbers);

		if (hashSet.size() != BALLS_SIZE) {
			throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
		}
	}
}
