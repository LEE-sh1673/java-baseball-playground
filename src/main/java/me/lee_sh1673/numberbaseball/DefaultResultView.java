package me.lee_sh1673.numberbaseball;

import java.util.Map;

public class DefaultResultView implements BaseballResultView {

	@Override
	public void displayResultView(Map<BaseBallStatus, Long> baseBallStatus) {

		if (baseBallStatus.get(BaseBallStatus.STRIKE) == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return;
		}
		if (baseBallStatus.get(BaseBallStatus.NOTHING) == 3) {
			System.out.println("낫싱");
			return;
		}
		showDifferences(baseBallStatus);
	}

	private void showDifferences(final Map<BaseBallStatus, Long> baseBallStatus) {
		final StringBuilder sb = new StringBuilder();
		long numberOfBalls = baseBallStatus.get(BaseBallStatus.BALL);
		long numberOfStrikes = baseBallStatus.get(BaseBallStatus.STRIKE);

		if (numberOfBalls != 0) {
			sb.append(numberOfBalls)
				.append("볼 ");
		}
		if (numberOfStrikes != 0) {
			sb.append(numberOfStrikes)
				.append("스트라이크");
		}
		System.out.println(sb.append('\n'));
	}
}
