package gift;

import static constants.SystemConstants.NOTHING;
import static constants.SystemConstants.UNACCEPTABLE_PRICE;

import order.OrderInfoList;

public abstract class BadgeGiftEvent {
    public static String checkGiftBadge () {
        if (checkIfGetBadge()) {
            return Badge.getBadge(OrderInfoList.getAllOrderPrice());
        }
        return NOTHING;
    }
    private static boolean checkIfGetBadge () {
        return OrderInfoList.getAllOrderPrice() >= UNACCEPTABLE_PRICE;
    }
}
