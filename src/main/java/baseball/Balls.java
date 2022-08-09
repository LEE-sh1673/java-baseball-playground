package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private final List<Ball> balls;

	public Balls(List<Integer> numbers) {
		final List<Ball> balls = new ArrayList<>();

		for (int i = 1; i <= numbers.size(); i++) {
			balls.add(new Ball(i, numbers.get(i - 1)));
		}
		this.balls = balls;
	}

	public BallStatus play(final Ball other) {
		return this.balls.stream()
			.map(ball -> ball.play(other))
			.filter(ballStatus ->
				ballStatus.equals(BallStatus.STRIKE)
				|| ballStatus.equals(BallStatus.BALL))
			.findAny()
			.orElse(BallStatus.NOTHING);
	}
}
