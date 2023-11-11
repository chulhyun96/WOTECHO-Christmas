package validate;

public class DateValidator {
    private static final int  INVALID_MIN_DATE = 1;
    private static final int INVALID_MAX_DATE = 31;
    private static final String ERROR_INVALID_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String ERROR_INVALID_INPUT_DATE_MESSAGE = "[ERROR] 날짜 입력은 숫자로만 입력해주세요.";

    public static void validateDateRange(int date) {
        if (date < INVALID_MIN_DATE || date > INVALID_MAX_DATE) {
            throw new IllegalArgumentException(ERROR_INVALID_DATE_MESSAGE);
        }
    }
    public static int validateDateInput(String dateInput) {
        int day;
        try {
            day = Integer.parseInt(dateInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_INVALID_INPUT_DATE_MESSAGE);
        }
        return day;
    }
}
