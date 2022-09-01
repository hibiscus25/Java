package B_ReadMe.B9_Collection;

import java.util.*;

public class Z_List {
    public static void main(String[] args) {
        List<String> arraylist = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();           // такой же как List, все методы синхронизированны
        List<String> stack = new Stack<>();             // синхронизированные методы
        List<String> syncList = Collections.synchronizedList(new ArrayList<>()); // (для потокобезопасных приложений)

        arraylist.add("A");
        arraylist.add("C");
        arraylist.add("B");
//        for(int i = 0; i < arraylist.size(); i++){
//            System.out.print(i + "  -  ");
//            System.out.println(arraylist.get(i));
//            arraylist.remove(i);
//        }
//        for(String el : arraylist){         // при такой итерации, нельзя менять массив, только cтарым forom
//            System.out.print(el);
//            arraylist.remove(el);
//        }

        //sort  - для сортировки нужен компоратор

        //binarySearch
            // код сломается - нужно сначала сортировать
        // System.out.println(arraylist.get(Collections.binarySearch(arraylist, "B")));
            Collections.sort(arraylist);
            System.out.println(arraylist.get(Collections.binarySearch(arraylist, "B")));

        // toArray and back
            String[] strings = new String[arraylist.size()];
                     strings = arraylist.toArray(strings);

            List<String> stringList = Arrays.asList(strings);       // назад в список

        // list equals
            System.out.println(arraylist.equals(stringList));       // true

        // vector vs sync
            // если есть уже коллекция лучше использовать  syncList, т.к. он просто обернет в синхронность текущий лист
            //    в свою очередь вектор скопирует всю коллекцию в вектор

            // вектор при добавлении єлементов работает быстрее, при расширении вектор увеличивается в 2 раза
            // синхронизатор увеличивается в 1.5 раза

            // по синхронизации итератор будет пробегать быстрее

            List<Integer> lit = new ArrayList<>();
                long start = System.currentTimeMillis();
                for(int i = 0; i <10_000_000; i++)
                        lit.add(i);
                System.out.println(System.currentTimeMillis() - start);     // 6730 5062

            List<Integer> sync = Collections.synchronizedList(new ArrayList<>());
                long startSync = System.currentTimeMillis();
                for(int i = 0; i <10_000_000; i++)
                        sync.add(i);
            System.out.println(System.currentTimeMillis() - startSync); // 6500     5702

            List<Integer> vec = new Vector<>();
                long startVec = System.currentTimeMillis();
                for(int i = 0; i <10_000_000; i++)
                        vec.add(i);
                System.out.println(System.currentTimeMillis() - startVec); // 7715  7537


                long start1 = System.currentTimeMillis();
                for(int i = 0; i < 10_000_000; i++)
                    new Integer(lit.get(i));
            System.out.println(System.currentTimeMillis() - start1);     // 40  42

                long startSync1 = System.currentTimeMillis();
                for(int i = 0; i <10_000_000; i++)
                    new Integer(sync.get(i));
            System.out.println(System.currentTimeMillis() - startSync1); // 75  164

                long startVec1 = System.currentTimeMillis();
                for(int i = 0; i <10_000_000; i++)
                     new Integer(vec.get(i));
            System.out.println(System.currentTimeMillis() - startVec1); // 60   67


            // add of elements
                // в Arrays нельзя добавить больше Integer.MAX
                // в LinkedList может, но нельзя добавить по get
    }
}
