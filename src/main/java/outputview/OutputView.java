package outputview;

import static constants.SystemConstants.NONE_DISCOUNT;
import static constants.SystemConstants.NOTHING;

import benefit.BenefitDetailsPrinter;
import discount.DiscountCalculator;
import gift.BadgeGiftEvent;
import gift.ChampagneGiftEvent;
import java.time.LocalDate;
import java.util.List;
import menu.MenuItem;
import order.OrderInfo;
import order.OrderInfoList;

public abstract class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printMenuInfo(List<OrderInfo> orderedList) {
        printMessage("<주문 메뉴>");
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
    public static void beforeDiscountPrice() {
        System.out.println("<할인 전 총주문 금액>");

        int allOrderPrice = OrderInfoList.getAllOrderPrice();
        String print = PriceFormatter.formatPricePlus(allOrderPrice);
        printMessage(print);
        System.out.println();

    }
    //4 증정 메뉴, 샴페인 할인 이벤트가 적용되기전 가격을 중심으로
    public static void giftChampagne() {
        printMessage("<증정 메뉴>");
        String giftResult = ChampagneGiftEvent.getChampagne();
        printMessage(giftResult);
        System.out.println();
    }

    //5 혜택 내역 이 때 할인 정책 객체 들이 생성이 되어야해
    public static void printBenefitDetails(List<OrderInfo> orderInfoList, LocalDate localDate) {
        int allDiscountDetails = DiscountCalculator.getAllDiscountPrice(orderInfoList, localDate);
        printMessage("<혜택 내역>");

        if (allDiscountDetails == NONE_DISCOUNT) {
            printMessage(NOTHING);
            resultOfChampagne();
            return;
        }
        benefitList(orderInfoList, localDate);
        resultOfChampagne();

    }
    private static void resultOfChampagne() {
        String champagnePrice = ChampagneGiftEvent.getChampagnePrice();

        if (!champagnePrice.equals(NOTHING)) {
            printMessage(champagnePrice);
        }
        System.out.println();
    }
    private static void benefitList(List<OrderInfo> orderInfoList, LocalDate localDate) {
        BenefitDetailsPrinter.printChristmasBenefit(orderInfoList, localDate);
        BenefitDetailsPrinter.printWeekdayBenefit(orderInfoList, localDate);
        BenefitDetailsPrinter.printSpecialBenefit(orderInfoList, localDate);
        BenefitDetailsPrinter.printWeekendDiscount(orderInfoList, localDate);
    }

    //6. 총 혜택 금액
    public static void printAllBenefitAcceptPrice(List<OrderInfo> orderInfoList, LocalDate localDate){
        // 31,246원
        printMessage("<총혜택 금액>");
        int allDiscountResult = DiscountCalculator.getAllDiscountPrice(orderInfoList, localDate);

        if (ChampagneGiftEvent.replyIfGetChampagneGift()) {
            allDiscountResult += MenuItem.CHAMPAGNE.getPrice();
        }
        String allEventAcceptResult = PriceFormatter.formatPriceMinus(allDiscountResult);
        printMessage(allEventAcceptResult);
        System.out.println();
    }

    // 할인 후 예상 결제 금액
    public static void printAfterDiscountPrice(List<OrderInfo> userOrderInfo, LocalDate localDate) {
        printMessage("<할인 후 예상 결제 금액>");

        int allOrderPrice = OrderInfoList.getAllOrderPrice();

        int allDiscountResult = DiscountCalculator.getAllDiscountPrice(userOrderInfo, localDate);
        int afterDiscount = allOrderPrice - allDiscountResult;

        String printResult = PriceFormatter.formatPricePlus(afterDiscount);
        printMessage(printResult);
        System.out.println();
    }
    // 12월 이벤트 배지
    public static void printEventBadge() {
        printMessage("<12월 이벤트 배지>");
        String badge = BadgeGiftEvent.checkGiftBadge();
        printMessage(badge);
    }
}

