package racingcar.domain.strategy;

import racingcar.util.NumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {
    private final NumberGenerator numberGenerator;

    public RandomMovingStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean movable() {
        int CRITERIA = 4;
        return numberGenerator.generate() >= CRITERIA;
    }
}
