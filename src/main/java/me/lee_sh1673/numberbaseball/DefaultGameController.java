package me.lee_sh1673.numberbaseball;

public class DefaultGameController implements NumberBaseballController {

	private BaseballInputView inputView;

	private BaseballResultView resultView;

	private final BaseballGameProcessor gameProcessor;

	public DefaultGameController() {
		this.inputView = new DefaultInputView();
		this.resultView = new DefaultResultView();
		this.gameProcessor = new BaseballGameProcessor();
	}

	@Override
	public void startGame() {
		while (!gameProcessor.isAllStrikes()) {
			// 시작 화면 출력
			inputView.displayInputView();

			// 입력처리
			gameProcessor.processUserInput();
			gameProcessor.processCompareNumbers();

			// 결과 화면 출력
			resultView.displayResultView(gameProcessor.getGameResults());
		}
		askForNewGame();
	}

	private void askForNewGame() {
		inputView.displayAskForNewGameView();
		int option = gameProcessor.getOptionFromUser();

		if (option == 2) {
			System.exit(0);
		}
		startGame();
	}

	public void setInputView(BaseballInputView inputView) {
		this.inputView = inputView;
	}

	public void setResultView(BaseballResultView resultView) {
		this.resultView = resultView;
	}
}
