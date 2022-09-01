package F_other;

import java.util.*;

// cоздаем объекты, которые нельзя изменять (пример String является объектом, который нельзя менять)
        /* условия:
                - class final
                - поля - приватные
                - set можно или сразу в поля или через конструктор
                - есть get, в которых все ссылочные поля должны быть клонированы
*/
final class Student implements Cloneable{
    private int age;
    private String name;
    private Date date;

    public Student(int age, String name, Date date) {
        this.age = age;
        this.name = name;
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return (Date) date.clone();                     // чтобы объекты отличались
    }
}


public class B1_ImmutableLess {
    public static void main(String[] args) {
        Student student = new Student(18, "Max", new Date());
            int  i = student.getAge();
            String s = student.getName();
            Date d = student.getDate();
                i = 1;
                s = "Mike";
                d.setTime(0);
            System.out.println(student.getAge());
            System.out.println(student.getName());
            System.out.println(student.getDate());          // без сlone - вернет 1970, т.к. ссылочный объект


        // создание Immutable коллекции
            List<String> arrayList = new ArrayList<>();
                arrayList.add("one");
                arrayList.add("two");
            List<String> list = Collections.unmodifiableList(arrayList);   // все изменения в коллекции запрещены
                arrayList.add("three");
                arrayList.add("four");
            for (String el: list)
                System.out.println(el);

            Set set = Collections.unmodifiableSet(new HashSet<>());
            Map map = Collections.unmodifiableMap(new HashMap());
            // очередей нет
    }
}
