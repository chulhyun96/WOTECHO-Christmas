package order;

import java.util.ArrayList;
import java.util.List;

public final class OrderInfoList {
    private final static List<OrderInfo>  orderInfoList = new ArrayList<>();

    public static List<OrderInfo> getOrderInfoList() {
        return orderInfoList;
    }
    public static int getAllOrderPrice() {
        return orderInfoList.stream()
                .mapToInt(OrderInfo ::getAllPrice)
                .sum();
    }

}
