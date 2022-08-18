package baseball;

public class PlayResult {

	private int strikes;

	private int balls;

	public int getStrikes() {
		return this.strikes;
	}

	public int getBalls() {
		return this.balls;
	}

	public void report(final PlayStatus status) {

		if (status.isStrike()) {
			strikes += 1;
		}
		if (status.isBall()) {
			balls += 1;
		}
	}
}
