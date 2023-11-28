package outputview;

import java.text.NumberFormat;

public abstract class PriceFormatter {
    private static final String PRICE_UNIT = "원";
    public static String formatPricePlus(int price) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(price) + PRICE_UNIT;
    }
    public static String formatPriceMinus(int price) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(-Math.abs(price)) + PRICE_UNIT;
    }
}
