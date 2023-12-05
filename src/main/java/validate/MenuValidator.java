package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.Menu;
import menu.MenuList;

public abstract class MenuValidator {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 20;
    private static final int VALID_MENU_COUNT_RANGE = 2;
    private static final String ERROR_INPUT_QUANTITY_MESSAGE = "[ERROR] 주문 수량은 1개 이상 20개 이하여야 합니다.";
    private static final String ERROR_CONVERT_TO_INT_MESSAGE = "[ERROR] 수량은 숫자로만 입력해주세요";
    private static final String ERROR_MENU_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final Set<String> menuNames = new HashSet<>();

    public static void validateQuantity(int quantity) {
        if (!(MIN_QUANTITY <= quantity && quantity <= MAX_QUANTITY)) {
            throw new IllegalArgumentException(ERROR_INPUT_QUANTITY_MESSAGE);
        }
    }
    public static int validateConvertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_CONVERT_TO_INT_MESSAGE);
        }
    }

    public static void validateOrderFormat(String[] parts) {
        if (parts.length != VALID_MENU_COUNT_RANGE || !parts[1].trim().matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MENU_MESSAGE);
        }
    }
    public static Menu findValidMenu(String menuName) {
        List<Menu> menuListForValidation = MenuList.getMenuList();
        return menuListForValidation.stream()
                .filter(menu -> menu.isContainName(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MENU_MESSAGE));
    }

    public static void validateMenuDuplication(String menuName) {
        if (menuNames.contains(menuName)) {
            throw new IllegalArgumentException("주문 메뉴 이름 중복");
        }
        menuNames.add(menuName);
    }
    public static void clearMenuNamesForDuplication() {
        menuNames.clear();
    }

}
