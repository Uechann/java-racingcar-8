package racingcar.domain;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    // 자동차 리스트 조회
    public List<Car> getCars() {
        return carList;
    }

    // 자동차들의 우승자 조회
    public List<String> getWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName().value())
                .toList();
    }
}
