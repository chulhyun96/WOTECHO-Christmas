package date;

import inputview.InputView;
import java.time.LocalDate;
import validate.DateValidator;

public abstract class DateReserve {
    private final static int YEAR = 2023;
    private final static int MONTH = 12;

    public static LocalDate reserveDate() {
        String reserveDay = InputView.readDate();
        LocalDate date = null;

        boolean isValid = false;

        while (!isValid) {
            try {
                int parseIntDay = DateValidator.validateDateInput(reserveDay);
                DateValidator.validateDateRange(parseIntDay);
                date = LocalDate.of(YEAR,MONTH,parseIntDay);
                isValid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                reserveDay = InputView.readDate();
            }
        }
        return date;
    }
}
