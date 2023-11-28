package benefit;

import static constants.SystemConstants.NONE_DISCOUNT;

import discount.ChristmasDisCount;
import discount.SpecialDiscount;
import discount.WeekdayDiscount;
import discount.WeekendDiscount;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public abstract class BenefitDetailsJudge {
    public static boolean responseChristmasBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = ChristmasDisCount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;
    }
    public static boolean responseSpecialBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = SpecialDiscount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;

    }
    public static boolean responseWeekdayBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = WeekdayDiscount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;
    }
    public static boolean responseWeekendBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = WeekendDiscount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;
    }
}
