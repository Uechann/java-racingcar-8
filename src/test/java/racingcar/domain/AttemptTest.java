package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptTest {

    @Test
    void 양수_숫자값으로_시도_객체_생성_테스트() {
        Attempt attempt = new Attempt("5");

        assertThat(attempt.value()).isEqualTo(5);
    }

    @Test
    void 음수_숫자값_실패_테스트() {
        assertThatThrownBy(() -> new Attempt("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌값_실패_테스트() {
        assertThatThrownBy(() -> new Attempt("ddd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
