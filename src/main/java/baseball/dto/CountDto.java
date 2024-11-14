package baseball.dto;

import baseball.model.Count;

public class CountDto {
    private final int strike;
    private final int ball;

    public CountDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static CountDto create(Count count) {
        return new CountDto(count.getStrike(), count.getBall());
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
