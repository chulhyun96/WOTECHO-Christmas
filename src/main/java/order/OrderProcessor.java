package order;


import inputview.InputView;
import java.util.ArrayList;
import java.util.List;
import menu.Menu;
import menu.MenuList;
import validate.EventCaution;
import validate.MenuValidator;
import validate.ValidateInputValue;

public abstract class OrderProcessor {
    public static List<OrderInfo> orderInfoList(List<String> inputMenuList) {
        MenuList.createAllMenu();
        List<OrderInfo> orderInfoList = new ArrayList<>();

        boolean isProcessingComplete = false;

        while (!isProcessingComplete) {
            try {
                List<String> inputMenuNames = processOrderInput(inputMenuList, orderInfoList);
                EventCaution.checkIfAllBeverages(inputMenuNames);
                isProcessingComplete = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                clearListIfException(orderInfoList);
                inputMenuList = InputView.readMenu();
            }
        }
        return orderInfoList;
    }

    private static List<String> processOrderInput(List<String> inputMenuList, List<OrderInfo> orderInfoList) {
        List<String> inputMenuNames = new ArrayList<>();

        for (String inputMenu : inputMenuList) {
            String[] parts = inputMenu.split("-");

            MenuValidator.validateOrderFormat(parts);
            Menu menu = ValidateInputValue.validateAllAboutMenu(parts);

            int parsedIntQuantity = ValidateInputValue.validateAllAboutQuantity(parts);
            orderInfoList.add(new OrderInfo(menu, parsedIntQuantity));

            inputMenuNames.add(parts[0].trim());
        }
        return inputMenuNames;
    }

    private static void clearListIfException(List<OrderInfo> orderInfoList) {
        orderInfoList.clear();
        MenuValidator.clearMenuNamesForDuplication();
    }
}
