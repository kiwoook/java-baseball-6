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


    private List<Num> toNums(List<Integer> integers) {
        return integers.stream().map(Num::from).toList();
    }
}
