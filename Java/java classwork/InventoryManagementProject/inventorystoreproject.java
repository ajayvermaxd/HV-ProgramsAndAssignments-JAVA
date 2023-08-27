package InventoryManagementProject;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    // constructor

    public void display() {
    }

    public double calculateValue() {

    }

    public void sell(int quantitySold) {
    }

    public void applyDiscount(double discountPercentage) {

    }

    public int compare(Product other) {

    }

    public boolean searchByName(String searchName) {
    }

    class Electronics extends Product {
        private String brand;

        @Override
        public void display() {

        }
    }

    class Clothing extends Product {
        private String size;

        public Clothing(String name, double price, int quantity, String size) {

        }

        @Override
        public void display() {

        }
    }

    class Book extends Product {
        private String author;

        public Book(String name, double price, int quantity, String author) {

        }

        @Override
        public void display() {

        }
    }

public class inventorystoreproject {
    public static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Input for the initial inventory
        System.out.println("Enter the initial inventory:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter product type (1: Electronics, 2: Clothing, 3: Book): ");
            int type = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter product name: ");
            String name = sc.nextLine();
            System.out.print("Enter product price: ");
            double price = sc.nextDouble();
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (type) {
                case 1:
                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();
                    inventory.add(new Electronics(name, price, quantity, brand));
                    break;
                case 2:
                    System.out.print("Enter size: ");
                    String size = sc.nextLine();
                    inventory.add(new Clothing(name, price, quantity, size));
                    break;
                case 3:
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    inventory.add(new Book(name, price, quantity, author));
                    break;
                default:
                    System.out.println("Invalid product type.");
            }
        }

        // Display the store inventory
        System.out.println("Store Inventory:");
        for (Product product : inventory) {
            product.display();
        }

        // Calculate and display total inventory value
        double totalValue = 0;
        for (Product product : inventory) {
            totalValue += product.calculateValue();
        }
        System.out.println("\nTotal Inventory Value: $" + totalValue);

        // Input for selling products
        System.out.println("\nEnter the product to sell:");
        System.out.print("Enter product name: ");
        String productName = sc.nextLine();
        System.out.print("Enter quantity to sell: ");
        int quantitySold = sc.nextInt();
        sc.nextLine(); // Consume newline

        boolean productFound = false;
        for (Product product : inventory) {
            if (product.searchByName(productName)) {
                productFound = true;
                product.sell(quantitySold);
                break;
            }
        }
        if (!productFound) {
            System.out.println("Product not found.");
        }
    }
}
// Display updated inventory
