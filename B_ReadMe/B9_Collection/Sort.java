package B_ReadMe.B9_Collection;

import java.util.*;

//------------------------------------------- cортировка ---------------------------------------------------------------
    class Person implements Comparable<Person>{
        long age;
        String name;

        Set<String> lis;

        public Person(long age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
//            return (int) (this.age - o.age);          // при сортировке по age
            return this.name.compareTo(o.name);         // при сортировке по name
        }

        @Override
        public String toString(){
            return "Person{" + "age=" + age + "," +  "name=" + name + "}";
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    class Lord{
        long age;
        String name;

        public Lord(long age, String name){
            this.age = age;
            this.name = name;
        }

        public long getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString(){
            return "Lord{" + "age=" + age + " , " +  "name=" + name + "}";
        }
    }


    class ComparaLord implements Comparator<Lord>{

        @Override
        public int compare(Lord o1, Lord o2) {
//            return (int) (o1.age - o2.age);             // при сортировке по age
            return o1.name.compareTo(o2.name);            // при сортировке по name
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    public class Sort {
        public static void main(String[] args) {
    // Пример 1:
        // при сортировке примитивных типов String, Integer ..  они уже отсортированы compareTo(T o) интерфейса Comparable<Integer>
            // class Integer extends Number implements Comparable<Integer>
                    Set set= new TreeSet();
//                        set.add(5);
//                        set.add(3);
//                        set.add(1);
//                        set.add(4);
                            set.add("Николай");
                            set.add("Абрам");
                            set.add("Линкольн");
                            set.add("Гавриил");
            for(Object el : set)
                System.out.println(el);


    // Пример 2.1:
        // при сортировке объекта можно добавить до класса  Comparable<Integer> и переопределить метод  compareTo(T o)
            System.out.println("------------------------");
            Set<Person> set2= new TreeSet();
                set2.add(new Person(7, "курск"));
                set2.add(new Person(3, "мордор"));
                set2.add(new Person(1, "радар"));
                set2.add(new Person(5, "aрт"));
            for(Person el : set2)
                System.out.println(el);


    // Пример 2.2:
        // при сортировке объекта, если нет возможности использовать  Сomparable
            // cоздается класс, который implements Comparator<Клас> и переопределяет метод compare
            System.out.println("------------------------");
            Set<Lord> set3= new TreeSet(new ComparaLord());
                set3.add(new Lord(7, "курск"));
                set3.add(new Lord(3, "мордор"));
                set3.add(new Lord(1, "радар"));
                set3.add(new Lord(5, "aрт"));
            for(Lord el : set3)
                System.out.println(el);


    // Пример 2.3
            System.out.println("------------------------");
            List<Lord> lord = Arrays.asList(
                new Lord(28, "John"),
                new Lord(35,"Jane" ),
                new Lord(21, "Alex"));

            System.out.println("Before sort:");
                for (Lord el : lord)
                    System.out.println(el);

            Collections.sort(lord, new Comparator<Lord>() {                             // вар 1 _ задаем Comparator
                @Override
                public int compare(Lord o1, Lord o2) {
                    return (int) (o1.getAge() - o2.getAge());
                }
            });

//            Comparator<Lord> comp = (o1, o2) -> (int) (o1.getAge() - o2.getAge());
//                Collections.sort(lord, comp);                                      // вар_2
//                lord.sort(comp);                                                   // вар_3
//            lord.sort(Comparator.comparing(Lord::getAge));                         // вар_4

//                lord.sort(comp.reversed());                                        // сортировка в обратном направлении

//            lord.sort((o1, o2) -> {                                                // cортировка - несколько значений
//                if (o1.getAge() == o2.getAge())
//                    return o1.getName().compareTo(o2.getName());
//                else return (int) (o1.getAge() - o2.getAge());
//            });



        System.out.println("\nAfter sort:");
            for (Lord el : lord)
                System.out.println(el);
        }
    }

