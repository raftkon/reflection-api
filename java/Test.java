import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            // ? ----------------------------------------
            Map<String, List<String>> mapFields = new HashMap<>();
            for (Class<?> c : classArray) {
                mapFields.put(c.getName(), new ArrayList<String>());
                Field[] declFields = c.getDeclaredFields();
                for (Field field : declFields) {
                    mapFields.get(c.getName()).add(field.getName());

                }
            }
            // ------------------------------------------------- //

            // ? Exercise 1b
            List<Integer> allFieldsLength = new ArrayList<>();
            for (Class<?> c : classArray) {
                System.out.println("1st for");
                int len = c.getDeclaredFields().length;
                while (c != null) {
                    // System.out.println("The class " + c + " has " + len + " fields");
                    len += c.getDeclaredFields().length;
                    c = c.getSuperclass();

                }
                allFieldsLength.add(len);

            }
            System.out.println(allFieldsLength);

            List<Field> f = ReflectionScript.getAllFields(classArray.get(0));
            for (Field field : f) {
                System.out.println(field);
            }

            // ?------------------------------------
            Map<String, List<String>> mapAllFields = new HashMap<>();
            for (Class<?> c : classArray) {
                mapAllFields.put(c.getName(), new ArrayList<String>());
                Class<?> d = c;
                while (d != null) {

                    Field[] declFields = d.getDeclaredFields();
                    d = d.getSuperclass();
                    for (Field field : declFields) {
                        mapAllFields.get(c.getName()).add(field.getName());

                    }
                }
            }
            System.out.println("ALL FIELDS PAL: " + mapAllFields);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}