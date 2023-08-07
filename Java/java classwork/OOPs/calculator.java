package OOPs;

class cal {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
}

class volume {
    public String shape = "cuboid";

    public int cuboid(int num1, int num2, int num3) {
        return num1 * num2 * num3;
    }

}

class area {
    public static final boolean Area = false;

    public static int Area(int side1, int side2) {
        return side1 * side2;
    }
}

public class calculator {
    public static void main(String[] args) {
        // Creating an object of the SimpleCalculator class
        cal cal1 = new cal();
        volume vol = new volume();
        area Area = new area();

        int resultAdd = cal1.add(5, 3);
        System.out.println("Addition result: " + resultAdd);

        int resultSubtract = cal1.subtract(10, 3);
        System.out.println("Subtraction result: " + resultSubtract);
        System.out.println("volumre of cuboid= " + vol.cuboid(12, 23, 23));
        System.out.println(vol.shape);

        int side1 = 20;
        int side2 = 20;
        int areaOfsquare = area.Area(side1, side2);
        System.out.println(areaOfsquare);
    }
}
