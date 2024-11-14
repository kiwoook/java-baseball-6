package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ConfirmationTest {

    @Test
    @DisplayName("1일 경우 true를 반환한다.")
    void test1() {
        String input = "1";

        boolean b = Confirmation.validInput(input);
        assertThat(b).isTrue();
    }

    @Test
    @DisplayName("2일 경우 false를 반환한다.")
    void test2() {
        String input = "2";

        boolean b = Confirmation.validInput(input);
        assertThat(b).isFalse();

    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("N과 Y가 아니라면 예외를 반환한다.")
    @ValueSource(strings = {"1234", "12", "Y", "N", "3", "-1", "-2", "2.0", "1.0"})
    void test3(String input) {

        assertThrows(IllegalArgumentException.class, () -> {
            Confirmation.validInput(input);
        });
    }


}
