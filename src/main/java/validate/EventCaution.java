package validate;


import static constants.SystemConstants.UNACCEPTABLE_PRICE;

import java.util.List;
import menu.MenuCategory;
import menu.MenuItem;
import order.OrderInfo;

public abstract class EventCaution {
    private static final String IF_ONLY_ORDER_BEVERAGE = "[ERROR] 음료만 주문할 수 없습니다.";

    public static void checkIfAllBeverages(List<String> menuNames) {
        if (isAllBeverages(menuNames)) {
            throw new IllegalArgumentException(IF_ONLY_ORDER_BEVERAGE);
        }
    }
    public static boolean checkIfEventAccept(List<OrderInfo> orderInfoList) {
        int allPrice = orderInfoList.stream()
                .mapToInt(OrderInfo::getAllPrice)
                .sum();
        return allPrice < UNACCEPTABLE_PRICE;
    }

    private static boolean isAllBeverages(List<String> menuNames) {
        return menuNames.stream()
                .map(MenuItem :: findMenuItemByName)
                .allMatch(EventCaution::isExistMenuItem);
    }

    private static boolean isExistMenuItem(MenuItem menuItem) {
        return menuItem != null && menuItem.getMenuCategory() == MenuCategory.BEVERAGE;
    }
}
