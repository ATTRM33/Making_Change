package strategy;

import purse.Purse;

public interface ChangeStrategy {
    Purse makeChange(double amount);
}
