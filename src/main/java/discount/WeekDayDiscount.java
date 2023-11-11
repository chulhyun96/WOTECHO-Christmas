package discount;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public abstract class WeekDayDiscount {
    private static final int WEEKDAY_DISCOUNT_AMOUNT = 2023;
    private static final String NONE_DISCOUNT = "0";
    private static final String PRINT_FORMAT = "평일 할인 : -%,d원";

    public static String weekDayDiscount(List<OrderInfo> userOrderInfoList, LocalDate userInputDate) {
        if (!isWeekday(userInputDate)) {
            return NONE_DISCOUNT;
        }
        int dessertCount = 0;
        for (OrderInfo orderInfo : userOrderInfoList) {
            if ("디저트".equals(orderInfo.getMenuCategory())) {
                dessertCount += orderInfo.getQuantity();
            }
        }
        int discount = dessertCount * WEEKDAY_DISCOUNT_AMOUNT;
        return String.format(PRINT_FORMAT, discount);

    }

    private static boolean isWeekday(LocalDate userInputDate) {
        DayOfWeek getWeekDay = userInputDate.getDayOfWeek();
        return getWeekDay != DayOfWeek.FRIDAY && getWeekDay != DayOfWeek.SATURDAY;
    }
}
