package baseball.controller;

import baseball.dto.CountDto;
import baseball.model.Count;
import baseball.model.Num;
import baseball.model.Nums;
import baseball.model.Target;
import baseball.view.InputViewer;
import baseball.view.OutputViewer;
import java.util.ArrayList;
import java.util.List;

public class BaseballController {

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    public BaseballController(InputViewer inputViewer, OutputViewer outputViewer) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
    }

    public void startGame() {
        boolean restart;
        do {
            restart = startRound();
        } while (restart);
    }

    public boolean startRound() {
        int strike;
        Target target = Target.create();
        inputViewer.introduce();
        do {
            strike = findNumber(target);
        } while (strike != 3);

        return inputViewer.promptRestart();
    }

    public int findNumber(Target target) {
        String input = inputViewer.promptInput();
        Nums nums = Nums.from(getNumbers(input));
        Count count = Count.of(nums, target);
        CountDto countDto = CountDto.create(count);
        outputViewer.result(countDto);
        return countDto.strike();
    }


    public List<Num> getNumbers(String input) {
        validInput(input);
        String[] splitInput = input.split("");
        validSplitInput(splitInput);

        return parseNumbers(splitInput);
    }

    private void validInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

    }

    private void validSplitInput(String[] splitInput) {
        if (splitInput.length == 0 || splitInput.length > 3) {
            throw new IllegalArgumentException();
        }
    }

    private List<Num> parseNumbers(String[] splitInput) {
        List<Num> input = new ArrayList<>();
        for (String num : splitInput) {
            input.add(Num.from(num));
        }

        return input;
    }
}
