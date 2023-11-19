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

        // reserveDate 메서드 호출( readDate 메서드로 부터 사용자 입력을 받음) -> 날짜 객체 생성


        // 그 뒤 createAllMenu 메서드를 호출 해서 메뉴 객체를 생성
        // 그 후 readMenu 메서드를 호출 해서 리스트로 메뉴를 받음

        // 그럼 그 리스트를  EventCaution으로 넘김 -> 이벤트 할인이 가능한지 boolean 값으로 받음

        // orderProcessor의 orderInfoList 메서드를 호출 해서 orderInfo 객체를 생성해
        // 그 뒤 호출한 걸 리스트로 받아와서 checkOnlyBerverages 메서드의 파라미터로 넣어
        // 사용자로부터 메뉴를 입력 받음 orderProcesseor

        // 결과 출력 및 할인 받은 금액 출력

        // 날짜 입력받고 Date 객체 생성.
        LocalDate reservedDate = DateReserve.reserveDate();
        int day = reservedDate.getDayOfMonth();

        // 메뉴 입력 받기
        List<String> userOrderInfoString = InputView.readMenu();

        // 날짜에 맞게 이벤트 혜텍 미리보기 출력
        OutputView.printWelcomeMessage(day);

        // 메뉴 객체 생성 및 주문 정보 객체 생성
        List<OrderInfo> orderInfoList = OrderProcessor.orderInfoList(userOrderInfoString);

        // 12월 3일

        // 주문 메뉴 출력
        OutputView.printOrderedInfo(orderInfoList);

        //할인 전 총 주문 금액
        OutputView.beforeDiscountPrice(orderInfoList);

        //증정 메뉴
        OutputView.giftChampagne(orderInfoList);

        // 혜택 내역
        OutputView.printBenefitDetails(orderInfoList, reservedDate);

        //총 혜택 금액
        OutputView.printAllBenefitAcceptPrice(orderInfoList, reservedDate);

        //할인 후 예상 결제 금액
        OutputView.printAfterDiscountPrice(orderInfoList, reservedDate);

        //이벤트 배지
        OutputView.printEventBadge(orderInfoList, reservedDate);

    }
}
