package baseball.model;

import baseball.utils.StringUtils;
import java.util.Objects;

public class Num implements Comparable<Num> {

    private final int number;

    private Num(int number) {
        validate(number);
        this.number = number;
    }

    public static Num from(int number) {
        return new Num(number);
    }

    public static Num from(String number) {
        StringUtils.validInput(number);
        return new Num(parseNumber(number));
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int number) {
        if (number <= 0 || number >= 10) {
            throw new IllegalArgumentException("1~9까지의 숫자만 입력가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Num num = (Num) o;
        return number == num.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public int compareTo(Num o) {
        return Integer.compare(number, o.number);
    }
}
