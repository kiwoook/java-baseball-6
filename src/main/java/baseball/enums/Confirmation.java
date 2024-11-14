package baseball.enums;

public enum Confirmation {
    Y("1"),
    N("2");


    private final String value;

    Confirmation(String value) {
        this.value = value;
    }

    public static boolean validInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.equals(Y.value)) {
            return true;
        }

        if (input.equals(N.value)) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
