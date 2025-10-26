package racingcar.util;

public class InputValidator {

    public static boolean validateInputFormat(String input) {

        // 각 이름은 1~4자의 문자
        // 쉼표와 공백을 제외한 모든 문자
        // 쉼표로 구분된 문자열
        String regex = "^[^,\\s]{1,4}(,[^,\\s]{1,4})*$";

        if (!input.matches(regex)) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
        return true;
    }
}
