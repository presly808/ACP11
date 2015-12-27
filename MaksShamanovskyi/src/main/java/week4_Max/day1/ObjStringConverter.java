package week4_Max.day1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjStringConverter {


    public static String toString(Object obj){
        Class cl = obj.getClass();

        StringBuilder sb = new StringBuilder();

        sb.append("type=" + cl.getName()).append("\n");
        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {
            try {
                sb.append(field.getName() + "=" + field.get(obj)).append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    public static Object toObj(String str){
        Scanner sc = new Scanner(str);
        List<String> listFields = new ArrayList<>();
        List listArgs = new ArrayList();
        sc.useDelimiter("=");
        while(sc.hasNext()){
            listFields.add(sc.next());
            listArgs.add(sc.next());
        }
        return null;
    }
}
