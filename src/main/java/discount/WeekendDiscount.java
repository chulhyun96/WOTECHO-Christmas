package discount;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public class WeekendDiscount {
    private static final int WEEKEND_DISCOUNT_PRICE = 2023;
    private static final String WEEKEND_PRINT_FORMAT = "?? ?? : -%,d?";
    private static final String MAIN = "??";
    public static String discountWeekend(List<OrderInfo> userOrderInfoList, LocalDate userInputDate) {
        if (!weekendDate(userInputDate)) {
            return "0";
        }
        int mainCount = 0;
        for (OrderInfo orderInfo : userOrderInfoList) {
            if (MAIN.equals(orderInfo.getMenuCategory())) {
                mainCount += orderInfo.getQuantity();
            }
        }
        int discount = mainCount * WEEKEND_DISCOUNT_PRICE;
        return String.format(WEEKEND_PRINT_FORMAT, discount);
    }

    private static boolean weekendDate(LocalDate userInputDate) {
        DayOfWeek dayOfWeekend = userInputDate.getDayOfWeek();
        return dayOfWeekend == DayOfWeek.FRIDAY || dayOfWeekend == DayOfWeek.SATURDAY;
    }
}
