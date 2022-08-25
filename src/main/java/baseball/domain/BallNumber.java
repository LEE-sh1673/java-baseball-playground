package baseball.domain;

public class BallNumber {

	private static final int MIN_NUMBER = 1;

	private static final int MAX_NUMBER = 9;

	private final int number;

	public BallNumber(int number) {

		if (MIN_NUMBER > number || number > MAX_NUMBER) {
			throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야 합니다.");
		}
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) return true;

		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		BallNumber other = (BallNumber)obj;
		return this.number == other.number;
	}
}
