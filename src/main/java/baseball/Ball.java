package baseball;

import java.util.Objects;

public class Ball {

	private final int number;

	private final int position;

	public Ball(int value, int position) {
		this.number = value;
		this.position = position;
	}

	public PlayStatus play(final Ball ball) {
		Objects.requireNonNull(ball);

		if (this.equals(ball)) {
			return PlayStatus.STRIKE;
		}
		if (ball.matchBallNumber(number)) {
			return PlayStatus.BALL;
		}
		return PlayStatus.NOTHING;
	}

	private boolean matchBallNumber(final int number) {
		return this.number == number;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) return true;

		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Ball other = (Ball)obj;
		return other.number == number
			&& other.position == position;
	}
}
