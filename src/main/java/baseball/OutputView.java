package baseball;

public class OutputView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
        if (hint.getBall() > 0) {
            sb.append(hint.getBall()).append("볼");
        }
        if (hint.getStrike() > 0) {
            sb.append(hint.getStrike()).append("스트라이크");
        }
        System.out.println(sb);
    }

    private void printNothing() {
        System.out.println("낫싱");
    }
}
