package baseball;

public class HintGenerator {
    private final Baseballs computer;
    private final Baseballs player;

    public HintGenerator(Baseballs computer, Baseballs player) {
        this.computer = computer;
        this.player = player;
    }

    public Hint getHint() {
        int ball = computer.getBall(player);
        int strike = computer.getStrike(player);
        return new Hint(ball, strike);
    }
}
