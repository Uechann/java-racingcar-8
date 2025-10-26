package racingcar.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    // 한글, 영문, 숫자, 쉽표 제외한 특수문자 입력 테스트
    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,woni,jun!", "pobi,woni,ju@n", "pobi,woni,ju#n", "pobi,woni,ju$n",
            "pobi,woni,ju%n", "pobi,woni,ju^n", "pobi,woni,ju&n", "pobi,woni,ju*n",
            "pobi,woni,ju(n", "pobi,woni,ju)n", "pobi,woni,ju-n", "pobi,woni,ju+n",
            "pobi,woni,ju=n", "pobi,woni,ju{n", "pobi,woni,ju}n", "pobi,woni,ju[n",
            "pobi,woni,ju]n", "pobi,woni,ju|n", "pobi,woni,ju\\n", "pobi,woni,ju:n",
            "pobi,woni,ju;n", "pobi,woni,ju\"n", "pobi,woni,ju'n", "pobi,woni,ju<n",
            "pobi,woni,ju>n", "pobi,woni,ju,n", "pobi,woni,ju.n", "pobi,woni,ju?n",
            "pobi,woni,ju/n"
    })
    void 입력형식_검증_테스트(String input) {
        boolean isValid = InputValidator.validateInputFormat(input);

        assertThat(isValid).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "pobi;woni;jun", "pobi woni jun", "pobi,,jun", "pobi,woni,", ",pobi,woni"})
    void 입력형식_검증_실패_테스트(String input) {

        assertThatThrownBy(() -> InputValidator.validateInputFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
