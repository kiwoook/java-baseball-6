package baseball.model;

import java.util.List;
import java.util.Set;

public class Nums {

    private final List<Num> items;

    public Nums(List<Num> items) {
        validNums(items);
        this.items = items;
    }

    public static Nums from(List<Num> items) {
        return new Nums(items);
    }

    private void validNums(List<Num> items) {
        if (items.size() != 3 || items.size() != Set.copyOf(items).size()) {
            throw new IllegalArgumentException();
        }
    }

    public int countStrike(Target target) {
        return target.countStrike(items);
    }

    public int countBall(Target target, int strike) {
        return target.countBall(items, strike);
    }
}
