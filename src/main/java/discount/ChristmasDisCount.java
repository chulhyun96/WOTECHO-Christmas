package discount;

import static date.EventDate.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class ChristmasDisCount {
    private static final int DISCOUNT_DEFAULT_PRICE = 1000;
    private static final int DISCOUNT_IMPEDING_ON_DATE = 100;
    private static final String CHRISTMAS_DISCOUNT_MESSAGE = CHRISTMAS_DDAY.getName()+": -%,d원";
    private static final String NONE_DISCOUNT = "0";

    public static String christmasDiscount(LocalDate inputDate) {
        if (!inputDate.isBefore(CHRISTMAS_DDAY.getStartDate()) &&
                !inputDate.isAfter(CHRISTMAS_DDAY.getEndDate())) {

            int discount = getDiscount(inputDate);

            return String.format(CHRISTMAS_DISCOUNT_MESSAGE, discount);
        }
        return NONE_DISCOUNT;
    }

    private static int getDiscount(LocalDate inputDate) {
        long date = ChronoUnit.DAYS.between(CHRISTMAS_DDAY.getStartDate(), inputDate);
        return DISCOUNT_DEFAULT_PRICE + ((int) date * DISCOUNT_IMPEDING_ON_DATE);
    }
}
