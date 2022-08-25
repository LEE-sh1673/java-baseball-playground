package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	public static int createRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}

	public static List<Integer> createNonDuplicatedNumber() {
		return Stream
			.generate(NumberGenerator::createRandomNumber)
			.distinct()
			.limit(3)
			.collect(Collectors.toList());
	}
}
