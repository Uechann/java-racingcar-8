package racingcar.domain.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final RacingGame racingGame = new RacingGame();

    @Test
    void 랜덤_숫자_생성으로_자동차_움직임_테스트() {
        // Given
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));

        // When
        // 각 자동차에 대해 랜덤 숫자에 따른 움직임 판단
        racingGame.judgeMovement(car1, MOVING_FORWARD);
        racingGame.judgeMovement(car2, STOP);

        // Then
        // 랜덤 숫자에 따라 자동차가 움직였는지 확인
        assertThat(car1.getPosition()).isEqualTo(1); // MOVING_FORWARD일 때 위치 증가
        assertThat(car2.getPosition()).isEqualTo(0); // STOP일 때 위치 유지
    }

    // 우승자 판단 테스트 (1명)
    @Test
    void 우승자_판단_테스트() {
        // Given
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Car car3 = new Car(new CarName("jun"));
        Cars cars = new Cars(List.of(car1, car2, car3));

        // 각 자동차의 위치 설정
        racingGame.judgeMovement(car1, MOVING_FORWARD); // 위치 1
        racingGame.judgeMovement(car2, STOP);           // 위치 0
        racingGame.judgeMovement(car3, MOVING_FORWARD); // 위치 1
        racingGame.judgeMovement(car3, MOVING_FORWARD); // 위치 2

        // When
        List<Car> winners = racingGame.determineWinners(cars);

        // Then
        // 우승자가 올바르게 판단되었는지 확인
        assertThat(winners.size()).isEqualTo(1); // 우승자 1명
        assertThat(winners.getFirst()).isEqualTo(car3); // jun이 우승
    }

    // 우승자 판단 테스트 (여러명)
    @Test
    void 우승자_판단_테스트_여러명() {
        // Given
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Car car3 = new Car(new CarName("jun"));
        Cars cars = new Cars(List.of(car1, car2, car3));

        // 각 자동차의 위치 설정
        racingGame.judgeMovement(car1, MOVING_FORWARD); // 위치 1
        racingGame.judgeMovement(car1, MOVING_FORWARD); // 위치 2
        racingGame.judgeMovement(car2, MOVING_FORWARD); // 위치 1
        racingGame.judgeMovement(car2, MOVING_FORWARD); // 위치 2
        racingGame.judgeMovement(car3, STOP);           // 위치 0

        // When
        List<Car> winners = racingGame.determineWinners(cars);

        // Then
        // 우승자가 올바르게 판단되었는지 확인
        assertThat(winners.size()).isEqualTo(2); // 우승자 2명
        assertThat(winners).contains(car1, car2);   // pobi와 woni가 공동 우승
    }
}
