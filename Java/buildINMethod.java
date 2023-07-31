import java.util.Arrays;

public class buildINMethod {
    public static void main(String[] args) {
        int[] numArray = { 2, 5, 8, 4, 9 };

        // ?? print array elements
        System.out.println(Arrays.toString(numArray));

        // to compare two array elemts-
        int[] numArrayTwo = { 2, 5, 8, 4, 9 };
        boolean areArrayEquals = Arrays.equals(numArray, numArrayTwo);
        System.out.println("If both the array are equal: " + areArrayEquals);

        // to sort the array elemts in accending order-
        Arrays.sort(numArray);
        System.out.println(Arrays.toString(numArray));

        int[] newArray = new int[20];
        // int[] newArray = {0,0,0};
        Arrays.fill(newArray, 6);
        System.out.println(Arrays.toString(newArray));

        // copy of array

        int[] newNum = Arrays.copyOf(numArray, 3);
        System.out.println(Arrays.toString(newNum));

    }
}
