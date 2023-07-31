public class SampleArray {
    public static void main(String[] args) {
        String[] arr;
        arr = new String[5];
        arr[0] = "Ajay";
        arr[1] = "Vijay";
        arr[2] = "Jai";
        arr[3] = "Chintu";
        arr[4] = "Bulbul";
        System.out.println(arr[2]);
        int[] arr2 = { 100, 200, 300 };
        System.out.println(arr2[2]);

        System.out.println("");

        System.out.println("lenght of array is : " + arr.length);
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ":" + arr[i]);
        }
        // to print values of array only 
        System.out.println("");
        for (String i : arr) {
            System.out.println(i);

        }
    }
}