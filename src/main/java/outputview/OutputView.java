package outputview;

import static constants.SystemConstants.NONE_DISCOUNT;

import benefit.BenefitDetailsPrinter;
import gift.BadgeGiftEvent;
import gift.ChampagneGiftEvent;
import java.time.LocalDate;
import java.util.List;
import menu.MenuItem;
import order.OrderInfo;

public abstract class OutputView {
    private static final String NOTHING = "없음";

    public static void printMessage(String message) {
        System.out.println(message);
    }
    private static void printMenuInfo(List<OrderInfo> orderedList) {
        System.out.println("<주문 메뉴>");

        orderedList.stream()
                .forEach(orderInfo -> {
                    System.out.println(orderInfo.getMenuName() + " " + orderInfo.getQuantity() +"개");
                });

    }

    // 1 햬텍 미리보기
    public static void printWelcomeMessage(int day) {
        printMessage("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }
    // 2주문 메뉴 출력
    public static void printOrderedInfo(List<OrderInfo> orderedList) {
        printMenuInfo(orderedList);
        System.out.println();
    }
    // 3 할인 전 주문 총 금액
    public static void beforeDiscountPrice(List<OrderInfo> userOrderInfo) {
        System.out.println("<할인 전 총주문 금액>");
        int allPrice = userOrderInfo.stream()
                .mapToInt(OrderInfo::getAllPrice)
                .sum();

        String print = PriceFormatter.formatPricePlus(allPrice);
        printMessage(print);
        System.out.println();

    }
    //4 증정 메뉴, 샴페인 할인 이벤트가 적용되기전 가격을 중심으로
    public static void giftChampagne(List<OrderInfo> orderInfoList) {
        System.out.println("<증정 메뉴>");
        String giftResult = ChampagneGiftEvent.getChampagne(orderInfoList);
        printMessage(giftResult);
        System.out.println();

    }

    //5 혜택 내역
    public static void printBenefitDetails(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int allDiscountDetails = BadgeGiftEvent.getDiscountResult(orderInfoList, localDate);
        System.out.println("<혜택 내역>");

        if (allDiscountDetails == NONE_DISCOUNT) {
            printMessage(NOTHING);
        }
        if (allDiscountDetails != NONE_DISCOUNT) {
            //크리스마스 혜택 할인 받음
            BenefitDetailsPrinter.printChristmasBenefit(orderInfoList, localDate);
            // 특별 혜택 받아야됨.
            BenefitDetailsPrinter.printSpecialBenefit(orderInfoList, localDate);
            //평일 할인
            BenefitDetailsPrinter.printWeekdayBenefit(orderInfoList, localDate);
            //주말 할인
            BenefitDetailsPrinter.printWeekendDiscount(orderInfoList, localDate);
            //증정 이벤트
            String champagnePrice = ChampagneGiftEvent.getChampagnePrice(orderInfoList);
            printMessage(champagnePrice);


        }
        System.out.println();
    }
    //6. 총 혜택 금액
    public static void printAllBenefitAcceptPrice(List<OrderInfo> orderInfoList, LocalDate localDate){
        // 31,246원
        System.out.println("<총혜택 금액>");
        int allDiscountResult = BadgeGiftEvent.getDiscountResult(orderInfoList, localDate);

        if (ChampagneGiftEvent.replyIfGetChampagneGift(orderInfoList)) {
            allDiscountResult += MenuItem.CHAMPAGNE.getPrice();
        }
        String allEventAcceptResult = PriceFormatter.formatPriceMinus(allDiscountResult);
        printMessage(allEventAcceptResult);
        System.out.println();
    }
    // 할인 후 예상 결제 금액
    public static void printAfterDiscountPrice(List<OrderInfo> userOrderInfo, LocalDate localDate) {
        System.out.println("<할인 후 예상 결제 금액>");
        int allPrice = userOrderInfo.stream()
                .mapToInt(OrderInfo::getAllPrice)
                .sum();
        int allDiscountResult = BadgeGiftEvent.getDiscountResult(userOrderInfo, localDate);
        int afterDiscount = allPrice - allDiscountResult;
        String printResult = PriceFormatter.formatPricePlus(afterDiscount);
        printMessage(printResult);
        System.out.println();
    }
    // 12월 이벤트 배지
    public static void printEventBadge(List<OrderInfo> orderInfoList, LocalDate localDate) {
        printMessage("<12월 이벤트 배지>");
        String badge = BadgeGiftEvent.checkGiftBadge(orderInfoList, localDate);
        printMessage(badge);
    }
}

