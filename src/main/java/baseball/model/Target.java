package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Target {

    private static final int MAX_SIZE = 3;

    private final List<Num> values;

    public Target() {
        this.values = randomNums();
    }

    public static Target create() {
        return new Target();
    }

    public List<Num> randomNums() {
        List<Num> computer = new ArrayList<>();
        while (computer.size() < 3) {
            Num randomNumber = Num.from(Randoms.pickNumberInRange(1, 9));
            if (computer.contains(randomNumber)) {
                continue;
            }
            computer.add(randomNumber);
        }

        return computer;
    }

    public int countStrike(List<Num> input) {
        int count = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            if (values.get(i).equals(input.get(i))) {
                count++;
            }
        }

        return count;
    }

    public int countBall(List<Num> input, int strike) {
        int count = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            if (input.contains(values.get(i))) {
                count++;
            }
        }

        return count - strike;
    }


}
