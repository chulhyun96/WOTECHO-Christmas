package gift;

import static constants.SystemConstants.NONE_DISCOUNT;

import java.util.List;
import menu.MenuItem;
import order.OrderInfo;

public abstract class GiftEvent {
    private final static int GIFT_EVENT_ACCEPT_PRICE = 120000;
    private final static String GIFT_CHAMPAGNE = MenuItem.CHAMPAGNE.getMenuName() + " 1개";

    public static String checkAllPrice(List<OrderInfo> oderInfoList) {
        int allPrice = oderInfoList.stream()
                .mapToInt(orderInfo -> orderInfo.getMenuPrice() * orderInfo.getQuantity())
                .sum();
        if (allPrice >= GIFT_EVENT_ACCEPT_PRICE) {
            return GIFT_CHAMPAGNE;
        }
        return NONE_DISCOUNT;
    }

}
