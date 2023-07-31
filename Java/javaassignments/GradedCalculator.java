import java.util.Scanner;

public class GradedCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter total marks
        System.out.print("Enter total marks: ");
        int totalMarks = scanner.nextInt();

        // Prompt the user to enter marks obtained
        System.out.print("Enter marks obtained: ");
        int marksObtained = scanner.nextInt();

        // Calculate the percentage
        double percentage = (marksObtained * 100.0) / totalMarks;

        // Calculate the GPA based on the percentage
        double gpa;
        String grade;

        if (percentage >= 90) {
            gpa = 4.0;
            grade = "A";
        } else if (percentage >= 80) {
            gpa = 3.0;
            grade = "B";
        } else if (percentage >= 70) {
            gpa = 2.0;
            grade = "C";
        } else if (percentage >= 60) {
            gpa = 1.0;
            grade = "D";
        } else {
            gpa = 0.0;
            grade = "F";
        }

        // Print the percentage, grade, and GPA
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade " + grade + ", GPA = " + gpa);

        // Close the scanner
        scanner.close();
    }
}
