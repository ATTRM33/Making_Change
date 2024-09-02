import java.util.Map;
import java.util.HashMap;

public class Purse {
    private Map<MoneyType, Integer> cash;

    public Purse() {
        this.cash = new HashMap<>();
    }

    public void add(MoneyType type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(MoneyType type, int num) {
        int count = cash.getOrDefault(type, 0); //current count of money type in the purse

        if (count < num) {
            count = num; // if value entered is larger than the amt in the purse then count is equal to number
        }
        if (num > 0) {
            cash.put(type, count - num);
        }
        return num * type.amt();
    }

    public double getValue() {

        //returns set of all entries, converts them to stream of doubles, takes the value and multiplies it by
        //the number of entries and returns the sum of all values
        return cash.entrySet().stream().mapToDouble(entry -> entry.getKey().amt() * entry.getValue()).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("The Purse Contains:\n");
        for (Map.Entry<MoneyType, Integer> entry : cash.entrySet()) {
            sb.append(entry.getValue())
                    .append(" ")
                    .append(entry.getKey().name())
                    .append(" (")
                    .append(entry.getKey().form())
                    .append(") - $")
                    .append(entry.getKey().amt())
                    .append(" each\n");
        }
        sb.append("Total Value: $").append(getValue());
        return sb.toString();
    }
}

