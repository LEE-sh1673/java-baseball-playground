package me.lee_sh1673.numberbaseball;

import java.util.List;
import java.util.function.Predicate;

public class DefaultResultView implements BaseballResultView {

	private long getNumberOfStatusBy(
		final List<BaseBallStatus> baseBallStatus,
		final Predicate<BaseBallStatus> predicate) {

		return baseBallStatus.stream()
			.filter(predicate)
			.count();
	}

	@Override
	public void displayResultView(List<BaseBallStatus> baseBallStatus) {

		long numberOfBall = getNumberOfStatusBy(
			baseBallStatus,
			status -> status.equals(BaseBallStatus.BALL));

		long numberOfNothing = getNumberOfStatusBy(
			baseBallStatus,
			status -> status.equals(BaseBallStatus.NOTHING));

		long numberOfStrikes = getNumberOfStatusBy(
			baseBallStatus,
			status -> status.equals(BaseBallStatus.STRIKE));

		if (numberOfStrikes == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return;
		}
		showDifferences(numberOfBall, numberOfNothing, numberOfStrikes);
	}

	private void showDifferences(long balls, long nothings, long strikes) {

		if (nothings == 3) {
			System.out.println("낫싱");
			return;
		}

		final StringBuilder sb = new StringBuilder();

		if (balls != 0) {
			sb.append(balls)
				.append("볼 ");
		}
		if (strikes != 0) {
			sb.append(strikes)
				.append("스트라이크");
		}
		System.out.println(sb.append('\n'));
	}
}
