package benefit;

import static constants.SystemConstants.NONE_DISCOUNT;

public abstract class BenefitDetailsJudge {
    public static boolean responseChristmasBenefit(int discountAmount) {
        return discountAmount != NONE_DISCOUNT;
    }
    public static boolean responseSpecialBenefit(int discountAmount) {
        return discountAmount != NONE_DISCOUNT;

    }
    public static boolean responseWeekdayBenefit(int discountAmount) {
        return discountAmount != NONE_DISCOUNT;
    }
    public static boolean responseWeekendBenefit(int discountAmount) {
        return discountAmount != NONE_DISCOUNT;
    }
}
