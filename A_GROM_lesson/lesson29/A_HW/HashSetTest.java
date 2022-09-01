package A_GROM_lesson.lesson29.A_HW;

import java.util.*;

public class HashSetTest {
    public static void useHashSet() {
        Order order1 = new Order(12, 345, "text", "dan", "12554");
        Order order2 = new Order(14, 346, "texts", "dans", "12555");
        Order order3 = new Order(15, 347, "textd", "dana", "12559");

        Order order4 = new Order(16, 348, "textf", "danr", "125589");
        Order order5 = new Order(18, 349, "textg", "danw", "125");
        Order order6 = new Order(18, 349, "textg", "danw", "125");
        Order order7 = new Order(19, 351, "texto", "danl", "12594");


        Set<Order> set = new HashSet<>();
//a.добавляем в структуру данных
        set.add(order1);
        set.add(order2);
        set.add(order3);
        set.add(order4);
        set.add(order5);
        set.add(order6);        //не будет внесен, так как одинаковй с order5
        set.add(order7);
        System.out.println(set);

//b.удаляем объект из структуры данных
        set.remove(order7);
        System.out.println(set);

//с.узнаем размер структуры данных
        System.out.println(set.size());

//d.удаление элементов из созданной колллекции, остается только то, что указанно как аргумент
        Order order8 = new Order(12, 3454, "texts", "danq", "125554");
        Order order9 = new Order(1, 3463, "textsr", "danse", "162555");
        Order order10 = new Order(2, 3474, "textda", "danar", "125659");

        Order order11 = new Order(18, 349, "textg", "danw", "125");
        Set<Order> set1 = new HashSet<>();
        set1.add(order8);
        set1.add(order9);
        set1.add(order10);
        set1.add(order11);
        System.out.println(set1);

        System.out.println("");
        set.addAll(set1);           //при добавлении если в set1 есть одинаковые, остаются, только не повторяются
        System.out.println(set);

        System.out.println("");
        set.retainAll(set1);        //оставлет коллекцию, которая указанна в скобке(set1)
        System.out.println(set);

//e.преобразование в массив
        set.add(order1);
        Object[] obj = set.toArray();
        System.out.println(Arrays.deepToString(obj));

        System.out.println(set);
    }
}
