package racingcar.domain;

public class Car {
    private CarName name;

    public Car() {}

    public Car(CarName name) {
        this.name = name;
    }

    public CarName getName() {
        return name;
    }
}
