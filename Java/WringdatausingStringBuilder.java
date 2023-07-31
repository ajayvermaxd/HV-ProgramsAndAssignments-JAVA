import java.io.FileWriter;

public class WringdatausingStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hi, My name is Ajay").append(System.lineSeparator());
        sb.append("I am a coder").append(System.lineSeparator());
        try {
            FileWriter file = new FileWriter("stringbiulderdata.csv");
            file.write(sb.toString());
            file.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
