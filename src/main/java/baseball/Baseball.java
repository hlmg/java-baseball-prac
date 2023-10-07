package baseball;

import java.util.Objects;

public class Baseball {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final int num;

    public Baseball(int num) {
        validate(num);
        this.num = num;
    }

    private void validate(int num) {
        if (num < MIN_NUMBER || MAX_NUMBER < num) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Baseball)) {
            return false;
        }
        Baseball baseball = (Baseball) o;
        return num == baseball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
