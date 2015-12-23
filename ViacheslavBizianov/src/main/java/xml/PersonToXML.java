package xml;

import java.io.*;

/**
 * Created by slava23 on 12/22/2015.
 */
public class PersonToXML {

    public static void savePersonToXML(Person person) throws IOException {

        StringBuilder sb = new StringBuilder();

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<object>\n");

        sb.append(" <name>" + person.getName() + "</name>\n");
        sb.append(" <age>" + person.getAge() + "</age>\n");
        sb.append(" <books>\n");

        for (int i=0; i < person.getBooks().length; i++){
            sb.append("  <book id=\"" + i + "\">\n");
            sb.append("   <author>" + person.getBooks()[i].getAuthor() + "</author>\n");
            sb.append("   <title>" + person.getBooks()[i].getTitle() + "</title>\n");
            sb.append("  </book>\n");
        }

        sb.append(" </books>\n");

        sb.append("</object>\n");

        FileWriter writer =
                new FileWriter("C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\src\\main\\resources\\file.xml");

        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }
}
