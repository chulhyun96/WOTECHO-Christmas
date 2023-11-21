package discount;

import static constants.SystemConstants.NONE_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import menu.MenuCategory;
import order.OrderInfo;
import validate.EventCaution;

public abstract class WeekendDiscount {
    private static final int WEEKEND_DISCOUNT_PRICE = 2023;

    public static int discountWeekend(List<OrderInfo> orderInfoList, LocalDate userInputDate) {
        if (EventCaution.checkIfEventAccept(orderInfoList)) {
            if (weekendDate(userInputDate)) {
                int mainCount = getMainCount(orderInfoList);
                return mainCount * WEEKEND_DISCOUNT_PRICE;
            }
        }
        return NONE_DISCOUNT;
    }

    private static int getMainCount(List<OrderInfo> orderInfoList) {
        int mainCount = 0;
        for (OrderInfo orderInfo : orderInfoList) {
            if (MenuCategory.MAIN.equals(orderInfo.getMenuCategory())) {
                mainCount += orderInfo.getQuantity();
            }
        }
        return mainCount;
    }

    private static boolean weekendDate(LocalDate userInputDate) {
        DayOfWeek dayOfWeekend = userInputDate.getDayOfWeek();
        return dayOfWeekend == DayOfWeek.FRIDAY || dayOfWeekend == DayOfWeek.SATURDAY;
    }
}
