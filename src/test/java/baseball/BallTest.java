package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

	static Ball ball;

	@BeforeAll
	static void setUp() {
		ball = new Ball(1,1);
	}

	@Test
	@DisplayName("NOTHING 반환 테스트")
	void should_get_nothing() {
		PlayStatus status = ball.play(new Ball(3, 5));
		assertThat(status).isEqualTo(PlayStatus.NOTHING);
	}

	@Test
	@DisplayName("STRIKE 반환 테스트")
	void should_get_strike() {
		PlayStatus status = ball.play(new Ball(1, 1));
		assertThat(status).isEqualTo(PlayStatus.STRIKE);
	}

	@Test
	@DisplayName("BALL 반환 테스트")
	void should_get_ball() {
		PlayStatus status = ball.play(new Ball(1, 4));
		assertThat(status).isEqualTo(PlayStatus.BALL);
	}
}
