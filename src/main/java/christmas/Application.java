package christmas;

import date.DateReserve;
import inputview.InputView;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;
import order.OrderProcessor;
import outputview.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LocalDate reservedDate = DateReserve.reserveDate();
        int day = reservedDate.getDayOfMonth();

        List<String> userOrderInfoString = InputView.readMenu();

        OutputView.printWelcomeMessage(day);

        List<OrderInfo> orderInfoList = OrderProcessor.orderInfoList(userOrderInfoString);

        OutputView.printOrderedInfo(orderInfoList);

        OutputView.beforeDiscountPrice(orderInfoList);

        OutputView.giftChampagne(orderInfoList);

        OutputView.printBenefitDetails(orderInfoList, reservedDate);

        OutputView.printAllBenefitAcceptPrice(orderInfoList, reservedDate);

        OutputView.printAfterDiscountPrice(orderInfoList, reservedDate);

        OutputView.printEventBadge(orderInfoList, reservedDate);

    }
}
