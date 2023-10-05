package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void 정상_입력() {
        assertThatNoException()
                .isThrownBy(() -> Validator.playerNumberValidate("123"));
    }

    @Test
    void checkLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.playerNumberValidate("1"));
    }

    @Test
    void checkNumeric() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.playerNumberValidate("11a"));
    }

    @Test
    void checkInRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.playerNumberValidate("110"));
    }
}
