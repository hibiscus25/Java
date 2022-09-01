package B_ReadMe.B12_XML;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


    //---------------------------------------------- для задачи 1 ------------------------------------------------------
    class Employee2 {
        private String name, job;

        public Employee2(String name, String job) {
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

    //---------------------------------------------- для задачи 3 ------------------------------------------------------
    abstract class Human {
        private String name;

        public Human(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    class Student extends Human {
        private String course, specialization;

        public Student(String name, String course, String specialization) {
            super(name);
            this.course = course;
            this.specialization = specialization;
        }

        public String getCourse() {
            return course;
        }

        public String getSpecialization() {
            return specialization;
        }

        public String toString() {
            return "Голодный студент " + getName() + " " + course + "-го курса, обучающийся по специальности " + specialization;
        }
    }


    class Professor extends Human {
        private String experience, discipline;

        public Professor(String name, String experience, String discipline) {
            super(name);
            this.experience = experience;
            this.discipline = discipline;
        }

        public String getExperience() {
            return experience;
        }

        public String getDiscipline() {
            return discipline;
        }

        public String toString() {
            return "Профессор " + getName() + ", обладающий опытом: \"" + experience + "\", выкладает дисциплину " + discipline;
        }
    }


    class Member extends Human {
        private String position;

        public Member(String name, String position) {
            super(name);
            this.position = position;
        }

        public String getPosition() {
            return position;
        }

        public String toString() {
            return "Сотрудник обслуживающего персонала " + getName() + ", должность: " + position;
        }
    }




    public class A1_DOMExample {
        private static ArrayList<Employee2> employees = new ArrayList<>();

        private static ArrayList<Human> humans = new ArrayList<>();
            private static final String PROFESSOR = "professor";
            private static final String MEMBER = "member";
            private static final String STUDENT = "student";


        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
                // получение фабрики
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                // из фабрики -  билдер, который парсит XML, создает структуру Document в виде иерархического дерева
            DocumentBuilder builder = factory.newDocumentBuilder();


        // -------------------------------------------- задача 1 -------------------------------------------------------
              // запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно
            Document document = builder.parse(new File("src/B_ReadMe/B12_XML/examXML/1.1_exam.xml"));

                // получаем список всех элементов employee внутри корневого элемента
                    // (getDocumentElement возвращает ROOT элемент XML файла).
            NodeList nodeList = document.getDocumentElement().getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node employee = nodeList.item(i);                       // получаем node
                NamedNodeMap attributes = employee.getAttributes();     // атрибуты  node

                // атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
                employees.add(new Employee2(attributes.getNamedItem("name").getNodeValue(),
                                            attributes.getNamedItem("job").getNodeValue()));
            }

            for (Employee2 employee : employees)
                System.out.println(String.format("Информации о сотруднике: имя - %s, должность - %s.", employee.getName(), employee.getJob()));



        // -------------------------------------------- задача 2 -------------------------------------------------------
            System.out.println();
            document = builder.parse(new File("src/B_ReadMe/B12_XML/examXML/1.2_exam.xml"));

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   // считываем данные с консоли
            String element = reader.readLine();
            reader.close();

                // получение списка элементов, однако для удобства будем рассматривать только первое совпадение в документе
                // ищем элемент внутри документа, а не рут элемента (для того, чтобы рут элемент тоже искался)
            NodeList matchedElementsList = document.getElementsByTagName(element);

            if (matchedElementsList.getLength() == 0) {
                System.out.println("Тег " + element + " не был найден в файле.");
            } else {
                Node foundedElement = matchedElementsList.item(0);              // первый элемент
                System.out.println("!!!!! Элемент был найден !!!!!");

                if (foundedElement.hasChildNodes())
                    printInfoAboutAllChildNodes(foundedElement.getChildNodes());
            }



        // -------------------------------------------- задача 3 -------------------------------------------------------
            System.out.println();
            document = builder.parse(new File("src/B_ReadMe/B12_XML/examXML/1.3_exam.xml"));

            // Получение информации про каждый элемент отдельно
            collectInformation(document, PROFESSOR);
            collectInformation(document, MEMBER);
            collectInformation(document, STUDENT);

            humans.forEach(System.out::println);
        }

        // выводит информацию про все узлы внутри всех узлов
        private static void printInfoAboutAllChildNodes(NodeList list) {
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                // разбираем 2 ситуации, тк у элементов есть два вида узлов - другие элементы или текстовая информация.
                if (node.getNodeType() == Node.TEXT_NODE) {                 // обрабатываем как текст
                    String textInformation = node.getNodeValue().replace("\n", "").trim(); //убираем пробел / перенос

                    if(!textInformation.isEmpty())
                        System.out.println("Внутри элемента найден текст: " + node.getNodeValue());
                }
                else {                                                      // обрабатываем как элемент
                    System.out.println("Найден элемент: " + node.getNodeName() + ", его атрибуты:");
                    NamedNodeMap attributes = node.getAttributes();
                    for (int k = 0; k < attributes.getLength(); k++)
                        System.out.println(" - Имя атрибута: " + attributes.item(k).getNodeName() + ", его значение: " + attributes.item(k).getNodeValue());
                }

                if (node.hasChildNodes())                   // если у элемента еще остались узлы
                    printInfoAboutAllChildNodes(node.getChildNodes());
            }
        }


        // ищет информацию про теги по имени элемента и вносит всю информацию в коллекцию
        private static void collectInformation(Document document, final String element) {
            NodeList elements = document.getElementsByTagName(element);             // все элементы по имени тэга

            for (int i = 0; i < elements.getLength(); i++) {
                NamedNodeMap attributes = elements.item(i).getAttributes();
                String name = attributes.getNamedItem("name").getNodeValue();

                switch (element) {
                    case PROFESSOR: {
                        String experience = attributes.getNamedItem("experience").getNodeValue();
                        String discipline = attributes.getNamedItem("discipline").getNodeValue();
                            humans.add(new Professor(name, experience, discipline));
                    } break;
                    case STUDENT: {
                        String course = attributes.getNamedItem("course").getNodeValue();
                        String specialization = attributes.getNamedItem("specialization").getNodeValue();
                            humans.add(new Student(name, course, specialization));
                    } break;
                    case MEMBER: {
                        String position = attributes.getNamedItem("position").getNodeValue();
                            humans.add(new Member(name, position));
                    } break;
                }
            }
        }
    }

