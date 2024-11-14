package baseball.dto;

public record CountDto(int strike, int ball) {

    public static CountDto create(int strike, int ball) {
        return new CountDto(strike, ball);
    }
}
