package validate;

import java.util.List;
import menu.Menu;
import menu.MenuList;

public abstract class MenuValidator {
    public static void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("[ERROR] 주문 수량은 1개 이상이여야 합니다.");
        }
    }   public static int validateConvertToInt(String input) {
        int quantity;
        try {
            quantity = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 수량은 숫자로만 입력해주세요");
        }
        return quantity;
    }

    public static Menu validateMenuExist(String menuName) {
        // 파라미터로 들어온 메뉴이름을 가진 메뉴가 존재하는지 검사후 해당 Menu 객체를 반환
        List<Menu> menuListForValidation = MenuList.getMenuList();
        return menuListForValidation.stream()
                .filter(menu -> menu.isContainName(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 메뉴는 존재하지 않습니다."));
    }
}
