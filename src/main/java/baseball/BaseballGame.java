package baseball;

import static baseball.BaseballGame.Status.*;

import java.util.List;

public class BaseballGame {
    private static final int ALL_STRIKE = 3;
    private final InputView inputView;
    private final OutputView outputView;
    private Status status;
    Baseballs computer;

    public BaseballGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        status = ENTER;
    }

    public void run() {
        outputView.printGameStart();
        while (status != EXIT) {
            play();
        }
    }

    private void play() {
        if (status == ENTER) {
            generateComputer();
        } else if (status == GAME_START) {
            guessComputer();
        } else if (status == GAME_END) {
            retryOrExit();
        }
    }

    private void generateComputer() {
        List<Integer> generatedRandomNumbers = new RandomNumberGenerator().generateRandomNumbers();
        computer = new Baseballs(generatedRandomNumbers);
        status = GAME_START;
    }

    private void guessComputer() {
        String playerNumber = inputView.getPlayerNumber();
        Baseballs player = new Baseballs(playerNumber);
        int ball = computer.getBall(player);
        int strike = computer.getStrike(player);
        outputView.printGameResult(new Hint(ball, strike));
        if (strike == ALL_STRIKE) {
            outputView.printGameEnd();
            status = GAME_END;
        }
    }

    private void retryOrExit() {
        Command command = Command.from(inputView.getRetryOrEnd());
        if (command == Command.END) {
            status = EXIT;
        } else if (command == Command.RETRY) {
            status = ENTER;
        }
    }

    public enum Status {
        ENTER, GAME_START, GAME_END, EXIT
    }
}
