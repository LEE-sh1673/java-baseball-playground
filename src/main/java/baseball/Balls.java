package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {

	private final List<Ball> balls;

	public Balls(List<Integer> numbers) {
		validateNumbers(numbers);
		balls = mapBalls(numbers);
	}

	private void validateNumbers(List<Integer> numbers) {
		Objects.requireNonNull(numbers);
		if (numbers.size() > 3) {
			throw new IllegalArgumentException("3자리 수를 입력해야 합니다.");
		}
	}

	private List<Ball> mapBalls(List<Integer> numbers) {
		List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < numbers.size(); i++) {
			balls.add(new Ball(numbers.get(i), i+1));
		}
		return balls;
	}

	public PlayStatus play(final Ball other) {
		return balls.stream()
			.map(ball -> ball.play(other))
			.filter(PlayStatus::isNotNothing)
			.findFirst()
			.orElse(PlayStatus.NOTHING);
	}
}
