package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new Computer(), new InputView(), new OutputView());
        baseballGame.run();
    }
}
