package gift;

import menu.MenuItem;
import order.OrderInfoList;
import outputview.PriceFormatter;

public abstract class ChampagneGiftEvent {
    private final static int GIFT_EVENT_ACCEPT_PRICE = 120000;
    private final static String GIFT_EVENT = "증정 이벤트: ";
    private final static String NOTHING = "없음";
    private static final String ONE_GIFT_CHAMPAGNE = " 1개";

    // 할인 이벤트가 적용 되기전
    public static String getChampagne() {
        if (replyIfGetChampagneGift()) {
            return MenuItem.CHAMPAGNE.getMenuName() + ONE_GIFT_CHAMPAGNE;
        }
        return NOTHING;
    }
    public static String getChampagnePrice() {
        if (replyIfGetChampagneGift()) {
            int champagnePrice = MenuItem.CHAMPAGNE.getPrice();
            return GIFT_EVENT + PriceFormatter.formatPriceMinus(champagnePrice);
        }
        return NOTHING;
    }
    public static boolean replyIfGetChampagneGift() {
        return OrderInfoList.getAllOrderPrice() >= GIFT_EVENT_ACCEPT_PRICE;


    }
}
