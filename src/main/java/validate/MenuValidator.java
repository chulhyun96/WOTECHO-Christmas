package validate;

import java.util.List;
import menu.Menu;
import menu.MenuList;

public abstract class MenuValidator {
    public static void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("[ERROR] 주문 수량은 1개 이상이여야 합니다.");
        }
    }
}
