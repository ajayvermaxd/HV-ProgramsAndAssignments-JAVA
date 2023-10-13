import java.io.*;
import java.util.*;

public class MenuManager {
    private static final String MENU_CSV_FILE = "menu.csv";
    private static final Map<String, MenuItem> menuItems = new HashMap<>();

    public static void manageMenu(Scanner scanner) {
        loadMenu();
        while (true) {
            System.out.println("1. List Menu\n2. Add Item\n3. Update Item\n4. Remove Item\n5. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    listMenu();
                    break;
                case "2":
                    addMenuItem(scanner);
                    break;
                case "3":
                    updateMenuItem(scanner);
                    break;
                case "4":
                    removeMenuItem(scanner);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void loadMenu() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MENU_CSV_FILE))) {
            String line;
            // reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double price = Double.parseDouble(data[1]);
                String category = data[2];

                MenuItem menuItem = new MenuItem(name, price, category);
                menuItems.put(name, menuItem);
            }
        } catch (IOException e) {
            System.out.println("Error loading menu: " + e.getMessage());
        }
    }

    public static void saveMenu() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(MENU_CSV_FILE))) {
            for (MenuItem menuItem : menuItems.values()) {
                writer.println(menuItem.getName() + "," + menuItem.getPrice() + "," + menuItem.getCategory());
            }
        } catch (IOException e) {
            System.out.println("Error saving menu: " + e.getMessage());
        }
    }

    public static void listMenu() {
        if (menuItems.isEmpty()) {
            System.out.println("No menu items available!");
            return;
        }

        System.out.println("Menu:");
        for (MenuItem menuItem : menuItems.values()) {
            System.out.println("- Name: " + menuItem.getName() + ", Price: " + menuItem.getPrice() + ", Category: " + menuItem.getCategory());
        }
    }

    public static void addMenuItem(Scanner scanner) {
        System.out.print("Enter menu item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter menu item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // clear the newline
        System.out.print("Enter menu item category: ");
        String category = scanner.nextLine();

        if (menuItems.containsKey(name)) {
            System.out.println("Menu item already exists!");
            return;
        }

        MenuItem menuItem = new MenuItem(name, price, category);
        menuItems.put(name, menuItem);
        saveMenu(); // Save menu to CSV
        System.out.println("Menu item added successfully!");
    }

    public static void updateMenuItem(Scanner scanner) {
        System.out.print("Enter menu item name to update: ");
        String name = scanner.nextLine();
        MenuItem menuItem = menuItems.get(name);

        if (menuItem == null) {
            System.out.println("Menu item not found!");
            return;
        }

        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // clear the newline

        menuItem.setPrice(price);
        saveMenu(); // Save menu to CSV
        System.out.println("Menu item updated successfully!");
    }

    public static void removeMenuItem(Scanner scanner) {
        System.out.print("Enter menu item name to remove: ");
        String name = scanner.nextLine();

        if (menuItems.remove(name) != null) {
            saveMenu(); // Save menu to CSV
            System.out.println("Menu item removed successfully!");
        } else {
            System.out.println("Menu item not found!");
        }
    }

    public static double getItemPrice(String itemId) {
        MenuItem menuItem = menuItems.get(itemId);
        return menuItem != null ? menuItem.getPrice() : 0;
    }
}
