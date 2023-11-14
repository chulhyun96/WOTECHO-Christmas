package discount;

import static constants.SystemConstants.NONE_DISCOUNT;
import static date.Event.CHRISTMAS_DDAY;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import order.OrderInfo;
import validate.EventCaution;

public abstract class ChristmasDisCount {
    private static final int DISCOUNT_DEFAULT_PRICE = 1000;
    private static final int DISCOUNT_IMPEDING_ON_DATE = 100;
    private static final String CHRISTMAS_DISCOUNT_MESSAGE = CHRISTMAS_DDAY.getDisplayName() + ": -%,d원";


    public static String christmasDiscount(List<OrderInfo> orderInfoList, LocalDate inputDate) {
        if (EventCaution.checkIfEventAcceptPrice(orderInfoList)) {
            if (!inputDate.isBefore(CHRISTMAS_DDAY.getStartDate()) &&
                    !inputDate.isAfter(CHRISTMAS_DDAY.getEndDate())) {

                int discount = getDiscount(inputDate);
                return String.format(CHRISTMAS_DISCOUNT_MESSAGE, discount);
            }
        }
        return NONE_DISCOUNT;
    }


    private static int getDiscount(LocalDate inputDate) {
        long date = ChronoUnit.DAYS.between(CHRISTMAS_DDAY.getStartDate(), inputDate);
        return DISCOUNT_DEFAULT_PRICE + ((int) date * DISCOUNT_IMPEDING_ON_DATE);
    }
}
