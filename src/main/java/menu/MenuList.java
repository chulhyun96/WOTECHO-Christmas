package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class MenuList {
    private static List<Menu> menuList = new ArrayList<>();

    public static void createAllMenu() {
        menuList = Stream.of(MenuItem.values())
                .map(item -> Menu.createMenu(item.getMenuName(), item.getPrice(), item.getMenuCategory()))
                .toList();
    }

    public static List<Menu> getMenuList() {
        return new ArrayList<>(menuList);
    }
}
