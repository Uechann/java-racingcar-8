package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    // 자동차 이름 생성 테스트
    @Test
    void 자동차_이름_생성_테스트() {
        CarName carName = new CarName("pobi");
        assertThat(carName.value()).isEqualTo("pobi");
    }

    // 자동차 이름 5자 초과 -> IllegalArgumentException
    @Test
    void 자동차_이름_5자_초과_테스트() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 자동차 이름 빈값이거나 공백 테스트
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void 자동차_이름_빈값_공백_테스트(String value) {
        assertThatThrownBy(() -> new CarName(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
