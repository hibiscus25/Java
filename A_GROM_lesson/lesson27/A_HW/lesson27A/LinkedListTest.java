package A_GROM_lesson.lesson27.A_HW.lesson27A;

import java.util.*;

public class LinkedListTest {
    private static Order order1=new Order(1,25);
    private static Order order2=new Order(1,25);
    private static Order order3=new Order(1,25);
    private static Order order4=new Order(1,25);
    private static Order order5=new Order(1,25);

    public static void main(String[] args) {
        System.out.println(userList());
    }

    public static LinkedList userList(){
        LinkedList<Order> list=new LinkedList<>();                    //cоздаем коллекцию
        list.add(order1);
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
