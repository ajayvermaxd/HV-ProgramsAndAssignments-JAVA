import java.util.Scanner;

public class MenuDriven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Menu based app - Unit conversion for Distance");
            System.out.println("1. CM to M");
            System.out.println("2. M to KM");
            System.out.println("3. KM to M");
            System.out.println("4. M to CM");

            System.out.print("Enter your menu: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    cmToM();
                    break;
                case 2:
                    mToKm();
                    break;
                case 3:
                    kmToM();
                    break;
                case 4:
                    mToCm();
                    break;
                default:
                    System.out.println("Invalid menu option");
            }

            System.out.print("Do you want to Continue (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }

    public static void cmToM() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the CM Value: ");
        double cm = scanner.nextDouble();
        double meters = cm / 100.0;
        System.out.printf("%.2f CM = %.2f M%n", cm, meters);
    }

    public static void mToKm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the M Value: ");
        double m = scanner.nextDouble();
        double km = m / 1000.0;
        System.out.printf("%.2f M = %.2f KM%n", m, km);
    }

    public static void kmToM() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the KM Value: ");
        double km = scanner.nextDouble();
        double m = km * 1000.0;
        System.out.printf("%.2f KM = %.2f M%n", km, m);
    }

    public static void mToCm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the M Value: ");
        double m = scanner.nextDouble();
        double cm = m * 100.0;
        System.out.printf("%.2f M = %.2f CM%n", m, cm);
    }
}
