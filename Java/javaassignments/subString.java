import java.util.Scanner;

public class subString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String stringName = scanner.nextLine();

        System.out.print("Enter the starting index: ");
        int startingIndex = scanner.nextInt();

        System.out.print("Enter the ending index: ");
        int endingIndex = scanner.nextInt();

        String substring = stringName.substring(startingIndex, endingIndex + 1);

        System.out.println(
                "Substring of " + stringName + " from " + startingIndex + " to " + endingIndex + " is: " + substring);

        scanner.close();
    }
}
