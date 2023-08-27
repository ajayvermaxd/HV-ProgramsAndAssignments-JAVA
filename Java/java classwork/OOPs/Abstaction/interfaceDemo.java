package OOPs.Abstaction;

interface shape {
    double calculateArea();

    double calculateVolume();

    String getName();

    void display();
}

class circle implements shape {
    double radius;
    private String name = "Circle";

    circle(double radius) {

        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * (radius * radius);
    }

    public double calculateVolume() {
        return Math.PI * (radius * radius * radius);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Name : " + name); 
    }

}

public class interfaceDemo {
    public static void main(String[] args) {
        circle c1 = new circle(25);
        // c1.displayName();
        System.out.println("Area of circle= " + c1.calculateArea());

    }
}