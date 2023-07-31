//student Data of a class 8 - student number = 50;
// student ID
// student Name
// sub -Total number earned

// studentID[50] = {1,2,3};
// studentName[50] = {"Vivian","Rishi","Jyothi"};
// studentMarks[50] = {47,48,46};

// ID - Name - Marks
// 1,Vivian, 47 - 0
// 2,Rishi, 48 - 1
// 3,Jyothi, 46  - 2

// studentID[1] = 2
// studentName[1] = Rishi
// studentMarks[1] = 48

import java.util.Scanner;

public class studentDatabase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentID[] = { 1, 2, 3, 4, 5 };
        String studentName[] = { "Vivian", "Rishi", "Jyothi", "Harsh", "Ayush" };
        int studentMarks[] = { 47, 48, 46, 49, 50 };

        int length = studentID.length;
        // for(int i = 0; i<length; i++){
        // System.out.println(studentID[i] + ": " + studentName[i] + "\t: " +
        // studentMarks[i]);
        // }

        // menu - 1. List of all the students
        // 2. Student name with highest marks
        // 3. Student name with least marks
        // 4. Exit

        char choice = 'Y';
        do {
            System.out.println(
                    "1. List of all the students\n2. Student name with highest marks\n3. Student name with least marks\n4. Exit");

            System.out.print("Enter the Menu: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    for (int i = 0; i < length; i++) {
                        System.out.println(studentID[i] + ": " + studentName[i] + "\t: " +
                                studentMarks[i]);
                    }
                    break;

                case 2:
                    System.out.println("Highest marks");
                    break;

                case 3:
                    System.out.println("Least marks");
                    break;

                case 4:
                    System.out.println("Thank you!");
                    choice = 'n';
                    break;

                default:
                    System.out.println("Please enter valid menu number");
                    break;
            }

            System.out.print("Do you want to continue: ");
            choice = sc.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');

    }
}
