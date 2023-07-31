import java.io.BufferedReader;
import java.io.FileReader;

public class csvRead {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("details.csv"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                // if you want to display names only
                // String[] data = line.split(",");
                // String n = data[0];
                // System.out.println(n);

                // if you want to add age

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}