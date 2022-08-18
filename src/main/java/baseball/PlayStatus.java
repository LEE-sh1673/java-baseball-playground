package baseball;

public enum PlayStatus {
	BALL, STRIKE, NOTHING;

	public boolean isNotNothing() {
		return this != NOTHING;
	}

	public boolean isStrike() {
		return this == STRIKE;
	}

	public boolean isBall() {
		return this == BALL;
	}
}
