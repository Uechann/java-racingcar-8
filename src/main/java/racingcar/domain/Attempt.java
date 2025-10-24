package racingcar.domain;

public class Attempt {
    private int value;

    public Attempt(String value) {

        validate(value);
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return value;
    }

    private void validate(String value) {
        // 문자인지 숫자인지 검사
        if (!value.matches("^\\d+$")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        // 0보다 큰지 검사
        int intValue = Integer.parseInt(value);
        if (intValue <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }
}
