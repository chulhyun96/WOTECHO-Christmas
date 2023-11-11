package order;

import menu.Menu;

public class OrderInfo {
    private Menu menu;
    private int quantity;

    private OrderInfo(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static OrderInfo createOrderInfo(Menu menu, int quantity) {
        return new OrderInfo(menu, quantity);
    }
}
