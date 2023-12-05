package discount;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import order.OrderInfo;

public abstract class DiscountCalculator {

    private static final List<DiscountStrategy> discountStrategyList = Arrays.asList(ChristmasDisCount.getInstance(),
            SpecialDiscount.getInstance(),
            WeekdayDiscount.getInstance(), WeekendDiscount.getInstance());


    public static int getAllDiscountPrice(List<OrderInfo> orderInfoList, LocalDate localDate) {
        return discountStrategyList.stream()
                .mapToInt(discountStrategiesList ->
                        discountStrategiesList.applyDiscountStrategy(orderInfoList, localDate))
                .sum();
    }
}
