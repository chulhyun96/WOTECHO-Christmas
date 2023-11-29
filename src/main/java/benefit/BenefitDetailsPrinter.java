package benefit;

import static date.Event.CHRISTMAS_DDAY;
import static date.Event.SPECIAL_DISCOUNT;
import static date.Event.WEEKDAY_DISCOUNT;
import static date.Event.WEEKEND_DISCOUNT;
import static outputview.OutputView.printMessage;

import discount.ChristmasDisCount;
import discount.SpecialDiscount;
import discount.WeekdayDiscount;
import discount.WeekendDiscount;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;
import outputview.PriceFormatter;

public abstract class BenefitDetailsPrinter {
    private static final String CHRISTMAS_DISCOUNT_MESSAGE = CHRISTMAS_DDAY.getDisplayName() + ": ";
    private static final String SPECIAL_PRINT_FORMAT = SPECIAL_DISCOUNT.getDisplayName() + ": ";
    private static final String WEEKDAY_PRINT_FORMAT = WEEKDAY_DISCOUNT.getDisplayName() + ": ";
    private static final String WEEKEND_PRINT_FORMAT = WEEKEND_DISCOUNT.getDisplayName() + ": ";


    public static void printWeekdayBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int weekdayDiscount = WeekdayDiscount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        boolean isBenefitAccept = BenefitDetailsJudge.responseWeekdayBenefit(weekdayDiscount);

        if (isBenefitAccept) {
            printMessage(WEEKDAY_PRINT_FORMAT + PriceFormatter.formatPriceMinus(weekdayDiscount));
        }
    }

    public static void printSpecialBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int specialDiscount = SpecialDiscount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        boolean isBenefitAccept = BenefitDetailsJudge.responseSpecialBenefit(specialDiscount);

        if (isBenefitAccept) {
            printMessage(SPECIAL_PRINT_FORMAT + PriceFormatter.formatPriceMinus(specialDiscount));
        }
    }

    public static void printChristmasBenefit(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int christmasDiscount = ChristmasDisCount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        boolean isBenefitAccept = BenefitDetailsJudge.responseChristmasBenefit(christmasDiscount);

        if (isBenefitAccept) {
            printMessage(CHRISTMAS_DISCOUNT_MESSAGE + PriceFormatter.formatPriceMinus(christmasDiscount));
        }
    }

    public static void printWeekendDiscount(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int weekendDiscount = WeekendDiscount.getInstance().applyDiscountStrategy(orderInfoList, localDate);
        boolean isBenefitAccept = BenefitDetailsJudge.responseWeekendBenefit(weekendDiscount);

        if (isBenefitAccept) {
            printMessage(WEEKEND_PRINT_FORMAT + PriceFormatter.formatPriceMinus(weekendDiscount));
        }
    }
}

