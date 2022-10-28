
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Main
 */
public class Test {
    public static void main(String[] args) {

        try {
            List<String> classArr = IOScript.readFile(args[0]);
            List<Class<?>> cArr = new ArrayList<>();
            for (String string : classArr) {
                //*Pare th class */ 
                Class<?> c = ReflectionScript.reflectionType(string);

                //*ex 1a: pare ta declared fields */ 
                Field[] declFields = ReflectionScript.declaredFields(c);
                Field[] allFields = ReflectionScript.allFields(c);

                System.out.println(string);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

}
