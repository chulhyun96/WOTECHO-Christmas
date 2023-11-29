package discount;

import static constants.SystemConstants.NONE_DISCOUNT;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import order.OrderInfo;

public class AllDiscountPrice {
    private boolean isStrategyUpdate = true;
    private List<DiscountStrategy> discountStrategyList;

    private void getDiscountStrategyList() {
        discountStrategyList = Arrays.asList(ChristmasDisCount.getInstance(), SpecialDiscount.getInstance(),
                WeekdayDiscount.getInstance(), WeekendDiscount.getInstance());
    }
    private boolean isListDuplication() {
        if (isStrategyUpdate) {
            getDiscountStrategyList();
            this.isStrategyUpdate = false;
            return false;
        }
        return true;
    }
    public int getAllDiscountPrice(List<OrderInfo> orderInfoList, LocalDate localDate) {
        if (!isListDuplication()) {
            return discountStrategyList.stream()
                    .mapToInt(discountStrategyList1 ->
                            discountStrategyList1.applyDiscountStrategy(orderInfoList, localDate))
                    .sum();
        }
        return NONE_DISCOUNT;
    }
}
