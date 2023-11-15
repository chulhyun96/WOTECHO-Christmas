package gift;

public enum Badge {
    STAR("?", 5000), TREE("??", 10000), SANTA("??", 20000);
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
