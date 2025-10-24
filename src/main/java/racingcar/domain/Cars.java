package racingcar.domain;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars() {
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    // 자동차 리스트 조회
    public List<Car> getCars() {
        return carList;
    }

    // 이름으로 자동차 조회
    public Car findByName(String name) {
        return carList.stream()
                .filter(car -> car.getName().value().equals(name))
                .findFirst()
                .get();
    }
}
