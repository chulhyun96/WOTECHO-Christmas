package discount;


import static constants.SystemConstants.NONE_DISCOUNT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import menu.MenuCategory;
import order.OrderInfo;
import validate.EventCaution;

public class WeekdayDiscount implements DiscountStrategy{
    private static WeekdayDiscount instance;
    private static final int WEEKDAY_DISCOUNT_PRICE = 2023;

    private WeekdayDiscount() {
    }
    public static WeekdayDiscount getInstance() {
        if (instance == null) {
            instance = new WeekdayDiscount();
        }
        return instance;
    }
    @Override
    public int applyDiscountStrategy(List<OrderInfo> orderInfoList, LocalDate userInputDate) {
        if (EventCaution.checkIfEventAccept(orderInfoList) && isDiscountAccept(userInputDate)) {
            int dessertCount = getDessertCount(orderInfoList);
            return dessertCount * WEEKDAY_DISCOUNT_PRICE;
        }
        return NONE_DISCOUNT;
    }

    @Override
    public boolean isDiscountAccept(LocalDate localDate) {
        DayOfWeek getWeekDay = localDate.getDayOfWeek();
        return getWeekDay != DayOfWeek.FRIDAY && getWeekDay != DayOfWeek.SATURDAY;
    }

    private int getDessertCount(List<OrderInfo> userOrderInfoList) {
        return userOrderInfoList.stream()
                .filter(orderInfo -> MenuCategory.DESSERT.equals(orderInfo.getMenuCategory()))
                .mapToInt(OrderInfo::getQuantity)
                .sum();
    }
}
