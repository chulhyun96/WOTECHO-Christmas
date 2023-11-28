package discount;

import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public class AllDiscountPrice {
    private int christmasDiscountAmount;
    private int specialDiscountAmount;
    private int weekdayDiscountAmount;
    private int weekendDiscountAmount;
    private void getDiscountStrategy(List<OrderInfo> orderInfoList, LocalDate localDate) {
        ChristmasDisCount christmasDisCount = ChristmasDisCount.getInstance();
        this.christmasDiscountAmount = christmasDisCount.applyDiscountStrategy(orderInfoList, localDate);

        SpecialDiscount specialDiscount = SpecialDiscount.getInstance();
        this.specialDiscountAmount = specialDiscount.applyDiscountStrategy(orderInfoList, localDate);

        WeekdayDiscount weekdayDiscount = WeekdayDiscount.getInstance();
        this.weekdayDiscountAmount = weekdayDiscount.applyDiscountStrategy(orderInfoList, localDate);

        WeekendDiscount weekendDiscount = WeekendDiscount.getInstance();
        this.weekendDiscountAmount = weekendDiscount.applyDiscountStrategy(orderInfoList, localDate);
    }
    public int getAllDiscountPrice(List<OrderInfo> orderInfoList, LocalDate localDate) {
        getDiscountStrategy(orderInfoList, localDate);
        return christmasDiscountAmount + specialDiscountAmount + weekdayDiscountAmount + weekendDiscountAmount;
    }
}
