package B_ReadMe.B29_Многопоточность;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class F_Concurrent {
    static class NameList{
            // синхронизированные коллекции нужны, когда с листом работают разные потоки
        private List list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name){
            list.add(name);
        }

        public synchronized String removeFirst()  {     // выход из этой ситуации добавить  synchronized
            if (list.size() > 0) {                          // любой поток, который зайдет уснет на 1 сек
                    try {                                   // в это время успеет зайти и другой  поток
                        Thread.sleep(500);            //  первый проснется и удалит  - второй получит ошибку
                    }catch(InterruptedException e){}
                return (String) list.remove(0);
            }
            return null;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        NameList nameList = new NameList();
            nameList.add("first");

        class Th extends Thread {
            @Override
            public void run(){
                System.out.println(nameList.removeFirst());
            }
        }

        new Th().start();
        new Th().start();
    }
}
