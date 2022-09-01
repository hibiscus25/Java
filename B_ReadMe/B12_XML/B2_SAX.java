package B_ReadMe.B12_XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


    public class B2_SAX {
        public static int count = 1;

        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
        // вариант 1
            DefaultHandler defaultHandler = new DefaultHandler(){
                @Override   // реакция на начало элемента
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    String name = attributes.getValue("name");
                    if (name != null && !name.isEmpty())
                        System.out.println(" - name = " + name);
                }

                @Override   // реакция на чтение текста между тэгами            // start - индекс начального элемента
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String inf = new String(ch, start, length).replace("\n", "").trim();
                        if (!inf.isEmpty())
                            System.out.println(" -- textTag = " + inf);
                }
            };

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = saxParserFactory.newSAXParser();
            parser.parse(new File("src/B_ReadMe/B12_XML//examXML/0.0_Exam.xml"), defaultHandler);


        // вариант 2
            System.out.println();
            XMLInputFactory fact = XMLInputFactory.newInstance();
            XMLStreamReader pars = fact.createXMLStreamReader(new FileInputStream("src/B_ReadMe/B12_XML//examXML/0.0_Exam.xml"));
                while(pars.hasNext()){
                    int event = pars.next();
                    if(event == XMLStreamConstants.START_ELEMENT){
                        String name = pars.getAttributeValue(null,"name");
                        if (name != null)
                            System.out.println(" - name = " + name);
                    }

                    if(event == XMLStreamConstants.CHARACTERS){
                        String inf = new String (pars.getTextCharacters(), pars.getTextStart(), pars.getTextLength());
                        inf =  inf.replace("\n", "").trim();
                        if (!inf.isEmpty())
                            System.out.println(" -- textTag = " + inf);
                    }
                }
        }
    }
