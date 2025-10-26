package racingcar.domain.service;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.dto.CarStateResultDto;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final OutputView outputView = new OutputView();

    // 게임 실행
    public void run(Cars cars, Attempt attempt) {

        outputView.printResultHeader();
        for (int i = 0; i < attempt.value(); i++) {
            // 각 자동차에 대해 한 번의 시도 수행
            cars.getCars().forEach(this::attemptOneTry);

            // 현재 자동차 상태를 DTO로 변환
            List<CarStateResultDto> carStates = cars.getCars().stream()
                    .map(CarStateResultDto::from)
                    .toList();

            // 각 시도마다 자동차 위치 출력
            outputView.printCarsPosition(carStates);
        }

        // 우승자 판단 후 출력
        outputView.printWinners(cars.getWinners());
    }

    private void attemptOneTry(Car car) {
        car.judgeAndMove(new RandomMovingStrategy(new RandomNumberGenerator()));
    }
}
