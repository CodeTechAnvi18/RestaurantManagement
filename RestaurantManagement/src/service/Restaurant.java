package service;

import java.util.ArrayList;

import entity.CustomerOrder;
import entity.MenuItem;
import exception.ItemNotFoundException;

public class Restaurant {
    private ArrayList<MenuItem> menuItems;
    private ArrayList<CustomerOrder> customerOrders;

    public Restaurant() {
        menuItems = new ArrayList<>();
        customerOrders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
        System.out.println("Menu item " + menuItem.getItemName() + " added successfully.");
    }

    public void updateMenuItem(int itemId, String itemName, double price) throws ItemNotFoundException {
        MenuItem menuItem = findMenuItemById(itemId);
        menuItem.setItemName(itemName);
        menuItem.setPrice(price);
        System.out.println("Menu item " + itemName + " updated successfully.");
    }

    public void removeMenuItem(int itemId) throws ItemNotFoundException {
        MenuItem menuItem = findMenuItemById(itemId);
        menuItems.remove(menuItem);
        System.out.println("Menu item " + menuItem.getItemName() + " removed successfully.");
    }

    private MenuItem findMenuItemById(int itemId) throws ItemNotFoundException {
        for (MenuItem item : menuItems) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new ItemNotFoundException("Menu item with ID " + itemId + " not found.");
    }

    public void placeOrder(int itemId, int quantity) throws ItemNotFoundException {
        MenuItem menuItem = findMenuItemById(itemId);
        if (!menuItem.isAvailable()) {
            System.out.println("Menu item " + menuItem.getItemName() + " is not available.");
            return;
        }

        CustomerOrder order = new CustomerOrder(menuItem, quantity);
        customerOrders.add(order);
        System.out.println("Order placed: " + quantity + " x " + menuItem.getItemName() + " for $" + order.getTotalPrice());
    }

    public void displayMenu() {
        System.out.println("Menu Items:");
        for (MenuItem item : menuItems) {
            if (item.isAvailable()) {
                System.out.println("ID: " + item.getItemId() + ", Name: " + item.getItemName() + ", Price: $" + item.getPrice());
            }
        }
    }

    public void displayOrders() {
        System.out.println("Customer Orders:");
        for (CustomerOrder order : customerOrders) {
            System.out.println(order.getQuantity() + " x " + order.getMenuItem().getItemName() + " for $" + order.getTotalPrice());
        }
    }

    public void generateBill() {
        double total = 0.0;
        System.out.println("----- Bill Summary -----");
        for (CustomerOrder order : customerOrders) {
            System.out.println(order.getQuantity() + " x " + order.getMenuItem().getItemName() + " = $" + order.getTotalPrice());
            total += order.getTotalPrice();
        }
        System.out.println("Total Bill: $" + total);
        System.out.println("------------------------");
    }
}