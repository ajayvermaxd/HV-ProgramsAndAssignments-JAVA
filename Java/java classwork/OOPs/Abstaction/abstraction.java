package OOPs.Abstaction;

abstract class shape {
    static String name;

    public shape(String name) {
        this.name = name;
    }

    abstract double calculateArea();

    abstract double calculateparimeter();

    void displayName() {
        System.out.println("Name :" + name);
    }
}

class circle extends shape {
    double radius;

    circle(double radius) {
        super("circle");
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * (radius * radius);
    }

    double calculateparimeter() {
        return Math.PI * (radius * radius * radius);
    }

}

class rectangle extends shape {
    int rectangleLenght;
    int rectangleWidth;

    rectangle(int rectangleLenght, int rectangleWidth) {
        super("rectangle");
        this.rectangleLenght = rectangleLenght;
        this.rectangleWidth = rectangleWidth;
    }

    double calculateparimeter() {
        return 2 * (rectangleLenght * rectangleWidth);
    }

    double calculateArea() {
        return rectangleLenght * rectangleWidth;
    }

}

class square extends shape {
    double side;

    square(double side) {
        super("square");
        this.side = side;

    }

    double calculateArea() {
        return side * side;
    }

    double calculateparimeter() {
        return 2 * (side * side);
    }
}

public class abstraction {
    public static void main(String[] args) {
        circle c1 = new circle(25);
        c1.displayName();
        System.out.println("Area of circle= " + c1.calculateArea());

    }
}