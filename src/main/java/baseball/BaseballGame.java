package baseball;

import static baseball.BaseballGame.Status.*;

import java.util.List;
import java.util.function.Consumer;

public class BaseballGame {
    private static final int ALL_STRIKE = 3;
    private final InputView inputView;
    private final OutputView outputView;
    private Status status;
    private Baseballs computer;

    public BaseballGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        status = ENTER;
    }

    public void run() {
        while (status != EXIT) {
            status.run(this);
        }
    }

    private void newGame() {
        outputView.printGameStart();
        computer = generateComputer();
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
            computer = generateComputer();
            status = GAME_START;
        }
    }

    private Baseballs generateComputer() {
        List<Integer> generatedRandomNumbers = new RandomNumberGenerator().generateRandomNumbers();
        return new Baseballs(generatedRandomNumbers);
    }

    public enum Status {
        ENTER(BaseballGame::newGame),
        GAME_START(BaseballGame::guessComputer),
        GAME_END(BaseballGame::retryOrExit),
        EXIT(unused -> {
            throw new IllegalStateException();
        });

        private final Consumer<BaseballGame> consumer;

        Status(Consumer<BaseballGame> consumer) {
            this.consumer = consumer;
        }

        public void run(BaseballGame baseballGame) {
            consumer.accept(baseballGame);
        }
    }
}
