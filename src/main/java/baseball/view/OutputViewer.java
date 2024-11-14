package baseball.view;

import baseball.dto.CountDto;
import java.util.StringJoiner;

public class OutputViewer {

    public void result(CountDto dto) {
        StringJoiner joiner = new StringJoiner(" ");

        if (dto.strike() == 0 && dto.ball() == 0) {
            System.out.println("낫싱");
            return;
        }

        if (dto.ball() > 0) {
            joiner.add(dto.ball() + "볼");
        }

        if (dto.strike() > 0) {
            joiner.add(dto.strike() + "스트라이크");
        }

        System.out.println(joiner);

        if (dto.strike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
