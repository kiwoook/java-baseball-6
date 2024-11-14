package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumTest {

    @Test
    @DisplayName("정상 입력 테스트")
    void test1() {
        for (int i = 1; i <= 9; i++) {
            Num result = Num.from(i);
            assertThat(result).isNotNull();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("범위를 넘어서는 입력 시 예외 발생")
    void test2(int value) {
        assertThrows(IllegalArgumentException.class, () -> {
            Num.from(value);
        });
    }

    @Test
    @DisplayName("스트링: 정상 입력 테스트")
    void test3() {

        for (int i = 1; i <= 9; i++) {
            String value = String.valueOf(i);
            Num result = Num.from(value);
            assertThat(result).isNotNull();
        }

    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "123415", "0", "10", "1.0", "0.99999999999999999"})
    @DisplayName("잘못된 문자열 입력시 예외 발생")
    void test4(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Num.from(input);
        });
    }
}
