package racingcar.domain.service;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingGame {

    private final OutputView outputView = new OutputView();
    private static final int MOVEMENT_CRITERIA = 4;

    // 게임 실행
    public void run(Cars cars, Attempt attempt) {
        for (int i = 0; i < attempt.value(); i++) {
            cars.getCars().forEach(this::attemptOneTry);

            // 각 시도마다 자동차 위치 출력
            outputView.printCarsPosition(cars);
        }
    }

    private void attemptOneTry(Car car) {
        // 랜덤 숫자 생성 후 판단
        int num = RandomNumberGenerator.generate();
        judgeMovement(car, num);
    }

    public void judgeMovement(Car car, int num) {
        if (num >= MOVEMENT_CRITERIA) {
            car.moveForward();
        }
    }
}
