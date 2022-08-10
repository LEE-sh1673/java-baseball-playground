package baseball;

import java.util.Objects;

public class Ball {

	private final int position;

	private final BallNumber number;

	public Ball(int position, int number) {
		this.position = position;
		this.number = new BallNumber(number);
	}

	public BallStatus play(final Ball ball) {

		Objects.requireNonNull(ball);

		if (this.equals(ball)) {
			return BallStatus.STRIKE;
		}

		if (ball.matchBallNumber(number)) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}

	private boolean matchBallNumber(final BallNumber number) {
		return this.number.equals(number);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Ball other = (Ball)o;
		return this.position == other.position
			&& this.number.equals(other.number);
	}
}
