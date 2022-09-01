package B_ReadMe.B6_Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//----------------------------------------------- Wildcard  - <?>  -----------------------------------------------------
public class Exam16 {
    static void dump(Collection<Object> c) {
        Iterator<Object> i = c.iterator();
            while (i.hasNext())
                System.out.println(i.next());
    }

    static void Dumps(Collection<?> c) {
        Iterator<?> i = c.iterator();
            while (i.hasNext())
                System.out.println(i.next());
    }


    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
            list.add("new Object()");
            list.add(5);
        List<Integer> ll = new ArrayList<>();
            ll.add(15);
            ll.add(17);

        dump(list);     // ОК
//      dump(ll);       // Ошибка - нельзя передавать List<Integer>, так как он не является подтипом List<Object>
        System.out.println("--------------");

//  Используем Wildcard <?>,  который не имеет ограничения в использовании, то есть имеет соответствие с любым типом
        Dumps(list);
        Dumps(ll);
        }
    }





