package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.domain.Ball;
import baseball.domain.BallStatus;

public class BallTest {

	private Ball com;

	@BeforeEach
	void setUp() {
		com = new Ball(1, 4);
	}

	@Test
	void should_get_nothing() {
		BallStatus ballStatus = com.play(new Ball(2, 5));
		assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
	}

	@Test
	void should_get_ball() {
		BallStatus ballStatus = com.play(new Ball(2, 4));
		assertThat(ballStatus).isEqualTo(BallStatus.BALL);
	}

	@Test
	void should_get_strike() {
		BallStatus ballStatus = com.play(new Ball(1, 4));
		assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
	}
}
