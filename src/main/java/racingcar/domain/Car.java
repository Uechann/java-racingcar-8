package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

public class Car {

    private CarName name;
    private int position;

    public Car() {
    }

    public Car(CarName name) {
        this.name = name;
    }

    public CarName getName() {
        return name;
    }

    public void judgeAndMove(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            moveForward();
        }
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
