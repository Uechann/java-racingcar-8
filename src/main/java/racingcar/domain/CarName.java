package racingcar.domain;

public class CarName {
    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void validate(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈값이거나 공백일 수 없습니다.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
