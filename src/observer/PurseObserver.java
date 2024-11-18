package observer;

import money.MoneyType;

import java.util.Map;

public interface PurseObserver {
    public void updatePurse(Map<MoneyType, Integer> state, double totalValue);
}
