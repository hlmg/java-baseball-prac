package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int RANDOM_NUMBER_LENGTH = 3;
    private static final int RANDOM_NUMBER_START = 1;
    private static final int START = RANDOM_NUMBER_START;
    private static final int END = 9;

    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START, END);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
