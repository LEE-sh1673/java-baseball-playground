package me.lee_sh1673.numberbaseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("숫자야구게임 테스트")
class BaseballGameProcessorTest {

	BaseballGameProcessor gameProcessor;

	@BeforeEach
	void setUp() {
		gameProcessor = new BaseballGameProcessor();
	}

	@DisplayName("입력 비교 테스트")
	@Test
	void shouldGetCorrectAnswer() {

		// Given
		String answer = "123";
		String[] guessNumbers = {"1", "2", "3"};

		// When
		gameProcessor.setAnswer(answer);
		gameProcessor.setGuessNumbers(guessNumbers);
		gameProcessor.processCompareNumbers();

		// Then
		assertThat(gameProcessor.isAllStrikes()).isTrue();
	}

	@AfterEach
	void tearDown() {
		gameProcessor = null;
	}

}