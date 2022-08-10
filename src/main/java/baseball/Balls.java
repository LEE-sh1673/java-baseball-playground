package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private final List<Ball> balls;

	public Balls(List<Integer> numbers) {
		this.balls = mapBall(numbers);
	}

	private static List<Ball> mapBall(List<Integer> numbers) {
		final List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			balls.add(new Ball(i + 1, numbers.get(i)));
		}
		return balls;
	}

	public BallStatus play(final Ball userBall) {
		return balls.stream()
			.map(ball -> ball.play(userBall))
			.filter(BallStatus::isNotNothing)
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}
}
