package date;

import inputview.InputView;
import java.time.LocalDate;
import validate.DateValidator;

public abstract class DateReserve {
    // 날짜를 입력받고 검증하고 반환, 만약 잘못된 입력시 해당 메서드에서 재입력 받음
    private final static int YEAR = 2023;
    private final static int MONTH = 12;

    public static LocalDate reserveDate() {
        // 해당 메서드 호출 시 날짜 입력 받음
        String reserveDay = InputView.readDate();
        LocalDate date = null;

        while (date == null) {
            try {
                // int  parsing
                int parseIntDay = DateValidator.validateDateInput(reserveDay);
                // 1~31
                DateValidator.validateDateRange(parseIntDay);
                date = LocalDate.of(YEAR, MONTH, parseIntDay);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return date;
    }
}
