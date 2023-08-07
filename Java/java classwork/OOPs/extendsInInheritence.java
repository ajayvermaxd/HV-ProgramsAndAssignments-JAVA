package OOPs;

class parent {
    int num1;
    int num2;
    int num3;
    int num4;

    public parent(int n1, int n2, int n3, int n4) {
        this.num1 = n1;
        this.num2 = n2;
        this.num3 = n3;
        this.num4 = n4;

    }

}

class child extends parent {
    int num5;

    public child(int n1, int n2, int n3, int n4, int n5) {
        super(n1, n2, n3, n4);
        this.num5 = n5;

    }

}

public class extendsInInheritence {

    public static void main(String[] args) {
        parent obj1 = new parent(2, 4, 6, 8);
        parent obj2 = new parent(3, 5, 7, 9);

        child obj3 = new child(10, 20, 30, 40, 50);

        System.out.println(obj1.num3);
        System.out.println(obj2.num3);
        System.out.println(obj3.num3);

    }
}