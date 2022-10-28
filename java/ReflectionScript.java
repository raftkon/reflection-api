import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * ReflectionScript
 */
public class ReflectionScript {

    public static Class<?> reflectionType(String typename) throws ClassNotFoundException {
        Class<?> c = Class.forName(typename);
        return c;
    }

    // Exer 1a
    public static Field[] declaredFields(Class<?> c) {
        Field[] fields = c.getDeclaredFields();
        System.out.println("The " + c + " has " + fields.length + " declared fields.");
        return fields;
    }

    // Exer 1b
    public static void allFields(Class<?> c) {
        Field[] fields = c.getDeclaredFields();
        System.out.println("The " + c + " has " + getAllFields(c).size() + " fields in total.");
    }

    // Exer 2a
    public static void declaredMethods(Class<?> c) {
        Method[] methods = c.getDeclaredMethods();
        System.out.println("The " + c + " has " + methods.length + " methods.");
    }

    // Exer 2b
    public static void allMethods(Class<?> c) {
        System.out.println("The " + c + " has " + gelAllMethodsLength(c) + " methods in total.");

    }

    // Exer 3
    public static void allSuperClasses(Class<?> c) {
        System.out.println("The " + c + " has " + getAllSuperClass(c) + " superclasses.");
    }

    public static List<Field> getAllFields(Class<?> c) {
        List<Field> fields = new ArrayList<>();
        while (c != null) {
            Field[] f = c.getDeclaredFields();
            for (Field field : f) {
                fields.add(field);
            }
            c = c.getSuperclass();
        }
        return fields;
    }

    public static int gelAllMethodsLength(Class<?> c) {
        int result = 0;
        while (c != null) {
            result += c.getDeclaredMethods().length;
            c = c.getSuperclass();
        }
        return result;
    }

    public static int getAllSuperClass(Class<?> c) {
        int result = 0;
        c = c.getSuperclass();

        while (c != null) {
            result += 1;
            c = c.getSuperclass();

        }
        return result;
    }

}