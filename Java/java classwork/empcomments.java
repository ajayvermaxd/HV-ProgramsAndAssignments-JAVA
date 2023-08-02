import java.io.*;
import java.util.*;

public class empcomments {

    public static void main(String[] args) {
        String fileName = "employees.csv";

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
                case 3:
                    findEmployeeWithHighestSalary(fileName);
                    break;
                case 4:
                    findEmployeeWithLowestSalary(fileName);
                    break;
                case 5:
                    findYoungestEmployee(fileName);
                    break;
                case 6:
                    findOldestEmployee(fileName);
                    break;
                // case 7:
                // findEmployeesWithinAgeRange(fileName, scanner);
                // break;
                case 8:
                    calculateTotalSalary(fileName);
                    break;
                case 9:
                    calculateAverageAge(fileName);
                    break;
                case 10:
                    calculateAverageSalary(fileName);
                    break;
                case 11:
                    findEmployeesAboveSalaryThreshold(fileName, scanner);
                    break;
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

            System.out.println("==========Employee Details==========");
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] employeeData = line.split(",");
                String name = employeeData[0].trim();
                int age = Integer.parseInt(employeeData[1].trim());
                double salary = Double.parseDouble(employeeData[2].trim());

                System.out.println("Name: " + name + "\t" + " Age: " + age + "\t" + " Salary: " + salary);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void calculateTotalSalary(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            double totalSalary = 0;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] employeeData = line.split(",");
                double salary = Double.parseDouble(employeeData[2].trim());
                totalSalary = totalSalary + salary;
            }
            System.out.println("Total Salary of all employees: " + totalSalary);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void calculateAverageAge(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            int totalAge = 0;
            int count = 0;
            double avgAge = 0;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] employeeData = line.split(",");
                int age = Integer.parseInt(employeeData[1].trim());
                totalAge = totalAge + age;
                count++;
            }
            avgAge = totalAge / count;
            System.out.println("Average age of all employees: " + avgAge);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void calculateAverageSalary(String fileName) {
        System.out.println("\n=== Calculate Average Salary of Employees ===");
        try {
            // Open the CSV file for reading
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Read the header line (and skip it) as we don't need it for the calculation
            reader.readLine();

            int totalEmployees = 0;
            double totalSalary = 0.0;

            // Read each employee's details and calculate total salary and count of
            // employees
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                if (employeeData.length >= 3) {
                    double salary = Double.parseDouble(employeeData[2]);
                    totalSalary += salary;
                    totalEmployees++;
                }
            }
            // Close the reader
            reader.close();

            if (totalEmployees == 0) {
                System.out.println("No employees found in the database.");
            } else {
                double averageSalary = totalSalary / totalEmployees;
                System.out.printf("Average Salary of Employees: $%.2f%n", averageSalary);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing salary data: " + e.getMessage());
        }
    }

    // Method to find employees above a specific salary threshold
    private static void findEmployeesAboveSalaryThreshold(String fileName, Scanner scanner) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(reader);

            System.out.print("Enter salary threshold: ");
            double threshold = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            boolean found = false;
            bufferReader.readLine();
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] employeeData = line.split(",");
                double salary = Double.parseDouble(employeeData[2].trim());
                if (salary > threshold) {
                    String name = employeeData[0];
                    int age = Integer.parseInt(employeeData[1]);
                    System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
                    found = true;
                }
            }
            bufferReader.close();
            if (!found) {
                System.out.println("No employees found above the salary threshold.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Failed to find employees above salary threshold.");
        }
    }

    public static void findEmployeeWithHighestSalary(String filename) {
        try {

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            double maxSalary = Double.MIN_VALUE;
            List<String> maxSalaryData = new ArrayList<>();

            // boolean found = false;
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(",");
                double salary = Double.parseDouble(employeeData[2].trim());

                if (salary > maxSalary) {
                    maxSalary = salary;
                    maxSalaryData.clear();
                    maxSalaryData.add(line);
                } else if (salary == maxSalary) {
                    maxSalaryData.add(line);
                }
            }
            br.close();
            for (String i : maxSalaryData) {
                String[] empData = i.split(",");
                String name = empData[0];
                System.out.println("Highest Salary is of " + name);
            }
        } catch (Exception e) {
            // handle exception
        }
    }

    public static void findEmployeeWithLowestSalary(String filename) {
        try {

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            double minSalary = Double.MAX_VALUE;
            List<String> minSalaryData = new ArrayList<>();

            // boolean found = false;
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(",");
                double salary = Double.parseDouble(employeeData[2].trim());

                if (salary < minSalary) {
                    minSalary = salary;
                    minSalaryData.clear();
                    minSalaryData.add(line);
                } else if (salary == minSalary) {
                    minSalaryData.add(line);
                }
            }
            br.close();
            for (String i : minSalaryData) {
                String[] empData = i.split(",");
                String name = empData[0];
                System.out.println("Lowest salary is of: " + name);
            }
        } catch (Exception e) {
            // handle exception
        }
    }

    public static void findYoungestEmployee(String filename) {
        try {

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            int minAge = Integer.MAX_VALUE;
            List<String> minAgeData = new ArrayList<>();

            // boolean found = false;
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(",");
                int age = Integer.parseInt(employeeData[1].trim());

                if (age < minAge) {
                    minAge = age;
                    minAgeData.clear();
                    minAgeData.add(line);
                } else if (age == minAge) {
                    minAgeData.add(line);
                }
            }
            br.close();
            for (String i : minAgeData) {
                String[] empData = i.split(",");
                String name = empData[0];
                System.out.println("Youngest Employee is: " + name);
            }
        } catch (Exception e) {
            // handle exception
        }
    }

    public static void findOldestEmployee(String filename) {
        try {

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            int maxAge = Integer.MIN_VALUE;
            List<String> maxAgeData = new ArrayList<>();

            // boolean found = false;
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(",");
                int age = Integer.parseInt(employeeData[1].trim());

                if (age > maxAge) {
                    maxAge = age;
                    maxAgeData.clear();
                    maxAgeData.add(line);
                } else if (age == maxAge) {
                    maxAgeData.add(line);
                }
            }
            br.close();
            for (String i : maxAgeData) {
                String[] empData = i.split(",");
                String name = empData[0];
                System.out.println("Oldest Employee is: " + name);
            }
        } catch (Exception e) {
            // handle exception
        }
    }
}
