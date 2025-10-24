package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    public CarFactory() {
    }

    public Cars createCars(String[] names) {
        // 중복 검사
        validateDuplicateNames(names);

        List<Car> carList = Arrays.stream(names)
                .map(CarName::new)
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }

    // 중복 이름 검사
    private void validateDuplicateNames(String[] names) {
        Long count = Arrays.stream(names)
                .distinct()
                .count();

        // 중복된 이름이 있을 경우 예외 처리
        if (count != names.length) {
            throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
        }
    }
}
