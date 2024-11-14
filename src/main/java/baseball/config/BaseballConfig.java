package baseball.config;


import baseball.controller.BaseballController;
import baseball.view.InputViewer;
import baseball.view.OutputViewer;

public class BaseballConfig {

    private static final InputViewer inputViewer = new InputViewer();
    private static final OutputViewer outputViewer = new OutputViewer();
    private static final BaseballController baseballController = new BaseballController(inputViewer, outputViewer);

    private BaseballConfig() {
    }

    public static BaseballController getBaseballController() {
        return baseballController;
    }
}
