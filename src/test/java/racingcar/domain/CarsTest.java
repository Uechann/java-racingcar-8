package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 우승자_조회_테스트_1명() {
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Car car3 = new Car(new CarName("jun"));
        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.moveForward();
        car1.moveForward();
        car2.moveForward();
        car3.moveForward();

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 우승자_조회_테스트_여러명() {
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Car car3 = new Car(new CarName("jun"));
        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.moveForward();
        car2.moveForward();
        car3.moveForward();

        List<String> winners = cars.getWinners();

        assertThat(winners).hasSize(3);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}
