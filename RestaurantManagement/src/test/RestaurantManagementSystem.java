package test;

import java.util.*;

import operation.RestaurantOperations;

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RestaurantOperations operations = new RestaurantOperations();

        while (true) {
            System.out.println("\nRestaurant Management System");
            System.out.println("1. Display Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Remove Menu Item");
            System.out.println("5. Place Customer Order");
            System.out.println("6. Display Orders");
            System.out.println("7. Generate Bill");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    operations.displayMenu();
                    break;
                case 2:
                    operations.addMenuItem();
                    break;
                case 3:
                    operations.updateMenuItem();
                    break;
                case 4:
                    operations.removeMenuItem();
                    break;
                case 5:
                    operations.placeOrder();
                    break;
                case 6:
                    operations.displayOrders();
                    break;
                case 7:
                    operations.generateBill();
                    break;
                case 8:
                    System.out.println("Exiting the system...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}