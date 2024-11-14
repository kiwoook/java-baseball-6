package baseball.view.impl;

import baseball.enums.Confirmation;
import baseball.view.InputViewer;
import camp.nextstep.edu.missionutils.Console;

public class InputViewerImpl implements InputViewer {

    public void introduce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String promptInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public boolean promptRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Confirmation.validInput(Console.readLine());
    }

}
