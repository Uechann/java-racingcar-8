package racingcar.util;

public class InputValidator {

    public static boolean validateInputFormat(String input) {

        String regex = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";

        if (!input.matches(regex)) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
        return true;
    }
}
