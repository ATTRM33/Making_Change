package purse;

import java.util.*;

import money.MoneyType;
import observer.PurseObserver;

public class Purse {
    private Map<MoneyType, Integer> cash;

    private List<PurseObserver> observers;

    public Purse() {
        this.cash = new HashMap<>();

        this.observers = new ArrayList<>();
    }

    public void add(MoneyType type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
        notifyObservers();
    }

    public double remove(MoneyType type, int num) {
        //current count of money type in the purse
        int count = cash.getOrDefault(type, 0);

        if (count < num) {
            // if value entered is larger than the amt in the purse then count is equal to number
            count = num;
        }
        if (num > 0) {
            cash.put(type, count - num);
            notifyObservers();
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

        if(cash.isEmpty()) {
            System.out.println("purse.Purse is empty");
        }

        StringBuilder sb = new StringBuilder("The Purse Contains:\n");

        for (Map.Entry<MoneyType, Integer> entry : cash.entrySet()) {
            sb.append(entry.getValue())
                    .append(" ")
                    .append(entry.getKey().name())
                    .append("\n");
        }
        sb.append("Total Value: $").append(getValue());
        return sb.toString();
    }

    public Map<MoneyType, Integer> getCash() {
        return Collections.unmodifiableMap(cash);
    }

    //observers
    public void addObserver(PurseObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PurseObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {

        //notify about the state of the purse
        for (PurseObserver observer : observers) {
            observer.updatePurse(Collections.unmodifiableMap(cash), getValue());
        }
    }
}

