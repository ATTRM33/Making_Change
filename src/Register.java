import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Register {
    private static final List<MoneyType> MONEY = Arrays.asList(
            new MoneyType("Hundred Dollar", 100.0, "cash","hundred_note.png"),
            new MoneyType("Fifty Dollar", 50.0, "cash", "fifty_not.png"),
            new MoneyType("Twenty Dollar", 20.0,"cash", "twenty_note.png"),
            new MoneyType("Ten Dollar", 10.0, "cash", "ten_note.png"),
            new MoneyType("Five Dollar", 5.0, "cash", "five_note.png"),
            new MoneyType("One Dollar", 1.0, "cash", "one_note.png"),
            new MoneyType("Quarter", 0.25, "coin", "quarter.png"),
            new MoneyType("Dime", 0.10, "coin", "dime.png"),
            new MoneyType("Nickel", 0.05, "coin", "nickel.png"),
            new MoneyType("Penny", 0.01, "coin", "penny.png")
    );
}
