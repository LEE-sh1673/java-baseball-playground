package baseball.domain;

public class PlayResult {

	private int strikes = 0;

	private int balls = 0;

	public PlayResult() {
	}

	public int getStrike() {
		return strikes;
	}

	public int getBall() {
		return balls;
	}

	public void report(BallStatus status) {

		if (status.isStrike()) {
			strikes++;
		}

		if (status.isBall()) {
			balls++;
		}
	}

	public boolean isGameEnd() {
		return strikes == 3;
	}
}
