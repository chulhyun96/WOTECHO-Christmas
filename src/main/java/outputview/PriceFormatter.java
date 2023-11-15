package outputview;

import java.text.NumberFormat;

public abstract class PriceFormatter {
    private static final String PRICE_UNIT = "?";
    public static String formatPrice(int price) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(price) + PRICE_UNIT;
    }
}
