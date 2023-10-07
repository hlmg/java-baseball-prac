package baseball;

import java.util.regex.Pattern;

public class Validator {
    private static final String RETRY = "1";
    private static final String EXIT = "2";
    private static final String ONE_TO_NINE = "^[1-9]+$";
    private static final int PLAYER_NUMBER_LENGTH = 3;

    public static void playerNumberValidate(String playerNumber) {
        checkLength(playerNumber);
        checkNumeric(playerNumber);
        checkInRange(playerNumber);
    }
    
    private static void checkLength(String playerNumber) {
        if (playerNumber.length() != PLAYER_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumeric(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInRange(String playerNumber) {
        if (!Pattern.matches(ONE_TO_NINE, playerNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateGameCommand(String command) {
        if (!command.equals(RETRY) && !command.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
    }
}
