package B_ReadMe.B12_XML;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class C2_createXMLSAX {
    public static final String path = "src\\B_ReadMe\\B12_XML\\examXML\\4_SAX.xml";

    // не форматированный вывод в XML
    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        FileOutputStream fos = new FileOutputStream(path);
        XMLStreamWriter wr = factory.createXMLStreamWriter(fos);
            wr.writeStartDocument();
                wr.writeStartElement("root");
                    wr.writeStartElement("font");
                    wr.writeAttribute("size","20");
                    wr.writeCharacters("Times New Roman");
                    wr.writeEndElement();
                wr.writeEndElement();
            wr.writeEndDocument();
        fos.close();

        //--------------------------------------------------------------------------------------------------------------
        new File(path).delete();
    }
}
