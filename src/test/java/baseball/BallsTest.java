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
