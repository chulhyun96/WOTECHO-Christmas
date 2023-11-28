package discount;

import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;

public interface DiscountStrategy {
    int applyDiscountStrategy(List<OrderInfo> orderInfoList, LocalDate localDate);
    boolean isDiscountAccept(LocalDate localDate);

}
