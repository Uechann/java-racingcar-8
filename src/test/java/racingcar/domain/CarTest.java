package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 여러_차_객체_생성_테스트() {
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));

        // 객체가 정상적으로 생성되었고 이름이 올바른지 확인
        assertThat(car1.getName().value()).isEqualTo("pobi");
        assertThat(car2.getName().value()).isEqualTo("woni");
    }
}
