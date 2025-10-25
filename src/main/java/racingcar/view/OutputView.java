package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {

    static StringBuilder sb = new StringBuilder();

    // 자동차들의 현재 위치를 출력하는 메서드
    public void printCarsPosition(Cars cars) {

        sb.append("\n").append("실행 결과").append("\n");

        cars.getCars().forEach(car -> {
            sb.append(car.getName().value()).append(" : ");

            // 현재 위치만큼 '-' 출력
            int position = car.getPosition();
            sb.append("-".repeat(position));

            sb.append("\n");
        });
        System.out.print(sb);
    }
}
