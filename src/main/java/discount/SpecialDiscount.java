package discount;

import static constants.SystemConstants.NONE_DISCOUNT;
import static date.Event.SPECIAL_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;
import validate.EventCaution;

public abstract class SpecialDiscount {

    private static final int SPECIAL_DISCOUNT_PRICE = 1000;
    private static final int EVENT_ACCEPT_DATE = 25;
    private static final String SPECIAL_PRINT_FORMAT = SPECIAL_DISCOUNT.getDisplayName() + ": -%,d원";

    public static String discountSpecial(List<OrderInfo> orderInfoList, LocalDate userInputDate) {

        if (EventCaution.checkIfEventAcceptPrice(orderInfoList)) {
            if (isSpecialDay(userInputDate)) {
                return String.format(SPECIAL_PRINT_FORMAT, SPECIAL_DISCOUNT_PRICE);
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
