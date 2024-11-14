package baseball.model;

import static baseball.utils.Constants.LIMIT_LENGTH;

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
        int uniqueNumSize = Set.copyOf(items)
                .size();
        if (items.size() != LIMIT_LENGTH || items.size() != uniqueNumSize) {
            throw new IllegalArgumentException();
        }
    }

    public int countStrike(Nums target) {
        List<Num> targetItems = target.items;

        int count = 0;
        for (int i = 0; i < LIMIT_LENGTH; i++) {
            if (targetItems.get(i).equals(items.get(i))) {
                count++;
            }
        }

        return count;
    }

    public int countBall(Nums target, int strike) {
        List<Num> targetItems = target.items;

        int count = 0;
        for (int i = 0; i < LIMIT_LENGTH; i++) {
            if (items.contains(targetItems.get(i))) {
                count++;
            }
        }

        return count - strike;
    }
}
