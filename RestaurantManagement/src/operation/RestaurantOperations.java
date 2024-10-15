package operation;

import java.util.Scanner;

import entity.MenuItem;
import exception.ItemNotFoundException;
import service.Restaurant;

public class RestaurantOperations {

    private Restaurant restaurant;
    private Scanner sc;

    public RestaurantOperations() {
        restaurant = new Restaurant();
        sc = new Scanner(System.in);
    }

    public void displayMenu() {
        restaurant.displayMenu();
    }

    public void addMenuItem() {
        System.out.print("Enter item ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        MenuItem item = new MenuItem(id, name, price);
        restaurant.addMenuItem(item);
    }

    public void updateMenuItem() {
        try {
            System.out.print("Enter menu item ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new price: ");
            double price = sc.nextDouble();
            restaurant.updateMenuItem(id, name, price);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeMenuItem() {
        try {
            System.out.print("Enter menu item ID to remove: ");
            int id = sc.nextInt();
            restaurant.removeMenuItem(id);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void placeOrder() {
        try {
            System.out.print("Enter menu item ID: ");
            int itemId = sc.nextInt();
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            restaurant.placeOrder(itemId, quantity);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayOrders() {
        restaurant.displayOrders();
    }

    public void generateBill() {
        restaurant.generateBill();
    }
}