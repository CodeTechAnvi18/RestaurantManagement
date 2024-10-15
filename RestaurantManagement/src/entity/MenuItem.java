package entity;

public class MenuItem {
    private int itemId;
    private String itemName;
    private double price;
    private boolean isAvailable;

    public MenuItem(int itemId, String itemName, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.isAvailable = true;  // Default item availability
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}