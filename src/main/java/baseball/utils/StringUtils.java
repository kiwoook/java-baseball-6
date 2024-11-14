package baseball.utils;

import static baseball.enums.ErrorMessage.VALID_INPUT;

public class StringUtils {

    private StringUtils() {
    }

    public static void validInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(VALID_INPUT.getMessage());
        }
    }
}
