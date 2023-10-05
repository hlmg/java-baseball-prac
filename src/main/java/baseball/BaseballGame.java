package baseball;

import java.util.List;

public class BaseballGame {
    private final Computer computer;
    private final InputView inputView;

    public BaseballGame(Computer computer, InputView inputView) {
        this.computer = computer;
        this.inputView = inputView;
    }

    public void run() {
        List<Integer> computerNumber = computer.generateRandomNumbers();
        List<Integer> playerNumber = inputView.getPlayerNumber();

    }
}
