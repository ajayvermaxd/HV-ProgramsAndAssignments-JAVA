import java.io.*;
import java.util.*;

public class empcomments {
    public static String fileName = "employeesDetails.csv";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add new employee");
            System.out.println("2. Display all employees");
            System.out.println("3. Find employee with highest salary");
            System.out.println("4. Find employee with lowest salary");
            System.out.println("5. Find youngest employee");
            System.out.println("6. Find oldest employee");
            System.out.println("7. Find employees within age range");
            System.out.println("8. Calculate total salary of all employees");
            System.out.println("9. Calculate average age of employees");
            System.out.println("10. Calculate average salary of employees");
            System.out.println("11. Find employees above salary threshold");
            System.out.println("12. Update employee age");
            System.out.println("13. Update employee name");
            System.out.println("14. Remove employee by name");
            System.out.println("15. Remove employee by index");
            System.out.println("16. Sort employees by age");
            System.out.println("17. Sort employees by salary");
            System.out.println("18. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addNewEmployee(fileName, scanner);
                    break;
                case 2:
                    displayAllEmployees(fileName);
                    break;
                // case 3:
                // findEmployeeWithHighestSalary(fileName);
                // break;
                // case 4:
                // findEmployeeWithLowestSalary(fileName);
                // break;
                // case 5:
                // findYoungestEmployee(fileName);
                // break;
                // case 6:
                // findOldestEmployee(fileName);
                // break;
                // case 7:
                // findEmployeesWithinAgeRange(fileName, scanner);
                // break;
                case 8:
                    calculateTotalSalary(fileName);
                    break;
                case 9:
                    calculateAverageAge(fileName);
                    break;
                // case 10:
                // calculateAverageSalary(fileName);
                // break;
                // case 11:
                // findEmployeesAboveSalaryThreshold(fileName, scanner);
                // break;
                // case 12:
                // updateEmployeeAge(fileName, scanner);
                // break;
                // case 13:
                // updateEmployeeName(fileName, scanner);
                // break;
                // case 14:
                // removeEmployeeByName(fileName, scanner);
                // break;
                // case 15:
                // removeEmployeeByIndex(fileName, scanner);
                // break;
                // case 16:
                // sortEmployeesByAge(fileName);
                // break;
                // case 17:
                // sortEmployeesBySalary(fileName);
                // break;
                case 18:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    public static void addNewEmployee(String fileName, Scanner scanner) {
        System.out.println("Enter the name of the employee: ");
        String employeeName = scanner.nextLine();
        System.out.println("Enter the Age of the employee: ");
        int employeeAge = scanner.nextInt();
        System.out.println("Enter the Salary of the employee: ");
        int employeeSalary = scanner.nextInt();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            File f = new File(fileName);
            if (f.length() == 0) {
                bw.write("Name,Age,Salary");
                bw.newLine();
            }
            bw.write(employeeName + "," + employeeAge + "," + employeeSalary);
            bw.newLine();
            bw.close();
            System.out.println("Employee details updated");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void displayAllEmployees(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] employeeData = line.split(",");
                String name = employeeData[0].trim();
                int age = Integer.parseInt(employeeData[1].trim());
                double salary = Double.parseDouble(employeeData[2].trim());

                System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void calculateTotalSalary(String fileName) {
        String line;

        try {
            int Totalsalary = 0;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                int sal = Integer.parseInt(data[2]);
                Totalsalary = Totalsalary + sal;

            }
            System.out.println("Total salary : " + Totalsalary);

        } catch (Exception e) {

        }
    }

    public static void calculateAverageAge(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            double avg;
            int count = 0;
            int totalAge = 0;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] employeeData = line.split(",");
                int age = Integer.parseInt(employeeData[1].trim());
                totalAge += age;
                count++;

            }
            avg = totalAge / count;

            System.out.println("Average Age of the employees is : " + avg);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
        }

    }

}
