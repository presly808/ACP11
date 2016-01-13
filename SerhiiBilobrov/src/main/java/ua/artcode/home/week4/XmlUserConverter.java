package ua.artcode.home.week4;

import java.util.Map;

/**
 * Created by serhii on 26.12.15.
 */
public class XmlUserConverter {


    public static String toXML(User user){
        String xml = "";
        xml += String.format("<user>");
        xml += String.format("<name>%s</name>", user.name);
        xml += String.format("<user>");
        return null;
    }

    public static String toXML(Map<String, Object> map){
        return null;
    }

    public static String toXML(Convertable conv){
        return null;
    }

    public String toXml(Object obj){// via reflection
        return null;//
    }


}


