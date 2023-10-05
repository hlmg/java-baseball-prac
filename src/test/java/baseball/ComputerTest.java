package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("고유한_숫자_세개를_생성해야_한다")
    @Test
    void generateThreeUniqueNumbers() {
        Computer computer = new Computer();

        List<Integer> randomNumbers = computer.generateRandomNumbers();

        Set<Integer> set = new HashSet<>(randomNumbers);
        assertThat(set.size()).isEqualTo(3);
    }
}
