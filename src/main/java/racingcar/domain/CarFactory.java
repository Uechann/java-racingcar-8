package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    public CarFactory() {}

    // 자동차 생성 메서드
    public Cars createCars(String[] names) {
        // 중복 이름 검사
        validateDuplicateNames(names);

        // 자동차 리스트 생성
        List<Car> carList = createCarList(names);

        return new Cars(carList);
    }

    // 자동차 리스트 생성 메서드 분리
    private static List<Car> createCarList(String[] names) {
        return Arrays.stream(names)
                .map(CarName::new)
                .map(Car::new)
                .toList();
    }

    // 중복 이름 검사
    private void validateDuplicateNames(String[] names) {
        Long distinctCount = Arrays.stream(names)
                .distinct()
                .count();

        // 중복된 이름이 있을 경우 예외 처리
        if (distinctCount != names.length) {
            throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
        }
    }
}
