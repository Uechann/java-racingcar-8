package racingcar.domain.strategy;

import racingcar.util.NumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {
    private final int CRITERIA = 4;
    private final NumberGenerator numberGenerator;

    public RandomMovingStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean movable() {
        return numberGenerator.generate() >= CRITERIA;
    }
}
