package gift;

import static constants.SystemConstants.NOTHING;
import static constants.SystemConstants.UNACCEPTABLE_PRICE;

import java.util.List;
import order.OrderInfo;

public abstract class BadgeGiftEvent {
    public static String checkGiftBadge (List<OrderInfo> orderInfoList) {
        if (checkIfGetBadge(orderInfoList)) {
            return Badge.getBadge(getOrderAllPrice(orderInfoList));
        }
        return NOTHING;
    }
    private static boolean checkIfGetBadge (List<OrderInfo> orderInfoList) {
        return getOrderAllPrice(orderInfoList) >= UNACCEPTABLE_PRICE;
    }
    private static int getOrderAllPrice(List<OrderInfo> orderInfoList) {
        return orderInfoList.stream()
                .mapToInt(OrderInfo :: getAllPrice)
                .sum();
    }
}
