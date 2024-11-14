package baseball.model;

import java.util.List;

public class Count {

    private final int strike;
    private final int ball;


    public Count(List<Num> items, Target target) {
        validNums(items);
        this.strike = target.countStrike(items);
        this.ball = target.countBall(items, strike);
    }

    public static Count of(List<Num> items, Target target) {
        return new Count(items, target);
    }


    private void validNums(List<Num> items) {
        if (items.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
