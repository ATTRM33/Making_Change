package observer;

import money.MoneyType;
import purse.Purse;

import java.util.Map;
import java.util.Observer;

public class PurseLogger implements PurseObserver {

    @Override
    public void updatePurse(Map<MoneyType, Integer> state, double totalValue) {
        System.out.println("Purse updated \n totalValue: $" + totalValue);

        for (Map.Entry<MoneyType, Integer> entry : state.entrySet()) {
            MoneyType moneyType = entry.getKey();
            Integer amount = entry.getValue();
            System.out.println(amount + " " + moneyType.name());
        }
    }
}
