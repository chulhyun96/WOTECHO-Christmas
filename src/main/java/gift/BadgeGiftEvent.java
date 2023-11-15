package gift;

import static gift.Badge.*;

import discount.ChristmasDisCount;
import discount.SpecialDiscount;
import discount.WeekdayDiscount;
import discount.WeekendDiscount;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public abstract class BadgeGiftEvent {

    public String checkGiftBadge(List<OrderInfo>orderInfoList, LocalDate localDate) {

        int eventDiscountAcceptResult = getEventAllPrice(orderInfoList, localDate);
        
        if ((STAR.getBadgeValue() <= eventDiscountAcceptResult) && (TREE.getBadgeValue() > eventDiscountAcceptResult)) {
            return STAR.getBadgeName();
        }
        if ((TREE.getBadgeValue() <= eventDiscountAcceptResult) && (SANTA.getBadgeValue() > eventDiscountAcceptResult)) {
            return TREE.getBadgeName();
        }
        if (SANTA.getBadgeValue() <= eventDiscountAcceptResult) {
            return SANTA.getBadgeName();
        }
        return null;
    }

    private static int getEventAllPrice(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int discountAcceptPrice = getDiscountResult(orderInfoList, localDate);
        int orderInfoAllPrice = getAllPrice(orderInfoList);
        return orderInfoAllPrice - discountAcceptPrice;
    }

    public static int getDiscountResult(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int christmasDiscountResult = ChristmasDisCount.christmasDiscount(orderInfoList, localDate);
        int specialDiscountResult = SpecialDiscount.discountSpecial(orderInfoList, localDate);
        int weekdayDiscountResult = WeekdayDiscount.discountWeekDay(orderInfoList, localDate);
        int weekendDiscountResult = WeekendDiscount.discountWeekend(orderInfoList, localDate);

        return christmasDiscountResult + specialDiscountResult + weekdayDiscountResult + weekendDiscountResult;
    }

    private static int getAllPrice(List<OrderInfo> orderInfoList) {
        return orderInfoList.stream()
                .mapToInt(OrderInfo::getAllPrice)
                .sum();
    }
}
