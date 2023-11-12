package discount;

import static date.EventDate.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public abstract class SpecialDiscount {
    private static final int SPECIAL_DISCOUNT_PRICE = 1000;
    private static final String SPECIAL_PRINT_FORMAT = SPECIAL_DISCOUNT.getName()+": -%,d?";

    public static String discountSpecial(List<OrderInfo> userOrderInfoLIst, LocalDate userInputDate) {
        if (!isSpecialDay(userInputDate)) {
            return "0";
        }
        return String.format(SPECIAL_PRINT_FORMAT, SPECIAL_DISCOUNT_PRICE);
    }

    private static boolean isSpecialDay(LocalDate userInputDate) {
        DayOfWeek getDayOfSpecialDay = userInputDate.getDayOfWeek();
        int getDayOfMonth = userInputDate.getDayOfMonth();
        return getDayOfSpecialDay == DayOfWeek.SUNDAY || getDayOfMonth == 25;
    }
}
