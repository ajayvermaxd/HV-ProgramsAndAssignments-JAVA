package GradedAssignmentOnFileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class empDataGenerator {

    private static ArrayList<Employee> employees = new ArrayList<>();
    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Employee Data Generator ----");
            System.out.println("1. Generate Employee Data");
            System.out.println("2. Write Data to CSV");
            System.out.println("3. Verify Data from CSV");
            System.out.println("4. Clear Data");
            System.out.println("5. Exit");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        generateEmployeeData();
                        break;
                    case 2:
                        writeDataToCSV();
                        break;
                    case 3:
                        verifyDataFromCSV();
                        break;
                    case 4:
                        clearData();
                        break;
                    case 5:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    public static void generateEmployeeData() {
        employees.clear();
        employees.add(new Employee(101, "Vishal", "Sales", 50000));
        employees.add(new Employee(102, "Ajay", "Marketing", 55000));
        employees.add(new Employee(103, "Vaibhav", "Engineering", 70000));
        employees.add(new Employee(104, "Minakshee", "HR", 48000));
        employees.add(new Employee(105, "Gagan", "Finance", 65000));

        System.out.println("Employee data generated successfully!");
    }

    public static void writeDataToCSV() {
        if (employees.isEmpty()) {
            System.out.println("Employee data is empty. Please generate employee data first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        try {

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid file name.");
        }
    }

    public static void verifyDataFromCSV() {
        Scanner scanner = new Scanner(System.in);

        try {

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid file name.");
        }
    }

    public static void clearData() {
        employees.clear();
        System.out.println("Employee data cleared successfully!");
    }
}

// it is not completed. Submitting it because of timeline issue.