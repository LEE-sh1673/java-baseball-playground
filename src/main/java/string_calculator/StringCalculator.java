package string_calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = "[,:]";

	private static final String CUSTOM_DELIMITER_PATTERN = "//+(.)\\n(.*)";

	private static final String OPERATORS = "+*^";

	public int add(final String text) {

		if (isNullOrEmpty(text)) {
			return 0;
		}
		return sum(toInts(split(text)));
	}

	private boolean isNullOrEmpty(final String numbers) {
		return numbers == null || numbers.isEmpty();
	}

	private String[] split(final String text) {
		final String delimiter = getDelimiter(text);
		return text.split(delimiter);
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

	private String formatDelimiter(final String delimiter) {

		if (OPERATORS.contains(delimiter)) {
			return "\\" + delimiter;
		}
		return delimiter;
	}

	private int[] toInts(final String[] values) {
		return Arrays.stream(values)
			.map(String::trim)
			.filter(this::isDigit)
			.mapToInt(this::toPositive)
			.toArray();
	}

	private boolean isDigit(final String number) {
		return number.matches("-?\\d");
	}

	private int toPositive(final String value) {
		int number = Integer.parseInt(value);

		if (number < 0) {
			throw new RuntimeException("숫자는 양수만 가능합니다.");
		}
		return number;
	}

	private int sum(final int[] numbers) {
		return Arrays.stream(numbers).sum();
	}
}
