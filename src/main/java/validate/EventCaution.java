package validate;


import java.util.List;
import menu.MenuCategory;
import menu.MenuItem;
import order.OrderInfo;

public abstract class EventCaution {
    private static final int UNACCEPTABLE_PRICE = 10000;
    public static boolean checkPrice(List<OrderInfo> userOrderInfo) {
        // ? ?? ??? ?? ???? ??? ??
        // ???? ?? ??? Discount ??? ?????? ???? ??
        int totalPrice = userOrderInfo.stream()
                .mapToInt(orderInfo -> orderInfo.getMenuPrice() * orderInfo.getQuantity())
                .sum();
        return totalPrice >= UNACCEPTABLE_PRICE;
        }

    public static boolean checkMenu(List<OrderInfo> userOrderInfo) {
        // ??? ??? ?? ?? ?? ???? ????, ??? ???? ??
        // ?? ??
        return userOrderInfo.stream()
                .allMatch(orderInfo -> orderInfo.getMenuCategory() == MenuCategory.BEVERAGE);

    }
    public static boolean checkCountOrderInfo(List<OrderInfo> userOrderInfo) {
        // ??? ? ?? ?? 20? ??? ??? ? ??.
        int totalQuantity = userOrderInfo.stream()
                .mapToInt(OrderInfo :: getQuantity)
                .sum();
        return totalQuantity <= 20;
    }
}
