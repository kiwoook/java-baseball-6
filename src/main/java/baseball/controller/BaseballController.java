package baseball.controller;

import static baseball.utils.Constants.INPUT_LIMIT_LENGTH;

import baseball.dto.CountDto;
import baseball.model.Count;
import baseball.model.Num;
import baseball.model.Nums;
import baseball.model.Target;
import baseball.utils.StringUtils;
import baseball.view.InputViewer;
import baseball.view.OutputViewer;
import java.util.Arrays;
import java.util.List;

public class BaseballController {

    private static final String SEPARATOR = "";
    private static final int ALL_CORRECT = 3;


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
        } while (strike != ALL_CORRECT);

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
        StringUtils.validInput(input);
        String[] splitInput = input.split(SEPARATOR);
        validSplitInput(splitInput);

        return parseNumbers(splitInput);
    }


    private void validSplitInput(String[] splitInput) {
        if (splitInput.length != INPUT_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private List<Num> parseNumbers(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Num::from)
                .toList();
    }
}
