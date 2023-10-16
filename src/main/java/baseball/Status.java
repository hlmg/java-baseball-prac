package baseball;

public enum Status {
    PLAY,
    END,
    EXIT;

    public static Status from(Hint hint) {
        if (hint.isAllStrike()) {
            return END;
        }
        return PLAY;
    }

    public static Status from(Command command) {
        if (command == Command.RETRY) {
            return PLAY;
        }
        return EXIT;
    }

    public boolean isExit() {
        return this == EXIT;
    }

    public boolean isEnd() {
        return this == END;
    }
}
