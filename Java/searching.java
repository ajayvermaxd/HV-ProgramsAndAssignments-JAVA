import java.util.Arrays;

public class searching {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        int search = 500;
        boolean flag = false;

        // it will search for each array item //

        for (int i : arr) {
            if (i == search) {
                System.out.println("Yes, value present ");
                flag = true;
                break;
            }

        }
        if (flag == false) {
            System.out.println("No");
        }
        // second method by using binary search

        int[] numbers = { 140, 20, 350, 40, 50, 160, 070, 90, 80};
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, search);
        System.out.println(index);
    }
}

// Write a Java program to check if an array contains a specific element.
