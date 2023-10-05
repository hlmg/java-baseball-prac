package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> getPlayerNumber() {
        String playerNumber = Console.readLine();
        Validator.playerNumberValidate(playerNumber);
        return stringToIntegerList(playerNumber);
    }

    private List<Integer> stringToIntegerList(String string) {
        return Arrays.stream(string.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
