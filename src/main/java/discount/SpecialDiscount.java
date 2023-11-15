package discount;

import static constants.SystemConstants.NONE_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;
import validate.EventCaution;

public abstract class SpecialDiscount {

    private static final int SPECIAL_DISCOUNT_PRICE = 1000;
    private static final int EVENT_ACCEPT_DATE = 25;

    public static int discountSpecial(List<OrderInfo> orderInfoList, LocalDate userInputDate) {
        if (EventCaution.checkIfEventAccept(orderInfoList)) {
            if (isSpecialDay(userInputDate)) {
                return SPECIAL_DISCOUNT_PRICE;
            }
        }
        return NONE_DISCOUNT;
    }

    private static boolean isSpecialDay(LocalDate userInputDate) {
        DayOfWeek getDayOfSpecialDay = userInputDate.getDayOfWeek();
        int getDayOfMonth = userInputDate.getDayOfMonth();
        return getDayOfSpecialDay == DayOfWeek.SUNDAY || getDayOfMonth == EVENT_ACCEPT_DATE;
    }
}
