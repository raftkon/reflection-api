import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * HelloWorld
 */
public class HelloWorld {
    public static void main(String[] args) {

        if (args != null && args.length == 1) {
            try {

                reflectionType(args[0]);

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    private static void reflectionType(String typename) throws ClassNotFoundException {
        Class<?> c = Class.forName(typename);
        returnSuperClass(c);
        Method[] methods = c.getDeclaredMethods();
        System.out.println("The " + c + " has " + methods.length + " methods.");
        System.out.println("The methods are: " + mapMethodsToString(methods));

    }

    private static String mapMethodsToString(Method[] methods) {
        List<String> methodStrings = new ArrayList<>();
        for (Method m : methods) {
            String method = m.getName();
            methodStrings.add(method);

        }
        return String.join(", ", methodStrings);
    }

    private static Class<?> returnSuperClass(Class<?> c) {
        return c.getSuperclass();

    }
}