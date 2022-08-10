package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

	Ball ball;

	@BeforeEach
	void setUp() {
		ball = new Ball(1, 1);
	}

	@DisplayName("1:1 숫자 비교::낫싱")
	@Test
	void should_get_nothing() {
		BallStatus status = ball.play(new Ball(2, 5));
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}

	@DisplayName("1:1 숫자 비교::볼")
	@Test
	void should_get_ball() {
		BallStatus status = ball.play(new Ball(1, 5));
		assertThat(status).isEqualTo(BallStatus.BALL);
	}

}
