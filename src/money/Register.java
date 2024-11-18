package money;

import commands.AddMoneyCommand;
import purse.Purse;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Register {
    private static final List<MoneyType> MONEY = Arrays.asList(
            new MoneyType("Hundred Dollar", 100.00, "cash","hundred_note.png"),
            new MoneyType("Fifty Dollar", 50.00, "cash", "fifty_note.png"),
            new MoneyType("Twenty Dollar", 20.00,"cash", "twenty_note.png"),
            new MoneyType("Ten Dollar", 10.00, "cash", "ten_note.png"),
            new MoneyType("Five Dollar", 5.00, "cash", "five_note.png"),
            new MoneyType("One Dollar", 1.00, "cash", "one_note.png"),
            new MoneyType("Quarter", 0.25, "coin", "quarter.png"),
            new MoneyType("Dime", 0.10, "coin", "dime.png"),
            new MoneyType("Nickel", 0.05, "coin", "nickel.png"),
            new MoneyType("Penny", 0.01, "coin", "penny.png")
    );

    public Purse makeChange(double amt) {
        int cents = (int) Math.round(amt * 100);
        Purse purse = new Purse();

        for (MoneyType money : MONEY) {

            int moneyCents = (int) Math.round(money.amt() * 100);
            int count = cents / moneyCents;

            if (count > 0) {
                //implementation of command
                AddMoneyCommand addCommand = new AddMoneyCommand(purse, money, count);
                addCommand.execute();
                cents -= count * moneyCents;
            }
        }
        return purse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an amount: ");
        double amt = sc.nextDouble();

        Register register = new Register();
        Purse purse = register.makeChange(amt);
        System.out.println(purse);

        sc.close();
    }
}
