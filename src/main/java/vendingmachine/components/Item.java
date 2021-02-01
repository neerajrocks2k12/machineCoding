package vendingmachine.components;

public enum Item {
    COKE("Coke", 25);

    private final String itemName;
    private final int itemPrice;

    Item(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}
