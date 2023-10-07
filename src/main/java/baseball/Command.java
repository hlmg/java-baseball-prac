package baseball;

import java.util.Arrays;

public enum Command {
    RETRY("1"), END("2");

    private final String number;

    Command(String number) {
        this.number = number;
    }

    static Command from(String number) {
        return Arrays.stream(Command.values())
                .filter(c -> c.number.equals(number))
                .findAny()
                .orElseThrow((IllegalArgumentException::new));
    }
}
