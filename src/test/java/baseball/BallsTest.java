package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallsTest {

	static Balls balls;

	@BeforeAll
	static void setUp() {
		balls = new Balls(Arrays.asList(1, 2, 3));
	}

	@Test
	@DisplayName("N:1 비교 테스트::NOTHING")
	void should_get_nothing() {
		PlayStatus status = balls.play(new Ball(4, 5));
		assertThat(status).isEqualTo(PlayStatus.NOTHING);
	}

	@Test
	@DisplayName("N:1 비교 테스트::BALL")
	void should_get_ball() {
		PlayStatus status = balls.play(new Ball(1, 4));
		assertThat(status).isEqualTo(PlayStatus.BALL);
	}

	@ParameterizedTest(name = "[{index} = {0}] {displayName}")
	@ValueSource(strings = {"1:1", "2:2", "3:3"})
	@DisplayName("N:1 비교 테스트::STRIKE")
	void should_get_strike(final String args) {
		String[] arguments = args.split(":");
		int value = Integer.parseInt(arguments[0]);
		int position = Integer.parseInt(arguments[1]);

		PlayStatus status
			= balls.play(new Ball(value, position));
		assertThat(status).isEqualTo(PlayStatus.STRIKE);
	}
}
