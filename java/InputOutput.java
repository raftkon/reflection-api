import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * InputOutput
 */
public class InputOutput {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(args[0]); // Anoigei arxeio
            BufferedReader br = new BufferedReader(fr); // Diavazei arxeio
            List<String> strArr = new ArrayList<>();
            String str = br.readLine();

            while (str != null) {
                System.out.println(str);
                strArr.add(str);
                str = br.readLine();
            }
            br.close();

            // FileWriter writer = new FileWriter(args[1]);
            // for (String string : strArr) {
            // writer.write(string);
            // writer.write("\n");
            // }
            // writer.close();

        } catch (Exception e) {
            System.out.println("PROBLEM sou leo: " + e);
        }
    }

}