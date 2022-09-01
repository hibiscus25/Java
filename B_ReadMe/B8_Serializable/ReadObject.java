package B_ReadMe.B8_Serializable;

import java.io.*;

public class ReadObject {
    public final static String PATH_FILE = "src\\B_ReadMe\\B8_Serializable\\people.bin";

    public static void main(String[] args) {

    //пример 1 - чтение  объекта
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_FILE))) {

            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();

            System.out.println(person1);
            System.out.println(person2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    //пример 2 - чтение  массива объектов
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_FILE))) {
//
//            //Вариант 1
////            int personCount= ois.readInt();
////            Person[] people = new Person[personCount];
////
////            for(int i = 0; i < personCount; i ++){
////                people[i] = (Person) ois.readObject();
////                System.out.println(people[i]);
////            }
//
//            //вариант 2 - так как массив также является объектом
//            Person[] person = (Person[]) ois.readObject();
//            for(Person el : person){
//                System.out.println(el);
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
