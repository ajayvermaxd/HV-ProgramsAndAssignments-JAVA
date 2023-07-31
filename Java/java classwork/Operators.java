
public class Operators {
    public static void main(String[] args) {
        int NumOne = 60;
        int NumTwo = 15;

        int result = 0;
        result = NumOne - NumTwo;
        System.out.println("Difference bitween " + NumOne + "and" + NumTwo + "=" +
                result);

        result = NumOne + NumTwo;
        System.out.println("Addition bitween " + NumOne + "and" + NumTwo + "=" +
                result);

        result = NumOne / NumTwo;
        System.out.println("Division bitween " + NumOne + "and" + NumTwo + "=" +
                result);

        result = NumOne * NumTwo;
        System.out.println("Multiplication bitween " + NumOne + "and" + NumTwo + "="
                + result);

        result = NumOne % NumTwo;
        System.out.println("Modulas bitween " + NumOne + "and" + NumTwo + "=" +
                result);

        System.out.println("Original value of numberOne: " + NumOne);

        /*
         * NumOne++;
         * System.out.println("After ++ operator  " + NumOne);
         * 
         * ++NumOne;
         * System.out.println("After using ++NUmOne " + NumOne);
         * 
         * NumOne--;
         * System.out.println("After using NumOne-- " + NumOne);
         * 
         * --NumOne;
         * System.out.println("After using --NumOne " + NumOne);
         */
    }
}