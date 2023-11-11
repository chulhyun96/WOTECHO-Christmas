package menu;

public class Menu {
    private String menuName;
    private int menuPrice;
    private String menuCategory;

    private Menu(String menuName, int menuPrice, String menuCategory) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCategory = menuCategory;
    }
    public boolean isContainName(String menuName) {
        return this.menuName.equals(menuName);
    }
    public static Menu createMenu(String menuName, int menuPrice, String menuCategory) {
        return new Menu(menuName, menuPrice, menuCategory);
    }

    public String getMenuCategory() {
        return this.menuCategory;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public int getMenuPrice() {
        return this.menuPrice;
    }
}

