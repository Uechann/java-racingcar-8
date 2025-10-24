package racingcar.domain;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars() {
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCars() {
        return carList;
    }

    public Car findByName(String name) {
        return carList.stream()
                .filter(car -> car.getName().value().equals(name))
                .findFirst()
                .get();
    }
}
