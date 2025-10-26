package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarFactoryTest {

    CarFactory carFactory = new CarFactory();

    @Test
    void 자동차_객체들_생성_테스트() {
        // Given
        String[] input = {"pobi", "woni", "jun"};

        // When
        Cars cars = carFactory.createCars(input);

        // Then
        // 각 자동차 객체들이 정상적으로 생성되었는지 확인
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars().get(0).getName().value()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName().value()).isEqualTo("woni");
        assertThat(cars.getCars().get(2).getName().value()).isEqualTo("jun");
    }

    @Test
    void 자동차_이름_중복_테스트() {
        // Given
        String[] input = {"pobi", "woni", "pobi"};

        // Then
        assertThatThrownBy(() -> carFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
