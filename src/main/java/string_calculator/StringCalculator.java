package string_calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = "[,:]";

	private static final String CUSTOM_DELIMITER_PATTERN = "//+(.)\\n(.*)";

	private static final String[] OPERATORS = new String[] {
		"\\+", "\\*", "\\^"
	};

	public int add(final String text) {

		if (isNullOrEmpty(text)) {
			return 0;
		}
		int[] numbers = splitNumbers(text, getDelimiter(text));

		if (isNegativeNumberContains(numbers)) {
			throw new RuntimeException("숫자는 양수만 가능합니다.");
		}
		return compute(numbers);
	}

	boolean isNullOrEmpty(final String numbers) {
		return numbers == null || numbers.isEmpty();
	}

	String getDelimiter(final String numbers) {
		Matcher matcher = Pattern
			.compile(CUSTOM_DELIMITER_PATTERN)
			.matcher(numbers);

		if (matcher.find()) {
			return formatDelimiter(matcher.group(1));
		}
		return DEFAULT_DELIMITER;
	}

	String formatDelimiter(final String delimiter) {
		boolean isContains = Arrays.stream(OPERATORS)
			.anyMatch(op -> op.contains(delimiter));

		if (isContains) {
			return "\\" + delimiter;
		}
		return delimiter;
	}

	int[] splitNumbers(final String text, final String delimiter) {
		return Arrays.stream(text.split(delimiter))
			.map(String::trim)
			.filter(this::isDigit)
			.mapToInt(Integer::valueOf)
			.toArray();
	}

	boolean isDigit(final String number) {
		return number.matches("-?\\d");
	}

	private boolean isNegativeNumberContains(final int[] numbers) {
		return Arrays.stream(numbers).anyMatch(number -> number < 0);
	}

	int compute(final int[] numbers) {
		return Arrays.stream(numbers).sum();
	}
}
