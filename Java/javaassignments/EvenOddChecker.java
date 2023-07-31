import java.util.Scanner;

public class EvenOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Menu based app - Even/Odd Checker");
            System.out.print("Please enter the number: ");
            int number = scanner.nextInt();

            if (number % 2 == 0) {
                System.out.println("The given number - " + number + " is an EVEN Number");
            } else {
                System.out.println("The given number - " + number + " is an ODD Number");
            }

            System.out.print("Do you want to Continue (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }
}
