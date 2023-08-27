package OOPs;

class Kdata {
    // int temp;

    public int add(int x, int y) {
        return x + y;
        // System.out.println(temp);
        // return temp;

    }

}

public class calc {
    public static void main(String[] args) {
        Kdata obj = new Kdata();
        int a = 10;
        int b = 20;
        // obj.add(a, b);
        // System.out.println(obj.temp);

        int result;
        result = obj.add(a, b); // input- output method
        System.out.println(result); // 30
        System.out.println(obj.add(30, 20)); // 50
        // System.out.println(obj.temp); // 50

    }

}