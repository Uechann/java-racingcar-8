package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    void 랜덤_번호_생성_테스트() {
        int randomNum = RandomNumberGenerator.generate();
        assertThat(randomNum).isBetween(0, 9);
    }
}
