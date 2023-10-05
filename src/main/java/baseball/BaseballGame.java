package baseball;

import java.util.List;

public class BaseballGame {
    Computer computer;

    public BaseballGame(Computer computer) {
        this.computer = computer;
    }

    public void run() {
        List<Integer> computerNumber = computer.generateRandomNumbers();
    }
}
