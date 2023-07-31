import java.util.Scanner;

public class arrayinput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studentID = new int[3];
        int[] studentName = new int[3];
        int[] studentMarks = new int[3];
        int index = 0;
        while (index < studentMarks.length) {
            System.out.print("Enter Student ID" + index + ":");
            System.out.print("Enter Student Name" + index + ":");
            System.out.print("Enter Student Marks" + index + ":");
            studentMarks[index] = sc.nextInt();
            studentID[index] = sc.nextInt();
            studentName[index] = sc.nextInt();
            index++;
        }

        System.out.print("");

        sc.close();

    }

}
