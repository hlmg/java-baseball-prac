package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseballs {
    private static final String PLAYER_NUMBER_DELIMITER = "";

    public static final int BASEBALLS_LENGTH = 3;
    private final List<Baseball> baseballs;

    public Baseballs(List<Integer> numbers) {
        baseballs = new ArrayList<>();
        addToBaseballs(numbers);
    }

    public Baseballs(String playerNumber) {
        baseballs = new ArrayList<>();
        addToBaseballs(convertBaseballNumbers(playerNumber));
    }

    private void addToBaseballs(List<Integer> numbers) {
        validateLength(numbers);
        convertBalls(numbers);
    }

    private List<Integer> convertBaseballNumbers(String playerNumber) {
        List<Integer> baseballNumbers = new ArrayList<>();
        for (String baseballNumber : playerNumber.split(PLAYER_NUMBER_DELIMITER)) {
            baseballNumbers.add(parseInt(baseballNumber));
        }
        return baseballNumbers;
    }

    private void convertBalls(List<Integer> numbers) {
        for (Integer number : numbers) {
            baseballs.add(new Baseball(number));
        }
    }

    private void convertBalls(String playerNumber) {
        for (String number : playerNumber.split(PLAYER_NUMBER_DELIMITER)) {
            baseballs.add(new Baseball(parseInt(number)));
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != BASEBALLS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int getStrike(Baseballs player) {
        int strike = 0;
        List<Baseball> playerBalls = player.getBalls();
        for (int i = 0; i < BASEBALLS_LENGTH; i++) {
            if (baseballs.get(i).equals(playerBalls.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int getBall(Baseballs player) {
        int ball = 0;
        List<Baseball> playerBalls = player.getBalls();
        for (int i = 0; i < BASEBALLS_LENGTH; i++) {
            if (!baseballs.get(i).equals(playerBalls.get(i)) && baseballs.contains(playerBalls.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public List<Baseball> getBalls() {
        return baseballs;
    }
}
