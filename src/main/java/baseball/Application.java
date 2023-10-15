package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController =
                new BaseballGameController(new InputView(), new OutputView(), new BaseballGame());
        baseballGameController.run();
    }
}
