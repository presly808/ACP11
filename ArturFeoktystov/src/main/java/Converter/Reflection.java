package Converter;


import java.lang.reflect.Field;

public class Reflection {


    public static String convertObjToString(Object object) throws IllegalAccessException {

        Class cl = object.getClass();
        StringBuilder sb = new StringBuilder();
        Field[] fields = cl.getDeclaredFields();

        sb.append("type = " + cl.getName()).append("\n");

        //sb.append("FIELDS").append("\n");
        for (Field field : fields) {
            sb.append(field.getName() + " = " + field.get(object)).append("\n");
        }

        return sb.toString();

    }

}
