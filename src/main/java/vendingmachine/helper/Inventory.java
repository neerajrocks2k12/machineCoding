package vendingmachine.helper;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    private Map<T, Integer> inventory = new HashMap<>();

    public int getQuantity(T item) {
        return inventory.getOrDefault(item, 0);
    }

    public void add(T item) {
        inventory.put(item, 1 + inventory.getOrDefault(item, 0));
    }

    public void deduct(T item) {
        int currentCount = inventory.getOrDefault(item, 0);
        if(currentCount > 0) {
            inventory.put(item, currentCount - 1);
        }
    }

    public boolean hasItem(T item) {
        return inventory.getOrDefault(item, 0) > 0;
    }

    public void put(T item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public void clear() {
        this.inventory.clear();
    }
}
