package baseball;

public class Ball {
	private final int number;

	private final int position;

	public Ball(int number, int position) {
		this.number = number;
		this.position = position;
	}

	public BallStatus play(final Ball ball) {

		if (number == ball.number) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}
}
