package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.dto.CarStateResultDto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final StringBuilder sb = new StringBuilder();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 모든_자동차_이동거리_출력_테스트() {
        // given
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Car car3 = new Car(new CarName("jun"));
        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.moveForward();
        car1.moveForward();
        car2.moveForward();
        // car1: 2, car2: 1, car3: 0

        // when
        OutputView outputView = new OutputView();
        List<CarStateResultDto> carStates = cars.getCars().stream()
                .map(CarStateResultDto::from)
                .toList();
        outputView.printCarsPosition(carStates);

        // then
        sb.append("\n");
        sb.append("pobi : --").append("\n");
        sb.append("woni : -").append("\n");
        sb.append("jun : ").append("\n");
        String expected = sb.toString();

        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    // 최종 우승자 출력 테스트
    @Test
    void 최종_우승자_1명_출력_테스트() {
        // given
        Car car1 = new Car(new CarName("pobi"));
        Cars cars = new Cars(List.of(car1));

        // when
        List<String> winners = cars.getWinners();
        OutputView outputView = new OutputView();
        outputView.printWinners(winners);

        // then
        String expected = "\n최종 우승자 : pobi";
        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    void 최종_우승자_2명이상_출력_테스트() {
        // given
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Cars cars = new Cars(List.of(car1, car2));

        // when
        List<String> winners = cars.getWinners();
        OutputView outputView = new OutputView();
        outputView.printWinners(winners);

        // then
        String expected = "\n최종 우승자 : pobi, woni";
        assertThat(outputStream.toString()).isEqualTo(expected);
    }
}
