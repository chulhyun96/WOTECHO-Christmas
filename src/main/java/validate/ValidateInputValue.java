package validate;

import menu.Menu;

public class ValidateInputValue {
    public static int validateAllAboutQuantity(String[] parts) {
        int parsedIntQuantity = MenuValidator.validateConvertToInt(parts[1].trim());
        MenuValidator.validateQuantity(parsedIntQuantity);
        return parsedIntQuantity;
    }

    public static Menu validateAllAboutMenu(String[] parts) {
        String menuName = parts[0].trim();
        Menu menu = MenuValidator.findValidMenu(menuName);
        MenuValidator.validateMenuDuplication(menu.getMenuName());
        return menu;
    }
}
