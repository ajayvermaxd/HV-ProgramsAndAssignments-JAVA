import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the values of a and b
        System.out.print("Enter the value of numA: ");
        int numA = scanner.nextInt();

        System.out.print("Enter the value of numB: ");
        int numB = scanner.nextInt();

        // Swap the values of numA and numB using a temporary variable
        int temp = numA;
        numA = numB;
        numB = temp;

        // Print the swapped values
        System.out.println("Swapped values:");
        System.out.println("numA = " + numA);
        System.out.println("numB = " + numB);

        // Close the scanner
        scanner.close();
    }
}
