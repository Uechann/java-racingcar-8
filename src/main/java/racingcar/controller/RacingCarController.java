package racingcar.controller;

import racingcar.domain.Attempt;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.service.RacingGame;
import racingcar.util.InputParser;
import racingcar.util.InputValidator;
import racingcar.view.InputView;

public class RacingCarController {

    private final InputView inputView;
    private final CarFactory carFactory;
    private final RacingGame racingGame;

    public RacingCarController() {
        this.inputView = new InputView();
        this.carFactory = new CarFactory();
        this.racingGame = new RacingGame();
    }

    public void run() {
        // 자동차 이름 입력 받기
        String carNamesInput = inputView.inputCarNames();
        InputValidator.validateInputFormat(carNamesInput);
        String[] carNames = InputParser.parseStringToArray(carNamesInput);

        // 시도 횟수 입력 받기
        String attemptCountInput = inputView.inputAttemptCount();
        Attempt attempt = new Attempt(attemptCountInput);

        // 자동차 객체들 생성
        Cars cars = carFactory.createCars(carNames);

        // 게임 실행
        racingGame.run(cars, attempt);
    }
}

