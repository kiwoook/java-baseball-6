package baseball.controller;

import static baseball.utils.Constants.ALL_CORRECT;
import static baseball.utils.Constants.LIMIT_LENGTH;

import baseball.dto.CountDto;
import baseball.model.Num;
import baseball.model.Nums;
import baseball.utils.StringUtils;
import baseball.view.InputViewer;
import baseball.view.OutputViewer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {

    private static final String SEPARATOR = "";


    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    public BaseballController(InputViewer inputViewer, OutputViewer outputViewer) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
    }

    public void startGame() {
        boolean restart;
        inputViewer.introduce();
        do {
            restart = startRound();
        } while (restart);
    }

    public boolean startRound() {
        int strike;
        Nums target = Nums.from(createRandomNumber());
        do {
            strike = findNumber(target);
        } while (strike != ALL_CORRECT);

        return inputViewer.promptRestart();
    }

    public int findNumber(Nums target) {
        String input = inputViewer.promptInput();
        Nums nums = Nums.from(getNumbers(input));
        int strike = nums.countStrike(target);
        int ball = nums.countBall(target, strike);
        CountDto countDto = CountDto.create(strike, ball);

        outputViewer.result(countDto);
        return countDto.strike();
    }


    public List<Num> getNumbers(String input) {
        StringUtils.validInput(input);
        String[] splitInput = input.split(SEPARATOR);

        return parseNumbers(splitInput);
    }

    private List<Num> parseNumbers(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Num::from)
                .toList();
    }

    public List<Num> createRandomNumber() {
        List<Num> computer = new ArrayList<>();
        while (computer.size() < LIMIT_LENGTH) {
            Num randomNumber = Num.from(Randoms.pickNumberInRange(1, 9));
            if (computer.contains(randomNumber)) {
                continue;
            }
            computer.add(randomNumber);
        }

        return computer;
    }
}
