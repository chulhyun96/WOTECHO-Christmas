package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.Menu;
import menu.MenuList;

public abstract class MenuValidator {
    private static final int MIN_QUANTITY = 1;
    private static final int VALID_MENU_COUNT_RANGE = 2;
    private static final int MAX_QUANTITY = 20;
    private static final String ERROR_INPUT_QUANTITY_MESSAGE = "[ERROR] 주문 수량은 1개 이상 20개 이하여야 합니다.";
    private static final String ERROR_CONVERT_TO_INT_MESSAGE = "[ERROR] 수량은 숫자로만 입력해주세요";
    private static final String ERROR_MENU_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final Set<String> menuNames = new HashSet<>();

    public static void validateQuantity(int quantity) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(ERROR_INPUT_QUANTITY_MESSAGE);
        }
    }   public static int validateConvertToInt(String input) {
        int quantity;
        try {
            quantity = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_CONVERT_TO_INT_MESSAGE);
        }
        return quantity;
    }

    public static void validateOrderFormat(String[] parts) {
        if (parts.length != VALID_MENU_COUNT_RANGE || !parts[1].trim().matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MENU_MESSAGE);
        }
    }
    public static Menu validateMenuExist(String menuName) {
        // 파라미터로 들어온 메뉴이름을 가진 메뉴가 존재하는지 검사후 해당 Menu 객체를 반환
        List<Menu> menuListForValidation = MenuList.getMenuList();
        return menuListForValidation.stream()
                .filter(menu -> menu.isContainName(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MENU_MESSAGE));
    }
    public static void validateMenuDuplication(String menuName) {
        if (menuNames.contains(menuName)) {
            // 중복된 메뉴 이름을 발견한 경우 에러를 발생시킵니다.
            throw new IllegalArgumentException("주문 메뉴 이름 중복");
        }
        menuNames.add(menuName); // 메뉴 이름을 Set에 추가합니다.
    }
    public static void clearMenuNamesForDuplication() {
        menuNames.clear();
    }

}
