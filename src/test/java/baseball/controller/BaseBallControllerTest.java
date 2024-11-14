package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.mock.MockInputViewer;
import baseball.mock.MockOutputViewer;
import baseball.model.Num;
import baseball.view.InputViewer;
import baseball.view.OutputViewer;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallControllerTest {

    private final InputViewer mockInputViewer = new MockInputViewer();
    private final OutputViewer mockOutputViewer = new MockOutputViewer();

    private final BaseballController baseballController = new BaseballController(mockInputViewer,
            mockOutputViewer);

    @RepeatedTest(9999)
    void test1() {
        List<Num> randomNumber = baseballController.createRandomNumber();
        boolean result = randomNumber.size() == Set.copyOf(randomNumber).size();

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1123", "asbcd","12a", "abc"} )
    @DisplayName("")
    void test2(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
           baseballController.getNumbers(input);
        });
    }


}
