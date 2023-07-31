import java.util.Scanner;

public class arrayinJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Interger = ");
        int testveriable = sc.nextInt();
        System.out.println("You Entered: " + testveriable);

        // Collection of data type-
        // int[] studentID ={1,2,3,4,5};
        // int[] studentID = new int[5];
        // String[] studentName = new String[5];
        // double[] studentGPA = new double[5];

        int[] studentID = { 1, 2, 3, 4, 5 };
        String[] studentName = { "Ajay", "Vijay", "Jai", "Neeraj", "Sohail" };

        for (int i = 0; i < studentName.length; i++) {
            System.out.println(studentName[i]);
            System.out.println();
        }

        sc.close();

        studentName[1] = "Hello";
        for (int i = 0; i < studentName.length; i++) {
            System.out.println(studentName[i]);
        }

    }
}
