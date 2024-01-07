package GradedAssignmentonArraysandFileHandling;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LibraryCatalogAppFileHandling {
    private static final int MAX_BOOKS = 100;
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    private static String[][] catalog = new String[MAX_BOOKS][5];
    private static final String CSV_FILE_PATH = "./GradedAssignmentonArraysandFileHandling/catalog.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        loadCatalogFromCSV();

        System.out.println("-------------------------------------------------");
        System.out.println("Welcome to the Unique Library");
        System.out.println("-------------------------------------------------");

        String choice;
        do {
            displayMainMenu();
            System.out.print("Please choose an option from the above menu: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayAllBooks();
                    break;
                case "2":
                    issueBook(scanner);
                    break;
                case "3":
                    returnBook(scanner);
                    break;
                case "4":
                    saveCatalogToCSV();
                    System.out.println("Catalog data saved to " + CSV_FILE_PATH);
                    break;
                case "5":
                    loadCatalogFromCSV();
                    System.out.println("Catalog data loaded from " + CSV_FILE_PATH);
                    break;
                case "6":
                    System.out.println("Exiting the Application. Thank you for visiting SmartPoint!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.print("Enter 'Y' to return to the main menu or 'N' to exit: ");
            choice = scanner.nextLine();
            System.out.println("-------------------------------------------------");
            System.out.println();
        } while (choice.equalsIgnoreCase("Y"));

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("Menu System:");
        System.out.println("1. Display all books");
        System.out.println("2. Issue a book");
        System.out.println("3. Return a book");
        System.out.println("4. Save catalog data to CSV");
        System.out.println("5. Load catalog data from CSV");
        System.out.println("6. Exit");
    }

    private static void displayAllBooks() {
        System.out.println("-------------------------------------------------");
        System.out.println("List of all Books");
        System.out.println("-------------------------------------------------");
        // System.out.println("Book ID\t\tBook Title\t\tAuthor\t\tAvailability\tIssue Date");

        for (String[] book : catalog) {
            if (book != null && book[0] != null && book[1] != null && book[2] != null && book[3] != null) {
                System.out.printf("%-8s\t%-20s\t%-15s\t%-15s\t%s\n", book[0], book[1], book[2], book[3], book[4]);
            }
        }
    }

    private static void issueBook(Scanner scanner) {
        System.out.println("-------------------------------------------------");
        System.out.println("Issue a Book");
        System.out.println("-------------------------------------------------");

        System.out.print("Enter the Book ID: ");
        String bookID = scanner.nextLine();

        int bookIndex = findBookIndexByID(bookID);
        if (bookIndex == -1) {
            System.out.println("Book not found in the catalog.");
            return;
        }

        String[] book = catalog[bookIndex];
        if (book[3].equals("Available")) {
            System.out.println(book[0] + " - " + book[1] + " by " + book[2] + ": " + book[3]);
            System.out.print("Enter Student ID: ");
            String studentID = scanner.nextLine();

            System.out.print("Enter 'C' to confirm: ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("C")) {
                book[3] = studentID;
                book[4] = getCurrentDate();
                System.out.println("BookID: " + bookID + " is issued to " + studentID);
            } else {
                System.out.println("Book issue process cancelled.");
            }
        } else {
            System.out.println("Book is not available for issue.");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("-------------------------------------------------");
        System.out.println("Return a Book");
        System.out.println("-------------------------------------------------");

        System.out.print("Enter the Book ID: ");
        String bookID = scanner.nextLine();

        int bookIndex = findBookIndexByID(bookID);
        if (bookIndex == -1) {
            System.out.println("Book not found in the catalog.");
            return;
        }

        String[] book = catalog[bookIndex];
        if (book[3].equals("Available")) {
            System.out.println("Book is already available in the library.");
            return;
        }

        System.out.println(bookID + " - " + book[1]);
        System.out.println("Student ID - " + book[3]);
        System.out.println("Issue Date - " + book[4]);

        int daysDelayed = calculateDaysDelayed(book[4]);
        double charges = calculateCharges(daysDelayed);

        System.out.println("Delayed by " + daysDelayed + " days");
        System.out.printf("Delayed Charges - Rs. %.2f\n", charges);

        System.out.print("Enter 'R' to confirm the return: ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("R")) {
            book[3] = "Available";
            book[4] = "Null";
            System.out.println("BookID: " + bookID + " is returned back");
        } else {
            System.out.println("Book return process cancelled.");
        }
    }

    private static int findBookIndexByID(String bookID) {
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i][0].equals(bookID)) {
                return i;
            }
        }
        return -1;
    }

    private static String getCurrentDate() {
        Date date = new Date();
        return DATE_FORMAT.format(date);
    }

    private static int calculateDaysDelayed(String issueDate) {
        try {
            Date currentDate = new Date();
            Date dateOfIssue = DATE_FORMAT.parse(issueDate);

            long difference = currentDate.getTime() - dateOfIssue.getTime();
            int daysDelayed = (int) (difference / (24 * 60 * 60 * 1000));

            return Math.max(0, daysDelayed - 7); // Minimum of 0 days delayed (7 days is the allowed period)
        } catch (ParseException e) {
            System.out.println("Invalid date format. Returning 0 days delayed.");
        }
        return 0;
    }

    private static double calculateCharges(int daysDelayed) {
        final double CHARGE_PER_DAY = 10.0;
        return daysDelayed * CHARGE_PER_DAY;
    }

    private static void loadCatalogFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 5) {
                    catalog[row] = values;
                    row++;
                }
            }
            System.out.println(catalog.length);
        } catch (IOException e) {
            System.out.println("Error loading catalog data from CSV: " + e.getMessage());
        }
    }

    private static void saveCatalogToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (String[] book : catalog) {
                if (book != null && book[0] != null && book[1] != null && book[2] != null && book[3] != null) {
                    String line = String.join(",", book);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving catalog data to CSV: " + e.getMessage());
        }
    }
}