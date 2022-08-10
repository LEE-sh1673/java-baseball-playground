package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private final List<Ball> answers;

	public Balls(List<Integer> numbers) {
		this.answers = mapBall(numbers);
	}

	private static List<Ball> mapBall(List<Integer> numbers) {
		final List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			balls.add(new Ball(i + 1, numbers.get(i)));
		}
		return balls;
	}

	BallStatus play(final Ball userBall) {
		return answers.stream()
			.map(ball -> ball.play(userBall))
			.filter(BallStatus::isNotNothing)
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}

	public PlayResult play(final List<Integer> balls) {

		Balls userBalls = new Balls(balls);
		PlayResult result = new PlayResult();

		for (final Ball ball : answers) {
			result.report(userBalls.play(ball));
		}
		return result;
	}
}
