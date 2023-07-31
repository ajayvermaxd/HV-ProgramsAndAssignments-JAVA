import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {

    private String name;
    private double gpa;

    Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    public class StudentDataSorting {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Student> studentList = new ArrayList<>();

            System.out.print("Enter the number of students: ");
            int numStudents = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 1; i <= numStudents; i++) {
                System.out.print("Enter the name of student " + i + ": ");
                String name = scanner.nextLine();

                System.out.print("Enter the GPA of student " + i + ": ");
                double gpa = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                studentList.add(new Student(name, gpa));
            }

            System.out.println("\nOriginal Student List:");
            printStudentList(studentList);

            System.out.print("\nEnter 'asc' for ascending order or 'desc' for descending order: ");
            String sortOrder = scanner.nextLine().toLowerCase();

            sortStudentList(studentList, sortOrder);
            System.out.println("\nSorted Student List:");
            printStudentList(studentList);
        }

        private static void printStudentList(List<Student> studentList) {
            for (Student student : studentList) {
                System.out.println("Name: " + student.getName() + ", GPA: " + student.getGPA());
            }
        }

        private static void sortStudentList(List<Student> studentList, String sortOrder) {
            if (sortOrder.equals("asc")) {
                Collections.sort(studentList, Comparator.comparingDouble(Student::getGPA));
            } else if (sortOrder.equals("desc")) {
                Collections.sort(studentList, Comparator.comparingDouble(Student::getGPA).reversed());
            } else {
                System.out.println("Invalid sort order specified. Defaulting to ascending order.");
                Collections.sort(studentList, Comparator.comparingDouble(Student::getGPA));
            }
        }
    }
}