package B_ReadMe.B27_Stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


public class С_Paraller {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();             // 20_000_000  - не сортированный
            for (int i =0; i < 10_000_000; i++) {
                list.add(i);
                list.add(10_000_000 - i);
            }

    //------------------------------------------------------------------------------------------------------------------
        Stream stream = Stream.of(1,2);                 // обычный Stream
                list.stream();
        Stream parStream = Stream.of(1,2).parallel();   // параллельный Stream - выполняется на нескольких ядрах процессора
                list.parallelStream();


        //--------------- проверка производительности ---------------
                System.out.println("Обычный  Stream");
                    System.out.println(new Date());
                    list.stream().sorted().count();
                    System.out.println(new Date());                 // 12 cек
                System.out.println("Параллельный  Stream");
                    System.out.println(new Date());
                    list.parallelStream().sorted().count();
                    System.out.println(new Date());                 // 2 cек

                System.out.println("------------------------");
                System.out.println("Обычный  Stream");
                    System.out.println(new Date());
                    list.stream().sorted().filter(x -> x%2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
                    System.out.println(new Date());                 // 7 cек
                System.out.println("Параллельный  Stream");
                    System.out.println(new Date());
                    list.parallelStream().sorted().filter(x -> x%2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
                    System.out.println(new Date());                 // 3 cек

                System.out.println("------------------------");
                System.out.println("Обычный  Stream");
                    System.out.println(new Date());
                    list.stream().filter(x -> x%2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
                    System.out.println(new Date());                 // 2 cек
                System.out.println("Параллельный  Stream");
                    System.out.println(new Date());
                    list.parallelStream().filter(x -> x%2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
                    System.out.println(new Date());                 // 1 cек

        /*  Когда лучше использовать параллельный Stream:
                    - когда действительно большие объемы данных
                    - когда проблемы с производительностью
                    - не рекомендуется использовать, при использовании многопоточных программ Tomcata....,
                      т.к. можно забить все ядра потоками Stream из-за чего упадет производительность web-приложения
         */

        // при маленьком объеме данных, прирост будет не значительным
            List<Integer> list2 = new ArrayList<>();
                for (int i =0; i < 50; i++)
                    list2.add(i);

            System.out.println("------------------------");
            System.out.println("Обычный  Stream");
                System.out.println(new Date().getTime());
                list2.stream().sorted().count();                // 1 mc
                System.out.println(new Date().getTime());
            System.out.println("Параллельный  Stream");
                System.out.println(new Date().getTime());
                list2.parallelStream().sorted().count();        // 1 mc
                System.out.println(new Date().getTime());


        // есть операторы, которые лучше не использовать с парралельными Stream:
        //          - map, filter, flatMap, sorted, distinct, limit
            List<Integer> list3 = new ArrayList<>();
                for (int i =0; i < 20; i++)
                        list3.add(i);
                list3.parallelStream().forEach( x -> System.out.print( x + " "));        // выводит не последовательно
                System.out.println();
                list3.stream().forEach( x -> System.out.print( x + " "));

    }
}
