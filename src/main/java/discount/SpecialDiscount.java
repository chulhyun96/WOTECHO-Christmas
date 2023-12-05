package discount;

import static constants.SystemConstants.NONE_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;
import validate.EventCaution;

public class SpecialDiscount implements DiscountStrategy{
    private static SpecialDiscount instance;
    private static final int SPECIAL_DISCOUNT_PRICE = 1000;
    private static final int SPECIAL_EVENT_DAY = 25;

    private SpecialDiscount() {
    }
    public static SpecialDiscount getInstance() {
        if (instance == null) {
            instance = new SpecialDiscount();
        }
        return instance;
    }


    @Override
    public int applyDiscountStrategy(List<OrderInfo> orderInfoList, LocalDate localDate) {
        if (EventCaution.checkIfEventAccept(orderInfoList) && isDiscountAccept(localDate)) {
                return SPECIAL_DISCOUNT_PRICE;
        }
        return NONE_DISCOUNT;
    }
    @Override
    public boolean isDiscountAccept(LocalDate localDate) {
        DayOfWeek dayOfSpecialDay = localDate.getDayOfWeek();
        int dayOfMonth = localDate.getDayOfMonth();
        return dayOfSpecialDay == DayOfWeek.SUNDAY || dayOfMonth == SPECIAL_EVENT_DAY;
    }
}
