package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        Validator.playerNumberValidate(playerNumber);
        return stringToIntegerList(playerNumber);
    }

    private List<Integer> stringToIntegerList(String string) {
        return Arrays.stream(string.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getRetryOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = Console.readLine();
        Validator.validateGameCommand(command);
        return Integer.parseInt(command);
    }
}
