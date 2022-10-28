import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {

        try {
            List<String> classArr = readFile(args[0]);
            for (String string : classArr) {

                reflectionType(string);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

    private static void reflectionType(String typename) throws ClassNotFoundException {
        Class<?> c = Class.forName(typename);

        exer1(c);
        exer2(c);
        System.out.println("The " + c + " has " + getAllSuperClass(c) + " superclasses.");

    }

    private static void exer1(Class<?> c) {
        Field[] fields = c.getDeclaredFields();
        System.out.println("The " + c + " has " + fields.length + " declared fields.");
        System.out.println("The fields are: " + mapFieldsToString(fields));
        System.out.println("The " + c + " has " + getAllFieldsLength(c) + " fields in total.");
    }

    private static void exer2(Class<?> c) {
        Method[] methods = c.getDeclaredMethods();
        System.out.println("The " + c + " has " + methods.length + " methods.");
        System.out.println("The methods are: " + mapMethodsToString(methods));
        System.out.println("The " + c + " has " + gelAllMethodsLength(c) + " methods in total.");
    }

    private static String mapMethodsToString(Method[] methods) {
        List<String> methodStrings = new ArrayList<>();
        for (Method m : methods) {
            String method = m.getName();
            methodStrings.add(method);

        }
        return String.join(", ", methodStrings);
    }

    private static String mapFieldsToString(Field[] fields) {
        List<String> methodStrings = new ArrayList<>();
        for (Field f : fields) {
            String field = f.getName();
            methodStrings.add(field);

        }
        return String.join(", ", methodStrings);
    }

    private static List<String> readFile(String filename) throws Exception {
        FileReader fr = new FileReader(filename); // Anoigei arxeio
        BufferedReader br = new BufferedReader(fr); // Diavazei arxeio
        List<String> strArr = new ArrayList<>();
        String str = br.readLine();

        while (str != null) {
            System.out.println(str);
            strArr.add(str);
            str = br.readLine();
        }
        br.close();

        return strArr;

    }

    private static void writeFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        // for (String string : strArr) {
        // writer.write(string);
        // writer.write("\n");
        // }
        writer.close();
    }

    private static int getAllFieldsLength(Class<?> c) {
        int result = 0;
        while (c != null) {
            result += c.getDeclaredFields().length;
            c = c.getSuperclass();
        }
        return result;
    }

    private static int gelAllMethodsLength(Class<?> c) {
        int result = 0;
        while (c != null) {
            result += c.getDeclaredMethods().length;
            c = c.getSuperclass();
        }
        return result;
    }

    private static int getAllSuperClass(Class<?> c) {
        int result = 0;
        c = c.getSuperclass();

        while (c != null) {
            result += 1;
            c = c.getSuperclass();

        }
        return result;
    }

    // private static int getAllFields(Class<?> c) {
    // if (c == null)
    // retzzurn 0;

    // int result = getAllFields(c.getSuperclass());
    // result += c.getDeclaredFields().length;
    // return result;
    // }

}
