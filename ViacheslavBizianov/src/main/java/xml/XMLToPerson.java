package xml;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XMLToPerson {

    private String name;
    private int age;
    public ArrayList<Book> books = new ArrayList<>(10);

    public String convertXMLToPerson(Element curr) throws ParserConfigurationException, IOException, SAXException {

        String currAuth = "";
        String currTitle = "";

        String res = "<" +
                curr.getTagName() +
                (curr.hasAttributes() ? getAttributes(curr) : "") +
                ">";

        if (!curr.hasChildNodes()){
            return "";
        } else {
            NodeList children = curr.getChildNodes();
            String resStr = "";
            for (int i = 0; i < children.getLength(); i++) {
                Node iter = children.item(i);
                if (iter.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) iter;
                    if (element.getNodeName().equals("name")){
                        name = element.getTextContent();
                    } else if (element.getNodeName().equals("age")){
                        age = Integer.parseInt(element.getTextContent());
                    } else if (element.getNodeName().equals("author")){
                        currAuth = element.getTextContent();
                    } else if (element.getNodeName().equals("title")) {
                        currTitle = element.getTextContent();
                        books.add(new Book(currAuth,currTitle));
                    }
                    resStr += convertXMLToPerson(element);
                } else if (iter.getNodeType() == Node.TEXT_NODE){
                    Text textNode = (Text) iter;
                    String text = textNode.getTextContent();
                    if (!text.isEmpty()){
                        resStr += text;
                    }
                }
            }
            res += resStr;

        }

        res += "</" + curr.getTagName() + ">";

        String array = "";
        for (Book book : books){
            if (book != null)
            array += book.getAuthor() + "-" + book.getTitle() + " ";
        }

        return ("name = " + name + "\nage = " + age + "\nbooks:\n" + array);
    }

    private static String getAttributes(Element element) {
        NamedNodeMap map = element.getAttributes();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.getLength(); i++) {
            Attr attr = (Attr) map.item(i);
            sb.append(" ").append(attr.getName()).append("=").append("\"").append(attr.getValue()).append("\"");
        }

        return sb.toString();
    }
}
