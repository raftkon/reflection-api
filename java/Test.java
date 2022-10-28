import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        try {
            // Pithani sunartisi-> mapStringToClass(string arr): class arr
            List<String> strArray = IOScript.readFile(args[0]);
            System.out.println(strArray);
            List<Class<?>> classArray = new ArrayList<>();

            for (String string : strArray) {
                classArray.add(ReflectionScript.getReflectionType(string));
            }
            // ----------------
            System.out.println(classArray);

            // ? Exercise 1a
            // findDeclaredFieldsLength(class arr): int arr
            List<Integer> fieldsLengthArr = new ArrayList<>();
            for (Class<?> c : classArray) {
                Field[] fields = c.getDeclaredFields();
                fieldsLengthArr.add(fields.length);
                System.out.println(c.getName() + " has " + fields.length + " fields.");
            }
            System.out.println(fieldsLengthArr);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}