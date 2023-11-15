package gift;

import java.util.List;
import menu.MenuItem;
import order.OrderInfo;

public abstract class ChampagneGiftEvent {
    private final static int GIFT_EVENT_ACCEPT_PRICE = 120000;
    private static final String ONE_GIFT_CHAMPAGNE = " 1개";

    // 할인 이벤트가 적용 되기전
    public static String getChampagne(List<OrderInfo> orderInfoList) {
        if (replyIfGetChampagneGift(orderInfoList)) {
            return MenuItem.CHAMPAGNE.getMenuName() + ONE_GIFT_CHAMPAGNE;
        }
        return "없음";
    }

    private static boolean replyIfGetChampagneGift(List<OrderInfo> oderInfoList) {
        int orderInfoAllPrice = oderInfoList.stream()
                .mapToInt(OrderInfo::getAllPrice)
                .sum();
        if (orderInfoAllPrice >= GIFT_EVENT_ACCEPT_PRICE) {
            return true;
        }
        return false;
    }

}
