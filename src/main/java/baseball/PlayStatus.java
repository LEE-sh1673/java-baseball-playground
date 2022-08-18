package baseball;

public enum PlayStatus {
	BALL, STRIKE, NOTHING;

	public boolean isNotNothing() {
		return this != NOTHING;
	}
}
