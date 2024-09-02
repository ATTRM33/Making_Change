import java.util.Map;
import java.util.HashMap;

public class Purse {
    private Map<MoneyType, Integer> cash;

    public Purse() {
        this.cash = new HashMap<>();
    }

    public void add(MoneyType type, int num){
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double remove(MoneyType type, int num){
        //current count of money type in the purse
        int count = cash.getOrDefault(type, 0); //current count of money type in the purse

        if (count < num) {
            count = num;
        }
        if (num > 0) {
            cash.put(type, count - num);
        }
        return num * type.amt();
    }
}

