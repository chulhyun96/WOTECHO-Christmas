package gift;

import java.util.List;
import order.OrderInfo;

public abstract class BadgeGiftEvent {

    public String checkGiftBadge(List<OrderInfo>orderInfoList) {

        int allPrice = getAllPrice(orderInfoList);

        if (Badge.STAR.getBadgeValue() <= allPrice && Badge.TREE.getBadgeValue() > allPrice) {
            return Badge.STAR.getBadgeName();
        }
        if (Badge.TREE.getBadgeValue() <= allPrice && Badge.SANTA.getBadgeValue() > allPrice) {
            return Badge.TREE.getBadgeName();
        }
        if (Badge.SANTA.getBadgeValue() <= allPrice) {
            return Badge.SANTA.getBadgeName();
        }
        return null;
    }

    private static int getAllPrice(List<OrderInfo> orderInfoList) {
        return orderInfoList.stream()
                .mapToInt(OrderInfo::getAllPrice)
                .sum();
    }
}
