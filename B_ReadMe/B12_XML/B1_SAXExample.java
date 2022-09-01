package B_ReadMe.B12_XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


    class Employee {
        private String name, job;

        public Employee(String name, String job) {
            this.name = name;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public String getJob() {
            return job;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    '}';
        }
    }


    public class B1_SAXExample {
        private static ArrayList<Employee> employees = new ArrayList<>();
        private static ArrayList<Employee> employees2 = new ArrayList<>();
        private static boolean isFound;


        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
            // 1. cоздание фабрики и образца парсера
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            // 3.1 задача 1: cоздание парсера с обработчиком событий
                parser.parse(new File("src/B_ReadMe/B12_XML/examXML/1.1_exam.xml"), new XML1Handler());
                printArray (employees);

            // 3.2 задача 2: cоздание парсера с обработчиком событий
                parser.parse(new File("src/B_ReadMe/B12_XML/examXML/2_exam.xml"), new XML2Handler());
                printArray (employees2);

            // 3.3 задача 3: cоздание парсера с обработчиком событий
                System.out.println();
                parser.parse(new File("src/B_ReadMe/B12_XML/examXML/1.2_exam.xml"), new XML3Handler("root"));
                if (!isFound)
                    System.out.println("Элемент не был найден.");
        }


        // 2.1 cоздание обработчика событий парсера
        private static class XML1Handler extends DefaultHandler {
            @Override       // реакция на начало элемента
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("employee")) {                                 // если имя элемента совпадает
                    String name = attributes.getValue("name");              // получаем значение атрибута name
                    String job = attributes.getValue("job");                // получаем значение атрибута job
                    employees.add(new Employee(name, job));
                }
            }
        }


        // 2.2 cоздание обработчика событий парсера
        private static class XML2Handler extends DefaultHandler {
            private String name, job, lastElementName;

            @Override       // реакция на начало элемента
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                lastElementName = qName;                            // получаем имя элемента
            }


            @Override       // реакция на текст внутри элемента
            public void characters(char[] ch, int start, int length) throws SAXException {
                // строка: из общего массива отрезок от ..> ( = start)  до </... ( =length)
                String information = new String(ch, start, length);

                // заменяем все переносы на "" + удаляем пробелы в начале и конце строки
                information = information.replace("\n", "").trim();

                if (!information.isEmpty()) {                           // если не пустой
                    if (lastElementName.equals("name"))                 // если имя элемента = name
                        name = information;
                    if (lastElementName.equals("job"))                  // если имя элемента = job
                        job = information;
                }
            }

            @Override       // реакция на окончание элемента
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if ((name != null && !name.isEmpty()) && (job != null && !job.isEmpty()) ) {
                    employees2.add(new Employee(name, job));
                    // обнуляем данные для следующего элемента
                    name = null;
                    job = null;
                }
            }
        }


        // 2.3 cоздание обработчика событий парсера
        private static class XML3Handler extends DefaultHandler {
            private String element;                             // элемент внутри, которого нужно достать все данные
            private boolean isEntered;

            public XML3Handler(String element) {
                this.element = element;
            }

            @Override       // реакция на начало элемента
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (isEntered) {
                    System.out.println(String.format("Найден элемент <%s>, его атрибуты:", qName));

                    for(int i = 0; i < attributes.getLength(); i++)
                        System.out.println(
                           String.format(" - Имя атрибута: %s, его значение: %s", attributes.getQName(i), attributes.getValue(i)));
                }

                if (qName.equals(element)) {
                    isEntered = true;
                    isFound = true;
                }
            }

            @Override       // реакция на конец элемента
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equals(element))
                    isEntered = false;
            }
        }

    //------------------------------------------------------------------------------------------------------------------
        private static void printArray(ArrayList<Employee> employees){
            for (Employee el : employees)
                System.out.println(el);
            System.out.println();
        }
    }