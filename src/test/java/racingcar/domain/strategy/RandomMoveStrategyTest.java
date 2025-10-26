package racingcar.domain.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트용 고정 숫자 생성기
final class DefaultMoveStrategyTest implements NumberGenerator {
    private final int fixedNumber;

    public DefaultMoveStrategyTest(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}

public class RandomMoveStrategyTest {

    @Test
    void 숫자가_4미만이면_이동불가_테스트() {
        // When
        MovingStrategy movingStrategy = new RandomMoveStrategy(new DefaultMoveStrategyTest(3));

        // Then
        assertThat(moveStrategy.movable()).isFalse();
    }

    @Test
    void 숫자가_4이상이면_이동가능_테스트() {
        // When
        MovingStrategy movingStrategy = new RandomMoveStrategy(new DefaultMoveStrategyTest(4));

        // Then
        assertThat(moveStrategy.movable()).isTrue();
    }
}
