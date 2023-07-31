import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        boolean isPrime = isPrimeNumber(num);

        if (isPrime) {
            System.out.println("The given number " + num + " is a Prime number");
        } else {
            System.out.println("The given number " + num + " is NOT a Prime number");
        }

        scanner.close();
    }

    public static boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
