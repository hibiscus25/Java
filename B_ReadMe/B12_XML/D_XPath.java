package B_ReadMe.B12_XML;

import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

    public class D_XPath {
        public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/B_ReadMe/B12_XML/examXML/0.0_Exam.xml"));

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();


            // text tag
            System.out.println(xpath.evaluate("/preferences/rоot/node/map", document));
            System.out.println(xpath.evaluate("/preferences/rоot/node/map[1]", document));
            System.out.println();


            // Count node
            System.out.println(xpath.evaluate("count(/preferences/rоot/node)", document));
            int count = ((Number) xpath.evaluate("count(/preferences/rоot/node)", document, XPathConstants.NUMBER)).intValue();
                System.out.println(count);
            System.out.println();


            // Node
            Node node = (Node) xpath.evaluate("/preferences/rоot/node/node/map", document, XPathConstants.NODE);
            System.out.println("Node = " + node.getNodeName());
            NamedNodeMap attributes = node.getAttributes();
            for (int w = 0; w < attributes.getLength(); w++) {
                Node att = attributes.item(w);
                System.out.println(" - " + att.getNodeName() + " = " + att.getNodeValue());
                System.out.println(" - text Tag = " + node.getTextContent());
            }
            System.out.println();


            // NodeList
            NodeList lists = (NodeList) xpath.evaluate("/preferences/rоot/map/entry", document, XPathConstants.NODESET);
            for(int i = 0; i < lists.getLength(); i++)
                System.out.println(lists.item(i).getNodeName());
        }
    }
