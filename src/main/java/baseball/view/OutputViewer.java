package baseball.view;

import baseball.dto.CountDto;
import java.util.StringJoiner;

public class OutputViewer {

    public void result(CountDto dto) {
        StringJoiner joiner = new StringJoiner(" ");
        if (dto.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (dto.getStrike() == 0 && dto.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }

        if (dto.getBall() > 0) {
            joiner.add(dto.getBall() + "볼");
        }

        if (dto.getBall() > 0) {
            joiner.add(dto.getStrike() + "스트라이크");
        }

        System.out.println(joiner);
    }
}
