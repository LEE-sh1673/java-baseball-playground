package me.lee_sh1673.numberbaseball;

public class DefaultInputView implements BaseballInputView {

	@Override
	public void displayInputView() {
		System.out.print("숫자를 입력해 주세요 :");
	}

	@Override
	public void displayAskForNewGameView() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
