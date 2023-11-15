package menu;

import static menu.MenuCategory.*;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프",6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MAIN),
    BBQ_RIBS("바비큐립", 54000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),
    ZERO_COLA("제로콜라", 3000, BEVERAGE),
    RED_WINE("레드와인", 60000, BEVERAGE),
    CHAMPAGNE("샴페인", 25000, BEVERAGE);
    private String menuName;
    private int price;
    private final MenuCategory menuCategory;
    MenuItem(String menuName, int price, MenuCategory menuCategory) {
        this.menuName = menuName;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }
    public static MenuItem findMenuItemByName(String menuName) {
        for (MenuItem item : MenuItem.values()) {
            if (item.getMenuName().equalsIgnoreCase(menuName)) {
                return item;
            }
        }
        return null;
    }
}
