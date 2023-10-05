package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class HintGeneratorTest {

    @Test
    void 숫자와_자릿수가_일치하는_경우() {
        HintGenerator hintGenerator = new HintGenerator(List.of(1, 2, 3), List.of(1, 2, 3));

        Hint hint = hintGenerator.getHint();

        assertThat(hint).isEqualTo(new Hint(0, 3));
    }

    @Test
    void 숫자의_자릿수만_같은_경우() {
        HintGenerator hintGenerator = new HintGenerator(List.of(1, 2, 3), List.of(3, 1, 2));

        Hint hint = hintGenerator.getHint();

        assertThat(hint).isEqualTo(new Hint(3, 0));
    }

    @Test
    void 아무것도_일치하지_않는_경우() {
        HintGenerator hintGenerator = new HintGenerator(List.of(1, 2, 3), List.of(4, 5, 6));

        Hint hint = hintGenerator.getHint();

        assertThat(hint).isEqualTo(new Hint(0, 0));
    }
}
