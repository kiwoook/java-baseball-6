package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumsTest {

    @Test
    @DisplayName("정상 테스트")
    void test1() {
        List<Integer> integers = List.of(1, 2, 3);
        List<Num> nums = toNums(integers);

        Nums result = Nums.from(nums);

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("숫자가 같으면 에러를 발생한다.")
    void test2() {
        List<Integer> integers = List.of(1, 1, 2);
        List<Num> nums = toNums(integers);

        assertThrows(IllegalArgumentException.class, () -> {
            Nums.from(nums);
        });
    }

    @Test
    @DisplayName("숫자 길이가 많으면 에러를 발생한다.")
    void test3() {
        List<Integer> integers = List.of(1, 2, 3, 4);
        List<Num> nums = toNums(integers);

        assertThrows(IllegalArgumentException.class, () -> {
            Nums.from(nums);
        });
    }

    @Test
    @DisplayName("숫자 길이가 적으면 에러를 발생한다.")
    void test4() {
        List<Integer> integers = List.of(1, 2);
        List<Num> nums = toNums(integers);

        assertThrows(IllegalArgumentException.class, () -> {
            Nums.from(nums);
        });
    }

    @Test
    @DisplayName("1 스트라이크 검증 테스트")
    void test5() {
        List<Integer> integers = List.of(1, 2, 3);
        Nums target = Nums.from(toNums(integers));

        integers = List.of(1, 4, 5);
        Nums nums = Nums.from(toNums(integers));

        assertThat(nums.countStrike(target)).isEqualTo(1);
    }

    @Test
    @DisplayName("2 스트라이크 검증 테스트")
    void test6() {
        List<Integer> integers = List.of(1, 2, 3);
        Nums target = Nums.from(toNums(integers));

        integers = List.of(1, 2, 5);
        Nums nums = Nums.from(toNums(integers));

        assertThat(nums.countStrike(target)).isEqualTo(2);
    }


    @Test
    @DisplayName("3 스트라이크 검증 테스트")
    void test7() {
        List<Integer> integers = List.of(1, 2, 3);
        Nums target = Nums.from(toNums(integers));

        integers = List.of(1, 2, 3);
        Nums nums = Nums.from(toNums(integers));

        assertThat(nums.countStrike(target)).isEqualTo(3);
    }

    @Test
    @DisplayName("1볼 검증 테스트")
    void test9() {
        List<Integer> integers = List.of(9, 1, 8);
        Nums target = Nums.from(toNums(integers));

        integers = List.of(1, 2, 3);
        Nums nums = Nums.from(toNums(integers));

        int strike = nums.countStrike(target);
        assertThat(nums.countBall(target, strike)).isEqualTo(1);
    }

    @Test
    @DisplayName("2볼 검증 테스트")
    void test10() {
        List<Integer> integers = List.of(3, 1, 8);
        Nums target = Nums.from(toNums(integers));

        integers = List.of(1, 2, 3);
        Nums nums = Nums.from(toNums(integers));

        int strike = nums.countStrike(target);
        assertThat(nums.countBall(target, strike)).isEqualTo(2);
    }

    @Test
    @DisplayName("3볼 검증 테스트")
    void test11() {
        List<Integer> integers = List.of(3, 1, 2);
        Nums target = Nums.from(toNums(integers));

        integers = List.of(1, 2, 3);
        Nums nums = Nums.from(toNums(integers));

        int strike = nums.countStrike(target);
        assertThat(nums.countBall(target, strike)).isEqualTo(3);
    }


    private List<Num> toNums(List<Integer> integers) {
        return integers.stream()
                .map(Num::from)
                .toList();
    }
}
