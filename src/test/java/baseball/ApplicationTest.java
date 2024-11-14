package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("스트라이크, 볼 검증 테스트")
    void test1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "918", "319", "312"
                            , "189", "129",
                            "921", "132", "123", "2");
                    assertThat(output()).contains("낫싱", "1볼", "2볼", "3볼",
                            "1스트라이크", "2스트라이크",
                            "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료"
                    );
                },
                1, 2, 3
        );
    }

    @Test
    @DisplayName("재시작 검증 테스트")
    void test2() {
        assertRandomNumberInRangeTest(() -> {
            run("123", "1", "123", "2");
            assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }, 1, 2, 3, 1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "-1234", "1200", "012", "42142134"})
    void 예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
