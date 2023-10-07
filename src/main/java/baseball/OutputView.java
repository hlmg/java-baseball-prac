package baseball;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    public static final String SPACE = " ";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printGameResult(Hint hint) {
        if (hint.getBall() == 0 && hint.getStrike() == 0) {
            printNothing();
        } else {
            printHint(hint);
        }
    }

    private void printHint(Hint hint) {
        StringBuilder sb = new StringBuilder();
        if (hint.getBall() > 0 && hint.getStrike() > 0) {
            sb.append(hint.getBall()).append(BALL);
            sb.append(SPACE);
            sb.append(hint.getStrike()).append(STRIKE);
        } else if (hint.getBall() > 0) {
            sb.append(hint.getBall()).append(BALL);
        } else if (hint.getStrike() > 0) {
            sb.append(hint.getStrike()).append(STRIKE);
        }
        System.out.println(sb);
    }

    private void printNothing() {
        System.out.println(NOTHING);
    }
}
