package baseball;

public class PlayResult {

	// private final Map<BallStatus, Integer> totalBallStatus;

	private int strikes = 0;

	private int balls = 0;


	public PlayResult() {
		// totalBallStatus = new HashMap<>();
		// for (final BallStatus status : BallStatus.values()) {
		// 	totalBallStatus.put(status, 0);
		// }
	}

	public int getStrike() {
		return strikes;
		// return totalBallStatus.get(BallStatus.STRIKE);
	}

	public int getBall() {
		return balls;
		// return totalBallStatus.get(BallStatus.BALL);
	}

	public void report(BallStatus status) {

		if (status.isStrike()) {
			strikes++;
		}

		if (status.isBall()) {
			balls++;
		}
		// totalBallStatus.put(status, totalBallStatus.get(status) + 1);
	}

	public boolean isGameEnd() {
		return strikes == 3;
	}
}
