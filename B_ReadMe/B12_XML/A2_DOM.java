package B_ReadMe.B12_XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


    public class A2_DOM {
        public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
            // получаем документ XML - по системе DOM полностью копируется XML документ в память
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new File("src/B_ReadMe/B12_XML/examXML/0.0_Exam.xml"));

            // получаем элемент Document
                Element element = doc.getDocumentElement();
                    System.out.println("Элемент XML: " + element.getTagName());                           //имя элемента

            // получаем наследников элемента
                System.out.println();
                System.out.println("------- Наследники элемента -------");
                NodeList nodeList = element.getChildNodes();
                    System.out.println("C учетом переноса на новую строку");
                    for(int i = 0; i < nodeList.getLength(); i++){
                        System.out.print(nodeList.item(i));
                    }

                    System.out.println();
                    System.out.println("Без учета переноса на новую строку:");
                    for(int i = 0; i < nodeList.getLength(); i++){
                        if (nodeList.item(i) instanceof Element)
                            System.out.println(((Element) nodeList.item(i)).getTagName());
                    }

            // получаем структуру наследников элемента
                System.out.println();
                System.out.println("Все наследники элемента");
                    printElements(nodeList, 0, false, false, false);        // рекурсивный метод

            // получаем структуру наследников элемента + кто имеет - значение аттрибута name
                System.out.println();
                System.out.println("Все наследники элемента + значение name");
                    printElements(nodeList, 0, true, false, false);

            // получаем структуру наследников элемента + кто имеет - значение аттрибута name + текст между тегами
                System.out.println();
                System.out.println("Все наследники элемента + значение name + текст между тегами");
                    printElements(nodeList, 0, true, true, false);

            // получаем структуру наследников элемента + их аттрибуты и значения + текст между тегами
                System.out.println();
                System.out.println("Все наследники элемента + все аттрибуты и их значения  + текст между тегами");
                    printElements(nodeList, 0, false, true, true);
    }


        //--------------------------------------------------------------------------------------------------------------
        public static void printElements (NodeList list, int count, boolean attribName, boolean textTag, boolean atrVal){
            for(int i = 0; i < list.getLength(); i++){
                // если не переопределять переменную будет использовать сount метода, который вызывает рекурсию
                int countFor = count;
                Node node = list.item(i);
//              if (node.getNodeType() == Node.ELEMENT_NODE){      - аналогично проверяет, является ли элемент - NODE
                if (node instanceof Element) {
                    str(countFor);
                    System.out.print(((Element) node).getTagName());

                    // добавляем, кто имеет аттрибут name
                    if (attribName && ((Element) node).hasAttribute("name")) {
                        System.out.print(" - name = " + ((Element) node).getAttribute("name"));
                    }

                    // все аттрибуты и их значения
                    if (atrVal) {
                        NamedNodeMap attributes = node.getAttributes();
                        // System.out.println(attributes.getNamedItem("name"));
                                //  - будет у каждого Node проверять такой атрибут, если есть выведет значение атрибута
                                //                                                  если нет  выведет null
                        for (int w = 0; w < attributes.getLength(); w++) {
                            Node att = attributes.item(w);
                            System.out.print(" - " + att.getNodeName() + " = " + att.getNodeValue());
                        }
                    }

                    // значение между тегами
                    if (textTag  &&   !node.getTextContent().trim().isEmpty()
                        &&   !((Text) node.getFirstChild()).getData().trim().isEmpty()
                        &&   !((Text) node.getFirstChild()).getData().trim().equals("\n")){
                            Text text = (Text) node.getFirstChild();
                            System.out.print(" <> " + text.getData().trim() + " </>");
                    }
                    System.out.println();
                }
                if(node.hasChildNodes()) {
                    if (node.getChildNodes().getLength() != 1)                  // убираем перенос после node
                        printElements(node.getChildNodes(), ++countFor, attribName, textTag, atrVal);
                }
            }
        }

        public static void str(int countFor){
            for (int i = 0; i < countFor; i++)
                System.out.print("-");
        }
    }
