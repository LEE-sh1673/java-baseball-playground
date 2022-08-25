package baseball;

public class BaseBallManager {

	private Balls com;

	private static final int GAME_RESTART = 1;

	public BaseBallManager() {
		com = new Balls(NumberGenerator.createNonDuplicatedNumber());
	}

	public void startGame() {
		processGame();
		askForNewGame();
	}

	public void processGame() {
		while (true) {
			System.out.print("숫자를 입력해 주세요: ");
			PlayResult playResult = com.play(InputUtils.getNumbersFromUser());
			ResultView resultView = new ResultView(playResult);
			System.out.println(resultView.getResults());

			if (playResult.isGameEnd()) {
				break;
			}
		}
	}

	public void askForNewGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int option = InputUtils.getGameOptionFromUser();

		if (option == GAME_RESTART) {
			restartGame();
		}
		System.out.println("게임을 종료합니다.");
	}

	public void restartGame() {
		com = new Balls(NumberGenerator.createNonDuplicatedNumber());
		startGame();
	}
}
