package benefit;

import static constants.SystemConstants.NONE_DISCOUNT;

public abstract class BenefitDetailsJudge {
    public static boolean isEligibleForBenefit(int discountAmount) {
        return discountAmount != NONE_DISCOUNT;
    }
}
