package GradedAssignmentonFileHandling;

import java.io.*;
import java.util.*;

class Personnel {
    private int id;
    private String name;
    private String dept;
    private double salary;

    public Personnel(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Dept: " + dept +
                ", Salary: " + salary;
    }
}

public class empDataGenerator {
    public static void main(String[] args) {
        List<Personnel> staffList = new ArrayList<>();
        String outputFile = "output.csv";

        try (Scanner userInput = new Scanner(System.in)) {
            int selectedOption;

            do {
                showOptions();
                System.out.print("Please select an option: ");
                selectedOption = userInput.nextInt();

                switch (selectedOption) {
                    case 1:
                        staffList = createPersonnelData();
                        break;
                    case 2:
                        Collections.sort(staffList, Comparator.comparingDouble(Personnel::getSalary));
                        storeDataToFile(staffList, outputFile, userInput);
                        System.out.println("Employee data has been successfully stored in 'EmployeeData.csv'.");
                        break;
                    case 3:
                        confirmFileContents(outputFile);
                        break;
                    case 4:
                        System.out.println("Thank you for using the Employee Management App. Goodbye!");
                        break;
                    default:
                        System.out.println("The option you selected is not valid. Please try again.");
                }
            } while (selectedOption != 4);
        } catch (IOException e) {
            System.err.println("An error occurred while handling file operations: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Oops! Something unexpected occurred: " + e.getMessage());
        }
    }

    public static List<Personnel> createPersonnelData() {
        List<Personnel> staffList = new ArrayList<>();
        staffList.add(new Personnel(101, "Neeraj", "HR", 50000.0));
        staffList.add(new Personnel(102, "Ajay", "Finance", 60000.0));
        staffList.add(new Personnel(103, "Sohail", "IT", 55000.0));
        staffList.add(new Personnel(104, "Sunita", "Marketing", 52000.0));
        staffList.add(new Personnel(105, "Minakshee", "Operations", 48000.0));
        return staffList;
    }

    public static void storeDataToFile(List<Personnel> staffList, String filePath, Scanner userInput)
            throws IOException {
        File outputFile = new File(filePath);
        if (outputFile.exists()) {
            System.out.print("'EmployeeData.csv' already exists. Do you want to overwrite it? (yes/no): ");
            String response = userInput.next().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Operation cancelled. The existing file was not overwritten.");
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Employee ID,Employee Name,Department,Salary");
            writer.newLine();

            for (Personnel employee : staffList) {
                writer.write(employee.getId() + ","
                        + employee.getName() + ","
                        + employee.getDept() + ","
                        + employee.getSalary());
                writer.newLine();
            }
        }
    }

    public static void confirmFileContents(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nReading the contents of 'EmployeeData.csv':");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void showOptions() {
        System.out.println("\nOptions:");
        System.out.println("1. Create new personnel data");
        System.out.println("2. Store data in file (and sort)");
        System.out.println("3. Read data from file");
        System.out.println("4. Exit the application");
    }
}