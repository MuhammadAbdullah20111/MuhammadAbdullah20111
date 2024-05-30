import java.util.LinkedHashMap;
import java.util.Map;

public class CoinChange {
    // Denominations of Pakistani currency
    private static final int[] DENOMINATIONS = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        int amount = 1988;
        Map<Integer, Integer> result = getChange(amount);

        // Display the result
        System.out.println("Change for Rs. " + amount + ":");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println("Rs. " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<Integer, Integer> getChange(int amount) {
        Map<Integer, Integer> changeMap = new LinkedHashMap<>();
        for (int denomination : DENOMINATIONS) {
            if (amount >= denomination) {
                int count = amount / denomination;
                amount = amount % denomination;
                changeMap.put(denomination, count);
            }
        }
        return changeMap;
    }
}
