package discount;


import static constants.SystemConstants.NONE_DISCOUNT;
import static date.Event.WEEKDAY_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import menu.MenuCategory;
import order.OrderInfo;
import validate.EventCaution;

public abstract class WeekDayDiscount {
    private static final int WEEKDAY_DISCOUNT_PRICE = 2023;
    private static final String WEEKDAY_PRINT_FORMAT = WEEKDAY_DISCOUNT.getDisplayName()+": -%,d원";

    public static String discountWeekDay(List<OrderInfo> orderInfoList, LocalDate userInputDate) {
        if (EventCaution.checkIfEventAcceptPrice(orderInfoList)) {
            if (isWeekday(userInputDate)) {
                int dessertCount = getDessertCount(orderInfoList);
                int discount = dessertCount * WEEKDAY_DISCOUNT_PRICE;
                return String.format(WEEKDAY_PRINT_FORMAT, discount);
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
