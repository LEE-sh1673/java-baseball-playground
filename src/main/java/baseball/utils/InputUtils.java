package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {

	public static List<Integer> getNumbersFromUser() {
		String input = Console.readLine();
		ValidationUtils.validateSize(input);
		return toIntegerList(input);
	}

	private static List<Integer> toIntegerList(final String input) {
		List<Integer> numbers = getListFrom(input);
		ValidationUtils.validateList(numbers);
		return numbers;
	}

	private static List<Integer> getListFrom(final String str) {
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			integers.add(charToInt(str.charAt(i)));
		}
		return integers;
	}

	private static int charToInt(final char ch) {
		int val = ch - '0';
		if (val < 1 || val > 9) {
			throw new IllegalArgumentException("1부터 9까지의 숫자가 와야 합니다!");
		}
		return val;
	}

	public static int getGameOptionFromUser() {
		String input = Console.readLine();
		return Integer.parseInt(input);
	}
}
