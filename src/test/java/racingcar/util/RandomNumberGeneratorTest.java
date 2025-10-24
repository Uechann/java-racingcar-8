package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    RandomNumberGenerator rng = new RandomNumberGenerator();

    @Test
    void 랜덤_번호_생성_테스트() {
        int randomNum = rng.generate();
        assertThat(randomNum).isBetween(0, 9);
    }
}
