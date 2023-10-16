package baseball;

import java.util.Objects;

public class Hint {
    private static final int ALL_STRIKE = 3;
    private final int ball;
    private final int strike;

    public Hint(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hint)) {
            return false;
        }
        Hint hint = (Hint) o;
        return ball == hint.ball && strike == hint.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }

    public boolean isAllStrike() {
        return strike == ALL_STRIKE;
    }
}
