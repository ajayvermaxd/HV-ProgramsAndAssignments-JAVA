import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class EmployeeFlow {

    public void manageEmployee(Scanner scanner) {
        System.out.println("Welcome to Employee Management");
        while (true) {
            System.out.println("1. View Orders\n2. Update Order Status\n3. Mark Order as Paid\n4. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    viewOrders();
                    break;
                case "2":
                    updateOrderStatus(scanner);
                    break;
                case "3":
                    markOrderAsPaid(scanner);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void viewOrders() {
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateOrderStatus(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter order ID to update:");
        String orderId = scanner.nextLine();
        System.out.println("Enter new status (preparing/delivered):");
        String newStatus = scanner.nextLine();

        try (FileWriter writer = new FileWriter("orders.csv", false)) {
            for (String line : lines) {
                if (line.startsWith(orderId)) {
                    String[] parts = line.split(",");
                    if (!"canceled".equals(parts[4]) && !"paid".equals(parts[4])) {
                        writer.write(parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4] + "," + parts[5] + "," + newStatus + "\n");
                    }
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void markOrderAsPaid(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter order ID to mark as paid:");
        String orderId = scanner.nextLine();

        try (FileWriter writer = new FileWriter("orders.csv", false)) {
            for (String line : lines) {
                if (line.startsWith(orderId)) {
                    String[] parts = line.split(",");
                    writer.write(parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4] + "," + parts[5] + "," + "paid" + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
