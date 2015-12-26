package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by slava23 on 12/22/2015.
 */
public class TestPersonToXML {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        Book book1 = new Book("author1","title1");
        Book book2 = new Book("author2","title2");
        Book book3 = new Book("author3","title3");
        Book [] books = new Book[]{book1,book2,book3};

        PersonToXML.savePersonToXML(new Person("Vasia",27,books));

        System.out.println("XML -> Person");

        String PATH = "C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\src\\main\\resources\\file.xml";

        XMLToPerson xmlParser = new XMLToPerson();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(PATH));
        Element root = document.getDocumentElement();

        System.out.println(xmlParser.convertXMLToPerson(root));

    }
}
