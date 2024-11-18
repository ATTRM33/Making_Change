package strategy;

import money.MoneyType;
import purse.Purse;
import observer.PurseLogger;

import java.util.List;

public class DefaultChangeStrategy implements ChangeStrategy {
    private final List<MoneyType> MONEY;

    public DefaultChangeStrategy(List<MoneyType> money) {
        this.MONEY = money;
    }

    @Override
    public Purse makeChange(double amount) {
        int cents = (int) Math.round(amount * 100);
        Purse purse = new Purse();
        PurseLogger logger = new PurseLogger();
        purse.addObserver(logger);

        for(MoneyType moneyType : MONEY) {
            int moneyCents = (int) Math.round(moneyType.amt() * 100);
            int count = cents/moneyCents;

            if (count > 0) {
                purse.add(moneyType,count);
                cents -= count * moneyCents;
            }
        }
        return purse;
    }
}
