package gift;

public enum Badge {
    STAR("별", 5000), TREE("트리", 10000), SANTA("산타", 20000);
    private String badgeName;
    private int badgeValue;

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
}
