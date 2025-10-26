package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarStateResultDto;

import java.util.List;

public class OutputView {

    static StringBuilder sb = new StringBuilder();

    public void printResultHeader() {
        System.out.print("\n실행 결과");
    }

    // 자동차들의 현재 위치를 출력하는 메서드
    public void printCarsPosition(List<CarStateResultDto> results) {
        sb.setLength(0);
        sb.append("\n");

        results.forEach(result -> {
            sb.append(result.name()).append(" : ");
            sb.append(result.positionVisual()).append("\n");
        });

        System.out.print(sb);
    }

    // 최종 우승자 출력 메서드
    public void printWinners(List<Car> winners) {
        sb.setLength(0);
        sb.append("\n").append("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName().value());

            if (i < winners.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.print(sb);
    }
}
