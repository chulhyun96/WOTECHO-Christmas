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
}
