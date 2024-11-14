package baseball.dto;

import baseball.model.Count;

public record CountDto(int strike, int ball) {

    public static CountDto create(Count count) {
        return new CountDto(count.getStrike(), count.getBall());
    }
}
