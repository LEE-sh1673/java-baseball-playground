package me.lee_sh1673.numberbaseball;

import static me.lee_sh1673.numberbaseball.Attributes.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballGameProcessor {

	private String answer;

	private String[] guessNumbers;

	private final BaseBallStatus[] gameStatus;

	public BaseballGameProcessor() {
		Random random = new Random();
		this.guessNumbers = new String[NUMBER_OF_GUESS];
		this.gameStatus = new BaseBallStatus[NUMBER_OF_GUESS];

		this.answer = IntStream.range(0, 30)
			.map(el -> random.nextInt(DIGIT_LIMITATION))
			.distinct()
			.limit(NUMBER_OF_GUESS)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining());

		Arrays.fill(this.gameStatus, BaseBallStatus.NOTHING);
	}

	public void processUserInput() {
		Scanner sc = new Scanner(System.in);
		String guess = sc.nextLine();

		this.guessNumbers = guess.chars()
			.mapToObj(el -> String.valueOf(el - 48))
			.toArray(String[]::new);
	}

	public int getOptionFromUser() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public void compareAnswerWithGuessNumber() {
		for (int i = 0; i < guessNumbers.length; i++) {
			compareAnswerWith(guessNumbers[i], i);
		}
	}

	private void compareAnswerWith(final String number, final int position) {

		if (answer.indexOf(number) == position) {
			gameStatus[position] = BaseBallStatus.STRIKE;
			return;
		}

		BaseBallStatus status = BaseBallStatus.NOTHING;

		if (answer.contains(number)) {
			status = BaseBallStatus.BALL;
		}
		gameStatus[position] = status;
	}

	public boolean isAllStrikes() {
		return Arrays
			.stream(gameStatus)
			.allMatch(status -> status.equals(BaseBallStatus.STRIKE));
	}

	private long getNumberOfStatusBy(final BaseBallStatus baseBallStatus) {
		return Arrays.stream(gameStatus)
			.filter(status -> status.equals(baseBallStatus))
			.count();
	}

	public Map<BaseBallStatus, Long> getGameResults() {

		final Map<BaseBallStatus, Long> currentGameStatus
			= new HashMap<>();

		for (final BaseBallStatus status : gameStatus) {
			currentGameStatus.put(status, getNumberOfStatusBy(status));
		}
		return currentGameStatus;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setGuessNumbers(String[] guessNumbers) {
		this.guessNumbers = guessNumbers;
	}

	public BaseBallStatus[] getGameStatus() {
		return gameStatus;
	}
}
