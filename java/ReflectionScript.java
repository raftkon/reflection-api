import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * ReflectionScript
 */
public class ReflectionScript {

    public static Class<?> getReflectionType(String typename) throws ClassNotFoundException {
        return Class.forName(typename);
    }

    // Exer 1a
    public static Field[] declaredFields(Class<?> c) {
        // System.out.println("The " + c + " has " + fields.length + " declared
        // fields.");
        return c.getDeclaredFields();
    }

    // Exer 1b
    public static List<Field> allFields(Class<?> c) {
        // System.out.println("The " + c + " has " + getAllFields(c).size() + " fields
        // in total.");
        return getAllFields(c);
    }

    // Exer 2a
    public static Method[] declaredMethods(Class<?> c) {
        return c.getDeclaredMethods();
        // System.out.println("The " + c + " has " + methods.length + " methods.");
    }

    // Exer 2b
    public static List<Method> allMethods(Class<?> c) {
        return getAllMethods(c);
        // System.out.println("The " + c + " has " + getAllMethodsLength(c) + " methods
        // in total.");

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

    public static List<Method> getAllMethods(Class<?> c) {
        List<Method> methods = new ArrayList<>();
        while (c != null) {
            Method[] f = c.getDeclaredMethods();
            for (Method method : f) {
                methods.add(method);
            }
            c = c.getSuperclass();
        }
        return methods;
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