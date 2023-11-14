package validate;


import java.util.List;
import menu.MenuCategory;
import menu.MenuItem;
import order.OrderInfo;

public abstract class EventCaution {
    private static final int UNACCEPTABLE_PRICE = 10000;

    public static void checkIfAllBeverages(List<String> menuNames) {
        boolean allBeverages = isAllBeverages(menuNames);
        if (allBeverages) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다.");
        }
    }
    public static boolean checkIfEventAcceptPrice(List<OrderInfo> orderInfoList) {
        int allPrice = 0;
        for (OrderInfo orderInfo : orderInfoList) {
            allPrice += orderInfo.getMenuPrice() * orderInfo.getQuantity();
        }
        if (allPrice >= UNACCEPTABLE_PRICE) {
            return true;
        }
        return false;
    }
    public static void checkMenuCounts(List<OrderInfo> orderInfoList) {
        if (orderInfoList.size() > 20) {
            throw  new IllegalArgumentException("[ERROR] 메뉴는 한번에 최대 20개 까지만 주문할 수 있습니다.");
        }
    }

    private static boolean isAllBeverages(List<String> menuNames) {
        boolean allBeverages = true;
        for (String name : menuNames) {
            MenuItem menuItem = MenuItem.findMenuItemByName(name);
            if (menuItem == null || menuItem.getMenuCategory() != MenuCategory.BEVERAGE) {
                allBeverages = false;
                break;
            }
        }
        return allBeverages;
    }
}
