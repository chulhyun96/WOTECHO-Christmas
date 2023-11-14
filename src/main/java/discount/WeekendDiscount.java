package discount;

import static constants.SystemConstants.NONE_DISCOUNT;
import static date.Event.WEEKEND_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import menu.MenuCategory;
import order.OrderInfo;
import validate.EventCaution;

public abstract class WeekendDiscount {
    private static final int WEEKEND_DISCOUNT_PRICE = 2023;
    private static final String WEEKEND_PRINT_FORMAT = WEEKEND_DISCOUNT.getDisplayName()+": -%,d원";

    public static String discountWeekend(List<OrderInfo> orderInfoList, LocalDate userInputDate) {

        if (EventCaution.checkIfEventAcceptPrice(orderInfoList)) {
            if (weekendDate(userInputDate)) {
                int mainCount = 0;
                for (OrderInfo orderInfo : orderInfoList) {
                    if (MenuCategory.MAIN.equals(orderInfo.getMenuCategory())) {
                        mainCount += orderInfo.getQuantity();
                    }
                }
                int discount = mainCount * WEEKEND_DISCOUNT_PRICE;
                return String.format(WEEKEND_PRINT_FORMAT, discount);
            }
        }
        return NONE_DISCOUNT;
    }

    private static boolean weekendDate(LocalDate userInputDate) {
        DayOfWeek dayOfWeekend = userInputDate.getDayOfWeek();
        return dayOfWeekend == DayOfWeek.FRIDAY || dayOfWeekend == DayOfWeek.SATURDAY;
    }
}
