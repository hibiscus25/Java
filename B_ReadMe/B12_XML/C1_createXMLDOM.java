package B_ReadMe.B12_XML;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



    public class C1_createXMLDOM {
        public static final String path = "src\\B_ReadMe\\B12_XML\\examXML\\3.1_DOM.xml";
        public static final String path2 = "src\\B_ReadMe\\B12_XML\\examXML\\3.2_DOM.xml";

        public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("root");                     // cоздаем элементы
            Element font = document.createElement("font");

            Text textFont = document.createTextNode("Times New Roman");           // текст между тэгами

            document.appendChild(root);                                                 //создаем иерархию
                root.appendChild(font);
                font.appendChild(textFont);
                    font.setAttribute("size", "20");                          //добавляем атрибут
                    font.setAttribute("name", "example");

            // cоздаем ХML
            Transformer t = TransformerFactory.newInstance().newTransformer();
                t.setOutputProperty(OutputKeys.INDENT, "yes");                             // запись не в строчку
                    FileOutputStream fos = new FileOutputStream(path);
                t.transform(new DOMSource(document), new StreamResult(fos));
                    fos.close();


            // записываем ХML в строку
            // TODO не переносит <root> на новую строку, пишет вместе с заглавием XML
            DOMImplementation impl = document.getImplementation();
            DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature("LS","3.0");
            LSSerializer ser = implLS.createLSSerializer();
            // ser.getDomConfig().setParameter("xml-declaration", false);                           // без первой строки
               ser.getDomConfig().setParameter("format-pretty-print",true);
//                String str = ser.writeToString(document);
//                System.out.print(str);                                                            // вывод в строку

            // записываем в файл
            LSOutput out = implLS.createLSOutput();
                out.setEncoding("UTF-8");
                out.setByteStream((Files.newOutputStream(Paths.get(path2))));
            ser.write(document, out);

        //------------------------------------------- удаляем File -----------------------------------------------------
            new File(path).delete();
            new File(path2).delete();
        }
    }
