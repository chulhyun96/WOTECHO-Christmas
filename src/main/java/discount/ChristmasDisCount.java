package discount;

import static constants.SystemConstants.NONE_DISCOUNT;
import static date.Event.CHRISTMAS_DDAY;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import order.OrderInfo;
import validate.EventCaution;

public class ChristmasDisCount implements DiscountStrategy{
    private static ChristmasDisCount instance;
    private static final int DISCOUNT_DEFAULT_PRICE = 1000;
    private static final int DISCOUNT_IMPEDING_ON_DATE = 100;

    private ChristmasDisCount() {
    }
    public static ChristmasDisCount getInstance() {
        if (instance == null) {
            instance = new ChristmasDisCount();
        }
        return instance;
    }
    @Override
    public int applyDiscountStrategy(List<OrderInfo> orderInfoList, LocalDate inputDate) {
        if (EventCaution.checkIfEventAccept(orderInfoList) && isDiscountAccept(inputDate)) {
            return getDiscount(inputDate);
        }
        return NONE_DISCOUNT;
    }

    @Override
    public boolean isDiscountAccept(LocalDate localDate) {
        return !localDate.isBefore(CHRISTMAS_DDAY.getStartDate()) &&
                !localDate.isAfter(CHRISTMAS_DDAY.getEndDate());
    }

    private int getDiscount(LocalDate inputDate) {
        long date = ChronoUnit.DAYS.between(CHRISTMAS_DDAY.getStartDate(), inputDate);
        return DISCOUNT_DEFAULT_PRICE + ((int) date * DISCOUNT_IMPEDING_ON_DATE);
    }
}
