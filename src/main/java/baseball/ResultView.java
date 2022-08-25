package baseball;

public class ResultView {

	private final PlayResult playResult;

	private static final String THREE_STRIKE = "3 스트라이크";

	private static final String THREE_OUT = "3 아웃";

	public ResultView(final PlayResult playResult) {
		this.playResult = playResult;
	}

	public String getResults() {

		if (playResult.isGameEnd()) {
			return THREE_STRIKE;
		}
		int numberOfStrikes = playResult.getStrike();
		int numberOfBalls = playResult.getBall();

		if (numberOfStrikes == 0 && numberOfBalls == 0) {
			return THREE_OUT;
		}
		return String.format("%d 스트라이크 %d볼",
			numberOfStrikes, numberOfBalls);
	}
}
