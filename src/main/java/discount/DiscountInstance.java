package discount;

import java.util.ArrayList;
import java.util.List;

public abstract class DiscountInstance {
    private static SpecialDiscount getSpecialDiscount() {
        return SpecialDiscount.getInstance();
    }

    private static ChristmasDisCount getChristmasDiscount() {
        return ChristmasDisCount.getInstance();
    }

    private static WeekendDiscount getWeekendDiscount() {
        return WeekendDiscount.getInstance();
    }

    private static WeekdayDiscount getWeekdayDiscount() {
        return WeekdayDiscount.getInstance();
    }
    public static List<DiscountStrategy> getAllDiscountStrategies() {
        List<DiscountStrategy> strategies = new ArrayList<>();
        strategies.add(getSpecialDiscount());
        strategies.add(getChristmasDiscount());
        strategies.add(getWeekendDiscount());
        strategies.add(getWeekdayDiscount());
        return strategies;
    }
}
