package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String PLAYER_NUMBER_DELIMITER = "";

    public List<Integer> getPlayerNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerNumber = Console.readLine();
        Validator.playerNumberValidate(playerNumber);
        return stringToIntegerList(playerNumber);
    }

    private List<Integer> stringToIntegerList(String string) {
        return Arrays.stream(string.split(PLAYER_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getRetryOrEnd() {
        System.out.println(RETRY_MESSAGE);
        String command = Console.readLine();
        Validator.validateGameCommand(command);
        return Integer.parseInt(command);
    }
}
