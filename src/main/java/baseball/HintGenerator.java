package baseball;

import java.util.List;

public class HintGenerator {
    private final List<Integer> computerNumbers;
    private final List<Integer> playerNumbers;

    public HintGenerator(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public Hint getHint() {
        Hint hint = new Hint(0, 0);
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (isSamePosition(i)) {
                hint.incrementStrike();
                continue;
            }
            if (isInComputer(i)) {
                hint.incrementBall();
            }
        }
        return hint;
    }

    private boolean isSamePosition(int i) {
        return computerNumbers.get(i).equals(playerNumbers.get(i));
    }

    private boolean isInComputer(int i) {
        return computerNumbers.contains(playerNumbers.get(i));
    }
}
