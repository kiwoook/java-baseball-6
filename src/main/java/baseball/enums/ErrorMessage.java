package baseball.enums;

public enum ErrorMessage {
    VALID_INPUT("잘못된 입력입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
