package string_calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = "[,:]";

	public int add(final String numbers) {

		if (isNullOrEmpty(numbers)) {
			return 0;
		}
		return computeNumbers(numbers, getDelimiter(numbers));
	}

	boolean isNullOrEmpty(final String numbers) {
		return numbers == null || numbers.isEmpty();
	}

	String getDelimiter(final String numbers) {
		Matcher matcher = Pattern
			.compile("//+(.)\\n(.*)")
			.matcher(numbers);

		if (matcher.find()) {
			return matcher.group(1);
		}
		return DEFAULT_DELIMITER;
	}

	int computeNumbers(final String numbers, final String delimiter) {
		return Arrays.stream(numbers.split(delimiter))
			.map(String::trim)
			.filter(this::isDigit)
			.mapToInt(Integer::valueOf)
			.sum();
	}

	boolean isDigit(final String number) {
		return number.matches("[0-9]");
	}
}
