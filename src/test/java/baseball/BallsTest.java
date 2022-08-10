package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

	private Balls balls = null;

	@BeforeEach
	void setUp() {
		balls = new Balls(Arrays.asList(1, 2, 3));
	}

	@DisplayName("N:M 검사::NOTHING")
	@Test
	void should_get_all_nothing() {
		PlayResult result = balls.play(Arrays.asList(4, 5, 6));
		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@DisplayName("N:M검사::1 스트라이크 1볼")
	@Test
	void should_get_one_strike_one_ball() {
		PlayResult result = balls.play(Arrays.asList(1, 4, 2));
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(1);
	}
	@DisplayName("N:M검사::3 스트라이크")
	@Test
	void should_get_three_strike() {
		PlayResult result = balls.play(Arrays.asList(1, 2, 3));
		assertThat(result.getStrike()).isEqualTo(3);
		assertThat(result.getBall()).isEqualTo(0);
		assertThat(result.isGameEnd()).isTrue();
	}

	@DisplayName("요소 검사::ONE_NOTHING")
	@Test
	void should_get_nothing() {
		final Ball ball = new Ball(1, 4);
		BallStatus status = balls.play(ball);
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}

	@DisplayName("요소 검사::ONE_BALL")
	@Test
	void should_get_ball() {
		final Ball ball = new Ball(1, 2);
		BallStatus status = balls.play(ball);
		assertThat(status).isEqualTo(BallStatus.BALL);
	}

	@DisplayName("요소 검사::ONE_STRIKE")
	@Test
	void should_get_strike() {
		final Ball ball = new Ball(1, 1);
		BallStatus status = balls.play(ball);
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}
}
