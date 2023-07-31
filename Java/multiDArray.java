public class multiDArray {
    public static void main(String[] args) {
        // 1 2 3 = int[] numArray = new int[3][3];
        // 4 5 6
        // 7 8 7
        // int[3][3]

        int[][] numArray = new int[3][2];
        numArray[0][0] = 1;
        numArray[0][1] = 2;
        // numArray[0][2] = 3;

        numArray[1][0] = 4;
        numArray[1][1] = 5;
        // numArray[1][2] = 6;

        numArray[2][0] = 7;
        numArray[2][1] = 8;
        // numArray[2][2] = 9;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(numArray[i][j] + " ");
            System.out.println();
        }
    }
}