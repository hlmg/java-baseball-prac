package baseball;

import java.util.List;

public class BaseballGame {
    private Baseballs computer;

    public BaseballGame() {
        this.computer = generateComputer();
    }

    public void reset(){
        computer = generateComputer();
    }

    public Hint getHint(Baseballs player) {
        int ball = computer.getBall(player);
        int strike = computer.getStrike(player);
        return new Hint(ball, strike);
    }

    private Baseballs generateComputer() {
        List<Integer> generatedRandomNumbers = new RandomNumberGenerator().generateRandomNumbers();
        return new Baseballs(generatedRandomNumbers);
    }
}
