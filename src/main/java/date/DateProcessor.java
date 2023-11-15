package date;

import inputview.InputView;
import java.time.LocalDate;
import java.util.List;
import order.OrderInfo;
import order.OrderProcessor;


public class DateProcessor {

    private OrderProcessor orderProcessor;

    public DateProcessor(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    //DateReserve로 부터 받는 date 값에 따라 할인 적용하는건데
    public void asd() {
        // 날짜 예약
        LocalDate userInputDate = DateReserve.reserveDate();

        // 메뉴 리스트로 받기
        List<String> userInputOrderInfo = InputView.readMenu();

        //orderProcessor 객체 생성 시 메뉴 생성되고, orderInfoList 메서드 호출 시 orderInfo 객체 생성
        // 그리고 각종 Validator 메서드를 통해 검증 로직 실행
        List<OrderInfo> userOrderInfo = OrderProcessor.orderInfoList(userInputOrderInfo);
        // 그리고 orderInfo

    }

}