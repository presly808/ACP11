package week_04;

import java.lang.reflect.Field;

/**
 * Created by Dima on 26.12.2015.
 */
public class SaveObject {

    private static Field[] fieldsNames(Object obj) {
        Class cl = obj.getClass();
        return cl.getFields();
    }

    private static String makeString(Object obj,String...s) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        String tab =  (s.length > 0)? s[0] : "";

        Field[] fields = fieldsNames(obj);
        for (Field field: fields) {
            if (field.isAnnotationPresent(NonTrivialField.class)) {

                sb.append(tab).append("<").append(field.getName()).append(">\n");
                    sb.append(makeString(field.get(obj), tab + "\t"));
                sb.append(tab).append("</").append(field.getName()).append(">\n");

            } else {

                sb.append(tab).append("<").append(field.getName()).append(">");
                    sb.append(field.get(obj));
                sb.append("</").append(field.getName()).append(">\n");

            }
        }

        return sb.toString();
    }

    public static String saveObj(Object obj) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        sb.append("<className value=\"").append(obj.getClass()).append("\">\n");
            sb.append(makeString(obj,"\t"));
        sb.append("</className>");

        return sb.toString();


    }

}
