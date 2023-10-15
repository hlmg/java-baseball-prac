package baseball;

import static baseball.BaseballGameController.Status.*;

import java.util.function.Consumer;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballGame baseballGame;
    private Status status;

    public BaseballGameController(InputView inputView, OutputView outputView, BaseballGame baseballGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballGame = baseballGame;
        status = ENTER;
    }

    public void run() {
        while (status != EXIT) {
            status.run(this);
        }
    }

    private void newGame() {
        outputView.printGameStart();
        status = GAME_START;
    }

    private void guessComputer() {
        String playerNumber = inputView.getPlayerNumber();
        Baseballs player = new Baseballs(playerNumber);

        Hint hint = baseballGame.getHint(player);

        outputView.printGameResult(hint);

        if (hint.isAllStrike()) {
            outputView.printGameEnd();
            status = GAME_END;
        }
    }

    private void retryOrExit() {
        Command command = Command.from(inputView.getRetryOrEnd());
        if (command == Command.END) {
            status = EXIT;
        } else if (command == Command.RETRY) {
            baseballGame.reset();
            status = GAME_START;
        }
    }

    public enum Status {
        ENTER(BaseballGameController::newGame),
        GAME_START(BaseballGameController::guessComputer),
        GAME_END(BaseballGameController::retryOrExit),
        EXIT(unused -> {
            throw new IllegalStateException();
        });

        private final Consumer<BaseballGameController> consumer;

        Status(Consumer<BaseballGameController> consumer) {
            this.consumer = consumer;
        }

        public void run(BaseballGameController baseballGameController) {
            consumer.accept(baseballGameController);
        }
    }
}
