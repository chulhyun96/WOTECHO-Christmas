package discount;

import static date.EventDate.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class ChristmasDisCount {
    private static final int DISCOUNT_PRICE = 1000;
    private static final int DISCOUNT_IMPEDING_ON_DATE = 100;

    public static String christmasDiscount(LocalDate inputDate) {
        if (!inputDate.isBefore(CHRISTMAS_DDAY.getStartDate()) &&
                !inputDate.isAfter(CHRISTMAS_DDAY.getEndDate())) {
            long date = ChronoUnit.DAYS.between(CHRISTMAS_DDAY.getStartDate(), inputDate);
            int discount = DISCOUNT_PRICE + ((int) date * DISCOUNT_IMPEDING_ON_DATE);
            return "-" + discount;
        }
        return "0";
    }
}
