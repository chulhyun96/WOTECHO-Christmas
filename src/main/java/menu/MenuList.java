package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class MenuList {
    private static final List<Menu> menuList = createAllMenu();

    public static List<Menu> createAllMenu() {
        return Stream.of(MenuItem.values())
                .map(item -> Menu.createMenu(item.getMenuName(), item.getPrice(), item.getMenuCategory()))
                .collect(Collectors.toList());
    }

    public static List<Menu> getMenuList() {
        return new ArrayList<>(menuList);
    }
}
