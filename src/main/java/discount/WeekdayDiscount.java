package discount;


import static constants.SystemConstants.NONE_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import menu.MenuCategory;
import order.OrderInfo;
import validate.EventCaution;

public abstract class WeekdayDiscount {
    private static final int WEEKDAY_DISCOUNT_PRICE = 2023;

    public static int discountWeekDay(List<OrderInfo> orderInfoList, LocalDate userInputDate) {
        if (EventCaution.checkIfEventAccept(orderInfoList)) {
            if (isWeekday(userInputDate)) {
                int dessertCount = getDessertCount(orderInfoList);
                return dessertCount * WEEKDAY_DISCOUNT_PRICE;
            }
        }
        return NONE_DISCOUNT;
    }

    private static int getDessertCount(List<OrderInfo> userOrderInfoList) {
        int dessertCount = 0;
        for (OrderInfo orderInfo : userOrderInfoList) {
            if (MenuCategory.DESSERT.equals(orderInfo.getMenuCategory())) {
                dessertCount += orderInfo.getQuantity();
            }
        }
        return dessertCount;
    }

    private static boolean isWeekday(LocalDate userInputDate) {
        DayOfWeek getWeekDay = userInputDate.getDayOfWeek();
        return getWeekDay != DayOfWeek.FRIDAY && getWeekDay != DayOfWeek.SATURDAY;
    }
}
