package baseball;

import java.util.List;

public class BaseballGame {
    private final Computer computer;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGame(Computer computer, InputView inputView, OutputView outputView) {
        this.computer = computer;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStart();
        startNewGame();
    }

    private void startNewGame() {
        while(true) {
            List<Integer> computerNumbers = computer.generateRandomNumbers();
            System.out.println(computerNumbers);
            guessPhase(computerNumbers);
            int retryOrEnd = inputView.getRetryOrEnd();
            if (retryOrEnd == 2) {
                return;
            }
        }
    }

    private void guessPhase(List<Integer> computerNumbers) {
        while(true) {
            List<Integer> playerNumbers = inputView.getPlayerNumber();
            Hint hint = new HintGenerator(computerNumbers, playerNumbers).getHint();
            if (hint.getStrike() == 3) {
                outputView.printGameEnd();
                return;
            } else {
                outputView.printGameResult(hint);
            }
        }
    }
}
