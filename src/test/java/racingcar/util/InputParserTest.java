package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @Test
    void 입력값_파싱_테스트() {
        String input = "pobi,woni,jun";
        String[] strings = InputParser.parseStringToArray(input);

        assertThat(strings).hasSize(3);
        assertThat(strings[0]).isEqualTo("pobi");
        assertThat(strings[1]).isEqualTo("woni");
        assertThat(strings[2]).isEqualTo("jun");
    }
}
