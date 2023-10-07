package baseball;

import java.util.List;

public class BaseballGame {
    private static final int END = 2;
    private static final int ALL_STRIKE = 3;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStart();
        startNewGame();
    }

    private void startNewGame() {
        while(true) {
            List<Integer> generatedRandomNumbers = new RandomNumberGenerator().generateRandomNumbers();
            Baseballs computer = new Baseballs(generatedRandomNumbers);
            guessPhase(computer);
            int retryOrEnd = inputView.getRetryOrEnd();
            if (retryOrEnd == END) {
                return;
            }
        }
    }

    private void guessPhase(Baseballs computer) {
        while(true) {
            String playerNumber = inputView.getPlayerNumber();
            Baseballs player = new Baseballs(playerNumber);
            Hint hint = new HintGenerator(computer, player).getHint();
            if (hint.getStrike() == ALL_STRIKE) {
                outputView.printGameEnd();
                return;
            } else {
                outputView.printGameResult(hint);
            }
        }
    }
}
