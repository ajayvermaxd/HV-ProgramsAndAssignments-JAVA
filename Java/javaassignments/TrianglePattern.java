public class TrianglePattern {
    public static void main(String[] args) {
        int numRows = 3;

        // Print upper half of the triangle
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Print lower half of the triangle
        for (int i = numRows - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
