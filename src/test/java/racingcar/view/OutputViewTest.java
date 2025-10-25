package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;

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
        OutputView outputView = new OutputView();

        // when
        outputView.printCarsPosition(cars);

        // then
        sb.append("\n");
        sb.append("실행 결과").append("\n");
        sb.append("pobi : --").append("\n");
        sb.append("woni : -").append("\n");
        sb.append("jun : ").append("\n");
        String expected = sb.toString();

        assertThat(outputStream.toString()).isEqualTo(expected);
    }
}
