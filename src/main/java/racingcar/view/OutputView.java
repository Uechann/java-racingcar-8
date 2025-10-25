package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {

    public static final String RESULT_MESSAGE = "\n실행 결과";
    static StringBuilder sb = new StringBuilder();

    public void printCarsPosition(Cars cars) {
        sb.append(RESULT_MESSAGE).append("\n");

        cars.getCars().forEach(car -> {
            sb.append(car.getName().value()).append(" : ");

            int position = car.getPosition();
            sb.append("-".repeat(position));

            sb.append("\n");
        });

        System.out.print(sb);
    }
}
