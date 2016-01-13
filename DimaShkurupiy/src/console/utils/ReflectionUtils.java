package console.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by serhii on 26.12.15.
 */
public class ReflectionUtils {


    public static String getTypeInfo(Object object) {
        Class cl = object.getClass();

        StringBuilder sb = new StringBuilder();

        sb.append(cl.getName()).append("\n");
        Field[] fields = cl.getFields();

        sb.append("CONSTRUCTORS").append("\n");
        for (Constructor cons : cl.getConstructors()) {
            sb.append(cons.toString()).append("\n");
        }

        sb.append("FIELDS").append("\n");
        for (Field field : fields) {
            sb.append(field.toString()).append("\n");
        }

        sb.append("METHODS").append("\n");
        for (Method method : cl.getMethods()) {
            sb.append(method.toString()).append("\n");
        }

        return sb.toString();

    }

    public static String getFieldsValue(Object object) {
        Class cl = object.getClass();

        StringBuilder sb = new StringBuilder();

        sb.append(cl.getName()).append("\n");
        Field[] fields = cl.getDeclaredFields();// get all (private, )

        sb.append("FIELDS").append("\n");
        for (Field field : fields) {
            try {
                //field.setAccessible(true);
                sb.append(field.getName() + "=" + field.get(object)).append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();

    }

    public static Object callMethod(Object instance, String methodName, String[] args) throws NoSuchMethodException {
        Class cl = instance.getClass();
        Class type = args.getClass();

        Method method = cl.getMethod(methodName,type);

        try {
            Object object = method.invoke(instance,(Object) args);
            return object;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
