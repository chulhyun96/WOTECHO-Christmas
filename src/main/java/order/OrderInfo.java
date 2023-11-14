package order;

import menu.Menu;
import menu.MenuCategory;

public class OrderInfo {
    private Menu menu;
    private int quantity;

    public OrderInfo(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public MenuCategory getMenuCategory() {
        return menu.getMenuCategory();
    }

    public int getMenuPrice() {
        return menu.getMenuPrice();
    }

    public int getQuantity() {
        return this.quantity;
    }
}
