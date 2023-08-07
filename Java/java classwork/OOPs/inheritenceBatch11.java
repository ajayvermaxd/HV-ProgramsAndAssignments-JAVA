package OOPs;
class shape {
    public int numberofSides = 4;

    public void display() {
        System.out.println("this is a shape class");
    }
}

class circle22 extends shape {
    int numberofSides = 5;

    public void display() {
        System.out.println("this is a circle class");
        System.out.println("Number of sides of parent  " + super.numberofSides);
    }

    public void details() {
        // super.display();
        display();
        System.out.println("details have been printed::");
    }
}

public class inheritenceBatch11 {
    public static void main(String[] args) {
        circle22 c1 = new circle22();

        // cannot access child methods
        // shape shape1=new shape();
        // shape1.displayChild();

        // c1.displayparent();
        // c1.display();
        c1.details();
        System.out.println("child value =" + c1.numberofSides);

    }
}