package baseball;

import java.util.regex.Pattern;

public class Validator {
    public static void playerNumberValidate(String playerNumber) {
        checkLength(playerNumber);
        checkNumeric(playerNumber);
        checkInRange(playerNumber);
    }
    
    private static void checkLength(String playerNumber) {
        if (playerNumber.length() != 3) {
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
        if (!Pattern.matches("^[1-9]+$", playerNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateGameCommand(String command) {
        if (!command.equals("1") && !command.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
