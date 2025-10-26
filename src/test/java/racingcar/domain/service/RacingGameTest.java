package racingcar.domain.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class TrueStrategy implements MovingStrategy {
    @Override
    public boolean movable() {
        return true;
    }
}

final class FalseStrategy implements MovingStrategy {
    @Override
    public boolean movable() {
        return false;
    }
}

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

    @Test
    void 전략이_true_false일때_자동차_움직임_테스트() {
        // Given
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));

        // When
        car1.moveForward(new TrueStrategy()); // true 전략으로 이동
        car2.moveForward(new FalseStrategy()); // false 전략으로 이동

        // Then
        assertThat(car1.getPosition()).isEqualTo(1); // true 전략일 때 위치 증가
        assertThat(car2.getPosition()).isEqualTo(0); // false 전략일 때
    }
}
