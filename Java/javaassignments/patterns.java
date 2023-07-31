public class patterns {
    public static void main(String[] args) {
        int numRows = 5;

        // Print upper half of the pattern
        for (int i = numRows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Print lower half of the pattern
        for (int i = 2; i <= numRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
