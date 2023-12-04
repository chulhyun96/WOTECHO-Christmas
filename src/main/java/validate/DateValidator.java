package validate;

public abstract class DateValidator {
    private static final int  INVALID_MIN_DATE = 1;
    private static final int INVALID_MAX_DATE = 31;
    private static final String ERROR_INVALID_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static void validateDateRange(int date) {
        if (!(INVALID_MIN_DATE <= date && date <= INVALID_MAX_DATE)) {
            throw new IllegalArgumentException(ERROR_INVALID_DATE_MESSAGE);
        }
        System.out.println();
    }

    public static int validateDateInput(String dateInput) {
        try {
            return Integer.parseInt(dateInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_INVALID_DATE_MESSAGE);
        }
    }
}
