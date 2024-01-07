package GradedAssignmentonArraysandFileHandling;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LibraryCatalogApp {
    private static final int MAX_BOOKS = 4;
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    private static String[][] catalog = new String[MAX_BOOKS][5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeCatalog();

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

    private static void initializeCatalog() {
        catalog[0] = new String[]{"101", "HTML and CSS", "Jon Duckett", "Available", "Null"};
        catalog[1] = new String[]{"102", "JavaScript: The Good Parts", "Douglas C", "Available", "Null"};
        catalog[2] = new String[]{"103", "Learning Web Design", "Jennifer N", "CP2014", "23-May-2023"};
        catalog[3] = new String[]{"104", "Responsive Web Design", "Ben Frain", "EC3142", "17-May-2023"};
        System.out.println(catalog.length);
    }

    private static void displayMainMenu() {
        System.out.println("View the complete list of Books");
        System.out.println("Issue a Book");
        System.out.println("Return a Book");
        System.out.println("Exit");
    }

    private static void displayAllBooks() {
        System.out.println("-------------------------------------------------");
        System.out.println("List of all Books");
        System.out.println("-------------------------------------------------");
        System.out.println("Book ID   Book Title                    Author         Availability     Issue Date");
        System.out.println("-------------------------------------------------------------------------------");

        for (String[] book : catalog) {
            System.out.printf("%-10s%-30s%-15s%-17s%s\n", book[0], book[1], book[2], book[3], book[4]);
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

        if (!book[3].equals("Available")) {
            System.out.println("Book is currently not available.");
            return;
        }

        System.out.printf("%s - %s by %s: %s\n", book[0], book[1], book[2], book[3]);

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter 'C' to confirm: ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("C")) {
            book[3] = studentID;
            book[4] = getCurrentDate();
            System.out.printf("BookID: %s is issued to %s\n", book[0], studentID);
        } else {
            System.out.println("Book issue process cancelled.");
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
        System.out.println("StudentID - " + book[3]);
        System.out.println("Issue Date - " + book[4]);

        int daysDelayed = calculateDaysDelayed(book[4]);
        double charges = calculateCharges(daysDelayed);

        System.out.println("Delayed by - " + daysDelayed + " days");
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
}