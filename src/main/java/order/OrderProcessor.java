package order;


import inputview.InputView;
import java.util.ArrayList;
import java.util.List;
import menu.Menu;
import menu.MenuList;
import validate.EventCaution;
import validate.MenuValidator;

public abstract class OrderProcessor {
    public static List<OrderInfo> orderInfoList(List<String> inputMenuList) {
        // 주문을 받는 로직에서 inputView의 readMenu 메서드를 호출해서 ,로 분리된
        // 리스트를 파라미터로 외부에서받아
        // 외부로부터 받은 주문 리스트를 가지고 Order 객체를 생성해서 OrderList에 넣어야됨.
        // 그리고 주문 정보는 티본스태이크-2,바비큐립-1 이런식으로 들어왔음
        // 그리고 예외 주문시 재입력 받아야 됨.
        MenuList.createAllMenu();
        List<OrderInfo> orderInfoList = new ArrayList<>();

        boolean isSuccess = false;

        while (!isSuccess) {
            try {
                List<String> inputMenuNames = new ArrayList<>();

                for (String inputMenu : inputMenuList) {

                    String[] parts = inputMenu.split("-");
                    // 주문 형식 검증
                    MenuValidator.validateOrderFormat(parts);
                    //메뉴 중복과 존재의 유효성 검증
                    Menu menu = validateAllAboutMenu(parts);
                    // 수량의 유효성 검증
                    int parsedIntQuantity = validateAllAboutQuantity(parts);
                    orderInfoList.add(new OrderInfo(menu, parsedIntQuantity));

                    inputMenuNames.add(parts[0].trim());
                }
                EventCaution.checkIfAllBeverages(inputMenuNames);
                isSuccess = true;
                // 에외 모두 통과시 중복검사 set 초기화
                MenuValidator.clearMenuNamesForDuplication();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 예외 발생 시 리스트 초기화
                orderInfoList.clear();
                // 예외 발생 시 재입력
                inputMenuList = InputView.readMenu();
            }
        }
        return orderInfoList;
    }

    private static int validateAllAboutQuantity(String[] parts) {
        int parsedIntQuantity = MenuValidator.validateConvertToInt(parts[1].trim());
        MenuValidator.validateQuantity(parsedIntQuantity);
        return parsedIntQuantity;
    }

    private static Menu validateAllAboutMenu(String[] parts) {
        String menuName = parts[0].trim();
        Menu menu = MenuValidator.validateMenuExist(menuName);
        MenuValidator.validateMenuDuplication(menu.getMenuName());
        return menu;
    }

}
