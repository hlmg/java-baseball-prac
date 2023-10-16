package baseball;

import static baseball.BaseballGame.Status.*;

import java.util.List;

public class BaseballGame {
    private final InputView inputView;
    private final OutputView outputView;
    private Status status;
    private Baseballs computer;

    public BaseballGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        status = PLAY;
    }

    public void run() {
        outputView.printGameStart();
        while (!status.isExit()) {
            computer = generateComputer();
            play();
            retry();
        }
    }

    private Baseballs generateComputer() {
        List<Integer> generatedRandomNumbers = new RandomNumberGenerator().generateRandomNumbers();
        return new Baseballs(generatedRandomNumbers);
    }

    private void play() {
        while (!status.isEnd()) {
            String playerNumber = inputView.getPlayerNumber();
            Baseballs player = new Baseballs(playerNumber);

            int strike = computer.getStrike(player);
            int ball = computer.getStrike(player);
            Hint hint = new Hint(strike, ball);

            outputView.printGameResult(hint);
            status = Status.from(hint);
        }
        outputView.printGameEnd();
    }

    private void retry() {
        Command command = Command.from(inputView.getRetryOrEnd());
        status =  Status.from(command);
    }

    public enum Status {
        PLAY,
        END,
        EXIT;

        public static Status from(Hint hint) {
            if (hint.isAllStrike()) {
                return END;
            }
            return PLAY;
        }

        public static Status from(Command command) {
            if (command == Command.RETRY) {
                return PLAY;
            }
            return EXIT;
        }

        public boolean isExit() {
            return this == EXIT;
        }

        public boolean isEnd() {
            return this == END;
        }
    }
}
