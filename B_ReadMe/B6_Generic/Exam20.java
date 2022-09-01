package B_ReadMe.B6_Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//--------------------------------------------- Bounded type argument  -------------------------------------------------
    public class Exam20 {
        static <T> void addAll(Collection<T> c, Collection<T> c2) {
            Iterator<T> i = c.iterator();
                while (i.hasNext())
                     c2.add(i.next());
        }


//  Bounded type argument -  нужен если метод, который мы разрабатываем, использовал бы определенный тип данных
        // в примере вводим  <N extends M> (N принимает только значения M)
            // можно корректно писать <T extends A & B & C> (то есть принимает значения нескольких переменных)
        static <M, N extends M> void newAddAll(Collection<N> c, Collection<M> c2) {
            Iterator<N> i = c.iterator();
                while (i.hasNext())
                    c2.add(i.next());
        }


        public static void main(String[] args) {
            addAll(new ArrayList<Integer>(), new ArrayList<Integer>());
                //Ошибка - из - за того, что две коллекции могут быть разных типов (несовместимость generic-типов)
//          addAll(new ArrayList<Integer>(), new ArrayList<Object>());


            newAddAll(new ArrayList<Integer>(), new ArrayList<Integer>());
            newAddAll(new ArrayList<Integer>(), new ArrayList<Object>());
    }
}

