package racingcar.dto;

import racingcar.domain.Car;

// 자동차의 이름, 위치 시각화 정보를 담는 DTO
public record CarStateResultDto(String name, String positionVisual) {
    public static CarStateResultDto from(Car car) {
        return new CarStateResultDto(
                car.getName().value(),
                "-".repeat(car.getPosition())
        );
    }
}
