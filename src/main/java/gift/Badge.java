package gift;

import static constants.SystemConstants.NOTHING;

public enum Badge {
    STAR("별", 5000), TREE("트리", 10000), SANTA("산타", 20000);
    private final String badgeName;
    private final int badgeValue;

    Badge(String badgeName, int badgeValue) {
        this.badgeName = badgeName;
        this.badgeValue = badgeValue;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public int getBadgeValue() {
        return badgeValue;
    }

    public static String getBadge(int orderAllPrice) {
        if (STAR.getBadgeValue() <= orderAllPrice && orderAllPrice < TREE.getBadgeValue()) {
            return STAR.getBadgeName();
        }
        if (TREE.getBadgeValue() <= orderAllPrice && orderAllPrice < SANTA.getBadgeValue()) {
            return TREE.getBadgeName();
        }
        if (SANTA.getBadgeValue() <= orderAllPrice) {
            return SANTA.getBadgeName();
        }
        return NOTHING;
    }

}
