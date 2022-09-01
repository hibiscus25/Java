package B_ReadMe.B8_Serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public final static String PATH_FILE = "src\\B_ReadMe\\B8_Serializable\\people.bin";

    public static void main(String[] args) {

    // пример1 - запись объекта
        Person person1 = new Person(1, "коля");
        Person person2 = new Person(1, "маша");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_FILE))) {
                oos.writeObject(person1);
                oos.writeObject(person2);
        }catch (IOException e){
            e.printStackTrace();
        }

    //пример 2 - записываем массив объектов
//        Person person4 = new Person(1, "коля");
//        Person person5 = new Person(2, "маша");
//        Person person6 = new Person(3, "ПЕТЯ");
//        Person[] people = {person4, person5, person6};
//
//        //записываем массив объектов в файл
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_FILE))) {
//
//            //вариант 1
////                oos.writeInt(people.length);
////                for(Person el: people){
////                    oos.writeObject(el);
////                }
//
//            //вариант 2 - так как массив также является объектом
//            oos.writeObject(people);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
