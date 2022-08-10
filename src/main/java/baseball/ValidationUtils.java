package baseball;

public final class ValidationUtils {

	private static final int MAX_NUMBER = 9;

	private static final int MIN_NUMBER = 1;

	public static boolean validateNumber(final int number) {
		return MIN_NUMBER <= number && number <= MAX_NUMBER;
	}
}
