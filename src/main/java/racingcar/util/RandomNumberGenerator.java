package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public RandomNumberGenerator() {}

    public int generate() {
        return Randoms.pickNumberInRange(0,9);
    }
}
