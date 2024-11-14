package baseball.model;

public class Count {

    private final int strike;
    private final int ball;


    public Count(Nums nums, Target target) {
        this.strike = nums.countStrike(target);
        this.ball = nums.countBall(target, strike);
    }

    public static Count of(Nums nums, Target target) {
        return new Count(nums, target);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
