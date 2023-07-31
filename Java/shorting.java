public class shorting {
    public static void main(String[] args) {

        int[] numArray = { 3, 5, 1, 4, 2 };

        // num1 = 3 and num2 = 1
        // if(num1 > num2) = num1 = 1 num 2 = 3 - Ascending
        // if(num1 < num2) = num1 = 5 num 2 = 3 - descending

        System.out.println("Array elements befor sorting");

        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] + " ");
        }

        for (int i = 0; i < numArray.length; i++) {
            for (int j = i; j < numArray.length; j++) {
                if (numArray[i] > numArray[j]) {
                    int tmp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = tmp;
                }
            }
            // System.out.println();
        }

        System.out.println("\nArray elements after sorting");

        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] + " ");
        }
    }
}