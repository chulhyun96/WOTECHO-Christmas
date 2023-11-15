package benefit;

import static constants.SystemConstants.NONE_DISCOUNT;
import static discount.ChristmasDisCount.christmasDiscount;

import discount.SpecialDiscount;
import discount.WeekdayDiscount;
import discount.WeekendDiscount;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public abstract class BenefitDetailsJudge {
    public static boolean responseChristmasBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = christmasDiscount(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;
    }
    public static boolean responseSpecialBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = SpecialDiscount.discountSpecial(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;

    }
    public static boolean responseWeekdayBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = WeekdayDiscount.discountWeekDay(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;
    }
    public static boolean responseWeekendBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAmount = WeekendDiscount.discountWeekend(orderInfoList, localDate);
        return discountAmount != NONE_DISCOUNT;
    }
}
