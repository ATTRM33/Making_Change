package commands;

import purse.Purse;
import money.MoneyType;


public class AddMoneyCommand implements MoneyCommand{
    private final Purse purse;
    private final MoneyType type;
    private final int amount;

    public void addMoney(Purse purse, MoneyType type){
        this.purse = purse;
        this.type = type;
        this.amount = amount;
    }
    @Override
    public void execute() {
        purse.addMoney(type, amount);
    }

    @Override
    public void undo() {
        purse.removeMoney(type, amount);
    }
}
