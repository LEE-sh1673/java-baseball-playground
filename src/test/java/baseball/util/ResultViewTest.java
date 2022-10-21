package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Balls;
import baseball.domain.PlayResult;
import baseball.ui.ResultView;

public class ResultViewTest {
	
	static Balls com;
	
	@BeforeAll
	static void setUp() {
		com = new Balls(Arrays.asList(1, 2, 3));
	}
	
	@DisplayName("3 스트라이크 테스트")
	@Test
	void should_display_three_strike() {
		PlayResult result = com.play(Arrays.asList(1, 2, 3));
		ResultView resultView = new ResultView(result);
		String currentGameResults = resultView.getResults();
		assertThat(currentGameResults).isEqualTo("3 스트라이크");
	}
	
	@DisplayName("삼진 아웃 테스트")
	@Test
	void should_display_three_out() {
		PlayResult result = com.play(Arrays.asList(4, 5, 6));
		ResultView resultView = new ResultView(result);
		String currentGameResults = resultView.getResults();
		assertThat(currentGameResults).isEqualTo("3 아웃");
	}

	@DisplayName("1스트라이크 2볼 테스트")
	@Test
	void should_display_one_strike_two_ball() {
		PlayResult result = com.play(Arrays.asList(1, 3, 2));
		ResultView resultView = new ResultView(result);
		String currentGameResults = resultView.getResults();
		assertThat(currentGameResults).isEqualTo("1 스트라이크 2볼");
	}
}
