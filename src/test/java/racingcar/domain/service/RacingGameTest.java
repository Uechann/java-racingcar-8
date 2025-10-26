package racingcar.domain.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.strategy.MovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트용 고정 true 전략
final class TrueStrategy implements MovingStrategy {
    @Override
    public boolean movable() {
        return true;
    }
}

// 테스트용 고정 false 전략
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
    void 전략이_true_false일때_자동차_움직임_테스트() {
        // Given
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));

        // When
        car1.judgeAndMove(new TrueStrategy()); // true 전략으로 이동
        car2.judgeAndMove(new FalseStrategy()); // false 전략으로 이동

        // Then
        assertThat(car1.getPosition()).isEqualTo(1); // true 전략일 때 위치 증가
        assertThat(car2.getPosition()).isEqualTo(0); // false 전략일 때
    }
}
