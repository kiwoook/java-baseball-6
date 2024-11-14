package baseball.config;


import baseball.controller.BaseballController;
import baseball.view.InputViewer;
import baseball.view.OutputViewer;
import baseball.view.impl.InputViewerImpl;
import baseball.view.impl.OutputViewerImpl;

public class BaseballConfig {

    private static final InputViewer inputViewer = new InputViewerImpl();
    private static final OutputViewer outputViewer = new OutputViewerImpl();
    private static final BaseballController baseballController = new BaseballController(inputViewer, outputViewer);

    private BaseballConfig() {
    }

    public static BaseballController getBaseballController() {
        return baseballController;
    }
}
