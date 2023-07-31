import java.util.ArrayList;
import java.util.Collections;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("Hero");
        name.add("Virad");
        name.add("Python");
        name.add("Java");
        System.out.println(name);
        name.remove(0);
        System.out.println(name);
        name.set(0 ,"Class");
        System.out.println(name);

        Collections.reverse(name);
        System.out.println(name);

        Collections.shuffle(name);
        System.out.println(name);

    }
    
}
