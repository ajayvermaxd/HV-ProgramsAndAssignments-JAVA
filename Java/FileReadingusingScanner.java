import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingusingScanner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("sample.txt"))) {
            while (sc.hasNextLine()) {
                String Line = sc.nextLine();
                System.out.println(Line);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}