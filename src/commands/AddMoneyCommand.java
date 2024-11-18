package commands;

import purse.Purse;
import money.MoneyType;

public class AddMoneyCommand implements MoneyCommand{
    private Purse purse;
    private MoneyType type;
    private int amount;

    public void addMoney(Purse purse, MoneyType type, int amount){
        this.purse = purse;
        this.type = type;
        this.amount = amount;
    }
    @Override
    public void execute() {
        purse.add(type, amount);
    }

    @Override
    public void undo() {
        purse.remove(type, amount);
    }
}
