package string_calculator;

import java.util.Arrays;

public class StringCalculator {

	public int add(final String number) {

		if (number == null || number.isEmpty()) {
			return 0;
		}
		return Arrays
			.stream(number.split("[,:]"))
			.mapToInt(Integer::parseInt)
			.sum();
	}
}
