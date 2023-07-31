import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class game {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // For Windows, use "cls" command to clear the screen
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Unix-like systems (Linux, macOS), use ANSI escape sequence to clear the
                // screen
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Number Memory Game ");
        int numberLength = 4;
        int score = 0;

        // Task 1

        int[] number = new int[numberLength];

        for (int i = 0; i < numberLength; i++) {
            number[i] = r.nextInt(10);
        }

        System.out.println("The Sequence is " + Arrays.toString(number));
        Thread.sleep(2000);
        clearScreen();

        System.out.println("Enter The Sequence ");
        for (int i = 0; i < numberLength; i++) {
            int userInput = sc.nextInt();

            if (userInput == number[i]) {
                System.out.println("Well Done");
                score++;
            } else {
                System.out.println("Sorry Wrong Answer ");
            }

        }

    }

}
