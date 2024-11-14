package baseball.mock;

import baseball.view.InputViewer;

public class MockInputViewer implements InputViewer {
    @Override
    public void introduce() {

    }

    @Override
    public String promptInput() {
        return "";
    }

    @Override
    public boolean promptRestart() {
        return false;
    }
}
