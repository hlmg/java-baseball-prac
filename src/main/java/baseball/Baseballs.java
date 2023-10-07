package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseballs {
    private static final String PLAYER_NUMBER_DELIMITER = "";

    public static final int BASEBALLS_LENGTH = 3;
    private final List<Baseball> balls;
    public Baseballs(String playerNumber) {
        balls = new ArrayList<>();
        convertBalls(playerNumber);
        validateLength();
    }

    public Baseballs(List<Integer> numbers) {
        balls = new ArrayList<>();
        convertBalls(numbers);
    }

    private void convertBalls(List<Integer> numbers) {
        for (Integer number : numbers) {
            balls.add(new Baseball(number));
        }
    }

    private void convertBalls(String playerNumber) {
        for (String number : playerNumber.split(PLAYER_NUMBER_DELIMITER)) {
            balls.add(new Baseball(parseInt(number)));
        }
    }

    private void validateLength() {
        if (balls.size() != BASEBALLS_LENGTH) {
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
            if (balls.get(i).equals(playerBalls.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int getBall(Baseballs player) {
        int ball = 0;
        List<Baseball> playerBalls = player.getBalls();
        for (int i = 0; i < BASEBALLS_LENGTH; i++) {
            if (!balls.get(i).equals(playerBalls.get(i)) && balls.contains(playerBalls.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public List<Baseball> getBalls() {
        return balls;
    }
}
