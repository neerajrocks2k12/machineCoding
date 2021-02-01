package vendingmachine.config;

import vendingmachine.components.Coin;
import vendingmachine.components.Item;
import vendingmachine.exceptions.NotSufficientChangeException;
import vendingmachine.exceptions.SoldOutException;
import vendingmachine.helper.Bucket;
import vendingmachine.helper.Inventory;

import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {
    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl() {

    }

    private void init() {
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }

        for (Item item : Item.values()) {
            itemInventory.put(item, 5);
        }
    }

    @Override
    public long selectItemAndGetPrice(Item item) {
        if (itemInventory.hasItem(item)) {
            currentItem = item;
            return currentItem.getItemPrice();
        }
        String errorMessage = String.format("%s sold out, please select something else.", item);
        throw new SoldOutException(errorMessage);
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange()
        return null;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        return null;
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentBalance = 0;
        currentItem = null;
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.emptyList();
        long balance = amount;
        while(balance > 0) {
            if(balance >= Coin.QUARTER.getDenomination() &&
                    cashInventory.hasItem(Coin.QUARTER)) {
                changes.add(Coin.QUARTER);
                balance -= Coin.QUARTER.getDenomination();
                continue;
            } else if(balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {

            }
        }
        return changes;
    }

    private void updateCashInventory(List<Coin> change) {
        for(Coin coin:change) {
            cashInventory.deduct(coin);
        }
    }

    public long getTotalSales() {
        return this.totalSales;
    }

    public void printStats() {
        System.out.println(String.format("Total Sales: %ld", totalSales));
        System.out.println(String.format("Current Items: %s", itemInventory.toString()));
        System.out.println(String.format("Current cash: %s", cashInventory.toString()));
    }
}
