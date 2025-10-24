package racingcar.domain;

public class Attempt {
    private final int value;

    public Attempt(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return value;
    }

    private void validate(String value) {
        // 숫자 아니라면 오류
        if (!value.matches("^\\d+$")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        // 0 이하라면 오류
        int intValue = Integer.parseInt(value);
        if (intValue <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }
}
