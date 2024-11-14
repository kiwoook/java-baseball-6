package baseball;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final BaseballController baseballController = BaseballConfig.getBaseballController();

    public static void main(String[] args) {
        try {
            baseballController.startGame();
        } finally {
            Console.close();
        }
    }
}
