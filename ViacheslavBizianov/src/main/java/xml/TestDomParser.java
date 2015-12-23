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
public class TestDomParser {

    public static final String PATH = "C:\\Users\\slava23\\ACP11\\ViacheslavBizianov\\pom.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(PATH));
        Element root = document.getDocumentElement();

        System.out.println(DomParser.getTextXMLContent(root));

    }
}
