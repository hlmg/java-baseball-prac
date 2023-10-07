package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseballsTest {

    @Nested
    class Constructor {
        @Test
        void 세_자리가_아니면_예외_발생() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Baseballs("12"));
        }

        @Test
        void 숫자가_아니면_예외_발생() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Baseballs("12a"));
        }

        @Test
        void String_성공() {
            Baseballs baseballs = new Baseballs("123");

            List<Baseball> balls = baseballs.getBalls();

            assertThat(balls).isEqualTo(List.of(new Baseball(1), new Baseball(2), new Baseball(3)));
        }

        @Test
        void List_성공() {
            Baseballs baseballs = new Baseballs(List.of(1, 2, 3));

            List<Baseball> balls = baseballs.getBalls();

            assertThat(balls).isEqualTo(List.of(new Baseball(1), new Baseball(2), new Baseball(3)));
        }
    }

    @Test
    void 숫자와_자릿수가_일치하는_경우() {
        Baseballs baseballs1 = new Baseballs(List.of(1, 2, 3));
        Baseballs baseballs2 = new Baseballs(List.of(1, 2, 3));

        int ball = baseballs1.getBall(baseballs2);
        int strike = baseballs1.getStrike(baseballs2);

        assertThat(ball).isEqualTo(0);
        assertThat(strike).isEqualTo(3);
    }

    @Test
    void 숫자의_자릿수만_같은_경우() {
        Baseballs baseballs1 = new Baseballs(List.of(1, 2, 3));
        Baseballs baseballs2 = new Baseballs(List.of(3, 1, 2));

        int ball = baseballs1.getBall(baseballs2);
        int strike = baseballs1.getStrike(baseballs2);

        assertThat(ball).isEqualTo(3);
        assertThat(strike).isEqualTo(0);
    }

    @Test
    void 아무것도_일치하지_않는_경우() {
        Baseballs baseballs1 = new Baseballs(List.of(1, 2, 3));
        Baseballs baseballs2 = new Baseballs(List.of(4, 5, 6));

        int ball = baseballs1.getBall(baseballs2);
        int strike = baseballs1.getStrike(baseballs2);

        assertThat(ball).isEqualTo(0);
        assertThat(strike).isEqualTo(0);
    }
}
