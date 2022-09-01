package A_GROM_lesson.lesson26;

import java.util.*;

public class ArrayListTest {

    public static ArrayList userList(){
        Order order1=new Order(1,25,"d","S","1");
        Order order2=new Order(2,25,"d","S","1");
        Order order3=new Order(3,25,"d","S","1");
        Order order4=new Order(4,25,"d","S","1");
        Order order5=new Order(5,25,"d","S","1");

        ArrayList<Order> list=new ArrayList<>();                    //cоздаем коллекцию
        list.add(order1);                                               //добавляем объекты в коллекцию
        list.add(order2);
        list.add(order3);
        list.add(order4);
        list.add(order5);
        System.out.println(list.toString());

        list.add(3,order1);                                         //добавляем объект в указанный индекс
        System.out.println(list.toString());

        list.remove(3);                                             //удаляем содержание указанного индекса
        System.out.println(list.toString());

        list.remove(order2);                                              //удаляем указанный объект
        System.out.println(list.toString());

        ArrayList<Order> list2=new ArrayList<>();                       //cоздаем вторую коллекцию
        list2.add(order1);                                                  //добавляем объекты в коллекцию
        list2.add(order2);
        list2.add(order3);

        list.addAll(list2);                                             //объединение двух коллекций
        System.out.println(list.toString());

        list.set(2,order5);                                             //перезаписывает данные в указанном индексе
        System.out.println(list.toString());

        System.out.println(list.contains(order2));                        //результат boolean - есть аргумент в массиве
        list.remove(order1);                                                    //удаляем указанный объект - удаляет певрый
        list.remove(order1);                                                    //удаляем указанный объект - удаляет певрый
        System.out.println(list.toString());
        System.out.println(list.contains(order1));                        //результат boolean - есть аргумент в массиве

        list2.clear();                                                    //очищает коллекцию от данных
        System.out.println(list2.toString());

        Object[] array= list.toArray();                                 //преобразования списка в массив
        System.out.println(Arrays.deepToString(array));
        System.out.println(array[0]);

        System.out.println(list.subList(1,3).toString());                 //возвращает вид родительского списка
        list.subList(1,3).clear();                                        //с которым можно работать, изменяя родит список
        System.out.println(list.toString());

        list.add(order1);
        list.add(order2);
        System.out.println(list.toString());

    return list;}
}
