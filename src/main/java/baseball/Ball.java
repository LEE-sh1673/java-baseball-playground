package baseball;

public class Ball {
	private final int number;

	private final int position;

	public Ball(int number, int position) {
		this.number = number;
		this.position = position;
	}

	public BallStatus play(final Ball ball) {

		if (this.equals(ball)) {
			return BallStatus.STRIKE;
		}

		if (ball.isMatchNumber(number)) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) return true;

		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Ball other = (Ball)obj;
		return this.position == other.position
			&& this.number == other.number;
	}

	private boolean isMatchNumber(final int number) {
		return this.number == number;
	}
}
