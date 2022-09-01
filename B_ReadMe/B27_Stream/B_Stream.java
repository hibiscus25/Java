package B_ReadMe.B27_Stream;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.*;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;


public class B_Stream {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
            list.add("One");        list.add("Two");        list.add("Three");      list.add("Four");
            list.add("Five");       list.add("Six");         list.add("Seven");     list.add("Eight");
            list.add("Nine");       list.add("Ten");


    //---------------------------------------- пример без / с Stream ---------------------------------------------------
        System.out.println("--------- пример без / с Stream ---------");
        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
        int count = 0;
        for (int x : arr) {
            if (x >= 90) continue;
            x += 1;
            count++;
            if (count > 3) break;
            System.out.print(x + "   ");
        }


        System.out.println();
        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120)         // создали Stream
                .filter(x -> x < 90)                            // фильтр  - только меньше 90
                .map(x -> x + 1)                                // добавили до x + 1, кто прошел фильтр
                .limit(3)                                       // количество чисел - 3
                .forEach(x -> System.out.print(x + "   "));     // выводим, через  forEach


    //-------------------------------- возможные способы создания Stream -----------------------------------------------
//        Stream stream = Stream.empty();                                             // пустой стрим
//               stream = Stream.of("1", "2", "3");                                   // стрим из указанных элементов
//               stream = Arrays.stream(array);                                       // из массива
//               stream = Stream.of(asList("a", "b"), asList("a", "l"));              // из нескольких массивов
//               stream = list.stream();                                              // из List
//               stream = map.entrySet().stream();                                    // из Map

//        Cоздание Stream-a примитивов
                 IntStream intStream = IntStream.of(1, 2, 3, 4);
                 LongStream longStream = LongStream.of(5, 6, 7, 8);
                 DoubleStream doubleStream = DoubleStream.of(9, 10, 11, 12);

//        range(startInclusive, endExclusive)  - для генерирования Stream в указанном  диапазоне
                IntStream intStream1 = IntStream.range(1,100);                      // создает IntStream   от 1 до 99
                LongStream longStream1 = LongStream.range(2,200);                   // создает LongStream  от 2 до 199
            //  DoubleStream doubleStream1 = DoubleStream.range(3,300);             // не создает, метода range - нет

//        rangeСlosed(startInclusive, endExclusive)  - такой же как и range(), но включает последнее значение
                IntStream intStream2 = IntStream.rangeClosed(1, 100);               // создает IntStream   от 1 до 100
                LongStream longStream2 = LongStream.rangeClosed(2, 200);            // создает LongStream  от 2 до 200
            //  DoubleStream doubleStream2 = DoubleStream.rangeClosed(3,300);       // не создает, метода rangeClosed - нет

//        asIntStream, asLongStream, asDoubleStream  - преобразование Stream
//              - IntStream можно преобразовать в LongStream, либо в DoubleStream
//              - LongStream только в DoubleStream
//              - DoubleStream назад не преобразовывается
                         DoubleStream doubleStream3 = IntStream.rangeClosed(1, 100)
                                                            .asLongStream()
                                                            .asDoubleStream();

//        toArray   - все примитивные стримы можно преобразовать в массив примитивов
                int[] ints       = IntStream.of(1, 2).toArray();                 // [1, 2]
                long[] longs     = LongStream.of(3, 4).toArray();                // [3, 4]
                double[] doubles = DoubleStream.of(5, 6).toArray();              // [5.0, 6.0]


    //====================================== операторы (методы) Stream =================================================
    /*  Операторы (методы) можно разделить на две группы:
            - промежуточные (“intermediate”, ещё называют “lazy”) — обрабатывают поступающие элементы и возвращают стрим
                            - промежуточных операторов в цепочке обработки элементов может быть много
            - терминальные (“terminal”, ещё называют “eager”) — обрабатывают элементы и завершают работу стрима.
                            - поэтому терминальный оператор в цепочке может быть только один
    */
        System.out.println("\n========= операторы (методы) Stream =========");
        Stream<String> stream = list.stream();
              stream.filter(x -> x.length() == 3)
                    .forEach(System.out::print);
            /*
                filter   — промежуточный оператор,
                           (выбирает у кого длина равна 3)
                                - x приравнивается к одному элементу коллекции для перебора (как при for each)
                                - после -> указываем как фильтруется наша коллекция
                                - так как это промежуточный оператор, отфильтрованная коллекция идет в метод for each
                for each — терминальный оператор,
                           (аналог перебора for each)
                           (System.out::println сокращенно от: x-> System.out.println(x))
                                - проходит по всем элементам отфильтрованной коллекции
                                - выводит данные в консоль
            */


        //----------------------------------------- ВАЖНЫЕ МОМЕНТЫ -----------------------------------------------------
        System.out.println("\n\n--------- ВАЖНЫЕ МОМЕНТЫ ---------");

        // Экземпляр, Stream нельзя переиспользовать (каждый раз нужно создавать новый)
                Stream<String> streams = list.stream();
                    streams.forEach(x -> System.out.print(x + "  "));
                //  streams.forEach(x -> System.out.println(x));                    // на 2-ом будет исключение

                System.out.println("\n");
                    streams = list.stream();                                        // так будет работать
                        streams.forEach(x -> System.out.print(x + "  "));
                        System.out.println();
                    streams = list.stream();
                        streams.forEach(x -> System.out.print(x + "  "));

                System.out.println("\n");
                    list.stream().forEach(x -> System.out.print(x + "  "));         // так тоже будет работать
                        System.out.println();
                    list.stream().forEach(x -> System.out.print(x + "  "));

                System.out.println("\n");                                           // так тоже будет работать
                    Supplier<Stream<String>> supplier = () -> list.stream();
                        supplier.get().forEach(s -> System.out.print(s + "  "));
                            System.out.println();
                        supplier.get().forEach(s -> System.out.print(s + "  "));


        // у Stream вертикальное  прохождение
                System.out.println("\n");
                    Stream.of("a","b","c").map(s -> {
                        System.out.println("Map " + s);                             // 1   4   7
                        return s.toLowerCase();
                    }).map (k -> {
                        System.out.println("Map2 " + k);                            // 2   5   8
                        return k.toUpperCase();
                    }).forEach(l -> System.out.println("forEach " + l));            // 3   6   9


        // в Stream (в т.ч. параллельном Stream) сортировка не смешивается с другими операторами
                System.out.println();
                Stream.of("a","b","c","d").parallel()
                        .sorted((s1, s2) -> {
                                System.out.println("sort" + s1  + "  "  + s2);
                                return s1.compareTo(s2);})
                        .map(s -> {
                                System.out.println("map -\t" + s + "\t" + Thread.currentThread().getName());
                                return s;})
                        .map (s -> {
                                System.out.println("map2 -\t" + s + "\t" + Thread.currentThread().getName());
                                return s;})
                        .forEach(s -> System.out.println(s));


        // в Stream очень ВАЖЕН порядок операторов
                    Stream.of("a","b","c").map(s -> {
                        return s.toUpperCase();                             // превратит в большие буквы, а - А
                    }).filter (k -> {
                        return k.equals("a");                               // фильтр не пропустит, так как нет совпадений
                    }).forEach(l -> System.out.println("forEach " + l));    // ничего не выведет в консоль


        // обработка не начинается до тех пор, пока не будет вызван Терминальный оператор
                System.out.println();
                    list.stream()
                            .filter(x -> x.length() == 3);                  // обработка не начнется

                    list.stream()
                            .filter(x -> x.length() == 3)
                            .forEach(System.out::print);                    // терминальный оператор


        // промежуточных операторов вызванных в одном Stream может быть множество, а терминальный только один
                System.out.println("\n");
                    list.stream()
                          .filter(x-> x.length() == 3)                                // промежуточный - lazy
                          .map(x -> x + " - the length of the letters is three")      // промежуточный - lazy
                          .forEach(x -> System.out.println(x));                       // терминальный  - eager


        // MethodReference
                System.out.println();
                System.out.println(Stream.of("one", "two").map(x -> x.toUpperCase()).findFirst());
                System.out.println(Stream.of("one", "two").map(String::toUpperCase).findFirst());      // упрощается код

                System.out.println();
                    Stream.of(new Car("Ford", 2010), new Car("Audi", 2015))
                       //   .map(x -> x.getNumber())
                            .map(Car::getNumber)                        // упрощается код
                            .forEach(x -> System.out.print(x + "   "));

                System.out.println("\n");
                    Stream.of("Jhon", "Andy")
                       //   .map( x -> new Car(x))
                            .map(Car::new)                              // упрощается код
                            .forEach(x -> System.out.print(x + "   "));



        //----------------------------------------- ПРОМЕЖУТОЧНЫЕ операторы  -------------------------------------------
        System.out.println("\n\n--------- ПРОМЕЖУТОЧНЫЕ операторы ---------");
            /* - filter (Predicate predicate)  - фильтрует стрим, пропуская только те элементы, что проходят по условию
                                - Predicate встроенный функциональный интерфейс, проверяет значение на true и false   */
                    list.stream().filter(x-> x.equals("One")).forEach(x -> System.out.println(x));

                    List<String> names = Arrays.asList("John", "Daenerys", "Tyrion", "", null, "Arya");
                            names.stream().filter(Objects::nonNull)                                    // не null
                                          .filter(name -> !name.isEmpty() && name.contains("a"))       // не пустое и a
                                          .forEach(x -> System.out.print(x + "   "));
                    System.out.println();


            /* - map (Function mapper)         - даёт возможность создать функцию с помощью которой изменяем каждый элемент
                                                 по заданному условию  и пропускаем его дальше
                                - Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R      */
                    list.stream().map(x -> x.toUpperCase()).limit(4).forEach(x -> System.out.print(x + "  "));

                    System.out.println();
                    Stream.of("john", "arya", "sansa").map(StringUtils::capitalize)
                                                      .forEach(x -> System.out.print(x + "  "));
                    System.out.println();


                    Stream.of(new Car("AA1111BX", 5), new Car("AM1111BE",5),
                              new Car("AK5555IT",5), new Car("AM1111BE",5))
                                    .map(Car::getNumber)
                                    .forEach(x -> System.out.print(x + "  "));
                    System.out.println();


                    Stream.of(new Car("AA1111BX", 2007), new Car("AK5555IT", 2010),
                              new Car(null, 2012), new Car("", 2015),
                              new Car("AI3838PP", 2017))
                                    .filter(s -> s.getYear() > 2010)
                                    .map(Car::getNumber)
                                    .filter(s -> s !=null && !s.isEmpty())
                                    .forEach(System.out::println);


        // - flatMap(Function<T, Stream<R>> mapper) — как и в случае с map, служит для преобразования в примитивный стрим

                    // при работе с массивом стримов (массивов, списков и так далее) преобразует их в один стрим
                    // (массив, список и так далее)        [stream1,stream2,stream3,stream4]  =>  stream
                        Arrays.stream(new String[]{"Java", "Ruuuuussshhh"})
                            .map(s->s.split(""))              // преобразование слова в массив букв
                            .flatMap(Arrays::stream)                 // выравнивает каждый сгенерированный поток в один поток
                            .distinct()
                            .collect(Collectors.toList())
                            .forEach(System.out::print);

                    System.out.println();
                        Stream.of(asList("one", "two"), asList("three", "four"))
                            .flatMap(x-> x.stream())
                            .forEach(x -> System.out.print(x + "  "));


                    System.out.println();
                    Stream.of(new Human("Sam", asList("Bud", "Luck")), new Human("Bob", asList("Fran", "Ros")),
                              new Human("Mar", asList("Sim", "Til")))
                    // вар 1        .map(Human::getPets)                    //  Stream<Human>    в Stream<List<Pet>
                    //              .flatMap(s -> s.stream())               //  Stream<List<Pet> в Stream<Pet>
                                    .flatMap(s -> s.getPets().stream())
                                    .forEach(x -> System.out.print(x + "  "));

                    System.out.println();
                    int[] array = Stream.of(new int[][]{{1,2}, {5,6,7}, {3,4}})
                               //   .flatMapToInt( s -> stream(s))
                                    .flatMapToInt(Arrays::stream)       // из Stream<int[]>   в  IntStream
                                    .sorted()                           // сортируем
                                    .toArray();                         // из IntStream в int[]
                    System.out.print(Arrays.toString(array));


                    // map преобразует в список потоков (точнее <Stream> потоков)
                    // [stream1,stream2,stream3,stream4] => Stream.of(stream1,stream2,stream3,stream4):
                    System.out.println("\n");
                        Arrays.stream(new String[]{"Stream", "Potok"})
                            .map(s->s.split(""))              // преобразование слова в массив букв
                            .map(Arrays::stream)                    //  сделать массив в отдельный поток
                            .distinct()
                            .collect(Collectors.toList())
                            .forEach(System.out::println);

                    /*     Еще отличие flatMap от map, что в flatMap можно преобразовать один элемент:
                                - в ноль,
                                - один или
                                - множество других
                            Чтобы преобразования один элемент в ноль элементов, нужно:
                                    - вернуть null                              flatMapToInt(x -> null)
                                    - либо пустой стрим.                        flatMapToInt(x -> IntStream.empty())
                            Чтобы преобразовать в один элемент, нужно:
                                    - вернуть стрим из одного элемента          flatMapToInt(x -> IntStream.of(x))
                            Для возвращения нескольких элементов, можно:
                                    - любыми способами создать стрим            flatMapToInt(x -> IntStream.range(0, x))
                                      с этими элементами
                            Тот же метод flatMap, но для Double, Integer и Long:
                                    - flatMapToDouble(Function mapper)
                                    - flatMapToInt(Function mapper)
                                    - flatMapToLong(Function mapper)
                    */

                    System.out.println();
                    // IntStream.range(0,x)     –   выдаёт на поток элементов с 0 (включительно) по x (не включительно)
                        Stream.of(2, 3, 0, 1, 3)
                            .flatMapToInt(x -> IntStream.range(0, x))
                            .forEach(System.out::print);            // 010120012
                                                                    // из 2 - 01, из 3- 012, из 0 - пусто, из 1 - 0, из 3- 012

                    System.out.println("\n");
                        Stream.of(2, 3, 0, 1, 3)
                            .map(x -> IntStream.range(0, x))
                            .forEach(System.out::println);                      //перечень стримов (потоков);


             // peek(Consumer<? super T> action)  - существует в основном для поддержки отладки, когда  нужно
             //                                     просмотреть элементы, когда они проходят через определенную точку в Stream
             //            peek         -  принимает входящий параметр, а возвращать значение не обязан
             //            map/filter   -  принимает входящий параметр, и обязан вернуть значение
                    System.out.println();
                    IntStream.of(2, 3, 0).peek(x -> System.out.print(x)).count();

                    System.out.println();
                    System.out.println(Stream.of("one", "two").peek(x -> x.toUpperCase()).findFirst().get());

             // distinct() – создает стрим уникальных элементов(убирает одинаковые элементы)
                    System.out.println();
                    Stream.of(2, 3, 0, 3, 3, 2, 1, 3).distinct().forEach(System.out::print);
                    System.out.println();

                    // нет смысла в distinct(), если в объекте не переопределен Equals & Hashcode
                    List<Car> car = Arrays.asList(new Car("Lor",12),new Car("Lor",12),
                                                    new Car("Lord",15));
                              car.stream().distinct().forEach(x -> System.out.print(x + " "));
                    System.out.println();

             // limit(long maxSize) – ограничивает стрим по количеству элементов (первые  maxSize элементы)
                    Stream.of(2, 3, 0, 1, 3).limit(3).forEach(System.out::print);
                    System.out.println();

                    // если указать значение limit() больше чем размер Stream - ограничение не будет применяться
                        Stream.of(2, 3, 0, 1, 3).limit(6).forEach(System.out::print);
                        System.out.println();

                    // если указать отрицательное значение limit(), то получим illegalArgumentException
                        // Stream.of(2, 3, 0, 1, 3).limit(-1).forEach(System.out::print);                 // exception

            // skip(long n) – пропускаем первые n элементов (указывает с какого элемента начинать работу)
                    Stream.of(2, 3, 0, 1, 3).skip(3).forEach(System.out::print);
                    System.out.println();

                    // если указать значение skip() больше чем размер Stream - получим пустой Stream
                    Stream.of(2).peek(x -> System.out.println("Пустой stream")).skip(6).forEach(System.out::println);

                    // если указать отрицательное значение skip(), то получим illegalArgumentException
                        // Stream.of(2, 3, 0, 1, 3).skip(-1).forEach(System.out::print);                 // exception

                    
            // sorted() – cортирует стрим по натуральному порядку
            // sorted(Comparator comparator) – сортирует стрим через comparator
                    Stream.of(2, 3, 0, 3, 3, 2, 1, 3).sorted().forEach(System.out::print);
                    System.out.println();

                    //  будет исключение, так как в классе не реализован Comparable
                    //       car.stream().sorted().forEach(System.out::println);         //java.lang.ClassCastException

                    car.stream()                                                        // cортировка по имени
                            .sorted(Comparator.comparing(Car::getNumber).reversed())    // в обратном порядке
                            .forEach(x -> System.out.print(x + " "));
                    System.out.println();


            // parallel()
            // parallelStream() - делает Stream параллельным
                    Stream.of(2, 3, 0, 3, 3, 2, 1, 3).parallel().count();
                    car.parallelStream().count();

                    System.out.println();
                    ForkJoinPool fork = ForkJoinPool.commonPool();
                    System.out.println(fork.getParallelism());    // кол - во задействованных ядер (1 в запасе всегда)

                    Stream.of("a","b","c","d")
                                    .parallel()
                                    .map(s -> {
                                            System.out.println("map -\t" + s + "\t" + Thread.currentThread().getName());
                                            return s;
                                    }).map (s -> {
                                            System.out.println("map2 -\t" + s + "\t" + Thread.currentThread().getName());
                                            return s;
                                    }).forEach(s -> System.out.println(s));
                    System.out.println();


            // sequential() - из параллельного Stream делает последовательный Stream
                    Stream.of(2, 3, 0, 3, 3, 2, 1, 3).parallel()
                                                     .sequential()
                                                     .count();

            /* для Java 9
                - dropWhile(Predicate predicate) — пропускает элементы которые удовлетворяют условию
                                                   (проверяет стрим, после того как условие false, дальше пропускает проверку)
                       Stream.of(2, 3, 0, 3, 3, 2, 1, 3).dropWhile ( x - > x < 3).forEach(System.out::print);

                - takeWhile(Predicate predicate) — пропускает элементы которые удовлетворяют условию
                                                   (проверяет стрим, после того как условие false, дальше не пропускает)
                       Stream.of(2, 3, 0, 3, 3, 2, 1, 3).takeWhile ( x - > x < 3).forEach(System.out::print);
            */



        //----------------------------------------- ТЕРМИНАЛЬНЫЕ операторы  --------------------------------------------
        System.out.println("\n--------- ТЕРМИНАЛЬНЫЕ операторы ---------");
            // forEach(Consumer action) – аналог for each

            // count() – возвращает количество элементов стрима
                    System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8).count());

            // sum() – возвращает cумму всех элементов
                    int intSum = IntStream.of(1, 2).sum();
                        System.out.println(intSum);                                 // 3
                    System.out.println(LongStream.of(3, 4).sum());                  // 7
                    System.out.println(DoubleStream.of(5, 6).sum());                // 11.0

            // average() – возвращает среднее значение, в виде OptionalDouble
                    OptionalDouble intAverage = IntStream.of(1, 2).average();
                        System.out.println(intAverage);                                     // OptionalDouble[1.5]
                    OptionalDouble longAverage = LongStream.of(3, 4).average();
                        System.out.println(longAverage);                                    // OptionalDouble[3.5]
                    OptionalDouble doubleAverage = DoubleStream.of(5, 6).average();
                        System.out.println(doubleAverage);                                  // OptionalDouble[5.5]
                    System.out.println();

            // collect(Collector collector) – метод собирает все элементы в список, множество или другую коллекцию,
            //                                сгруппировывает элементы по какому-нибудь критерию, объединяет всё в строку и тд

                   // некоторые методы Collectors:
                            //  toList() — собирает элементы в List (по умолчанию - ArrayList)
                                    List<String> lists = Stream.of("One", "Two", "Three").collect(Collectors.toList());
                                    System.out.println(lists);

                            //  toSet() — cобирает элементы в множество (по умолчанию - HashSet)
                                    Set<Integer> set = Stream.of(99, 2, 99, 3, 3).collect(Collectors.toSet());
                                    System.out.println(set);

                            //  toCollection(Supplier<C> collectionFactory) — принимает лямбда-выражение
                            //                  типа поставщика Supplier, которое должно вернуть коллекцию,
                            //                  в которую мы хотим сохранить данные
                                    Queue<String> queue = Stream.of("Jaime", "Daenerys", "", "Tyrion", "")
                                            .filter(n -> !n.isEmpty())
                                        //    .collect(Collectors.toCollection(() -> new LinkedList<>()));
                                            .collect(Collectors.toCollection(LinkedList::new));
                                    System.out.println(queue);

                                    Stream.of("one").collect(Collectors.toCollection(ArrayList::new));   //  в ArrayList
                                    Stream.of("one").collect(Collectors.toCollection(TreeSet::new));     //  в TreeSet


                            //  counting() — подсчитывает количество элементов
                                    System.out.println(Stream.of("1", "2", "3", "4").collect(Collectors.counting()));

                            //  maxBy / minBy  — максимальное / минимальное значение из Stream
                                    System.out.println(Stream.of("one","two")                                    // max
                                                .collect(Collectors.maxBy(Comparator.comparing( x -> x))));
                                    System.out.println(Stream.of(1,2,5)
                                                .collect(Collectors.maxBy(Comparator.comparing( x -> x))));

                                    System.out.println(Stream.of("one","two")
                                                .collect(Collectors.minBy(Comparator.comparing( x -> x))));      // min
                                    System.out.println(Stream.of(1,5,2)
                                                .collect(Collectors.minBy(Comparator.comparing( x -> x))));

                            //  averagingInt()  — cреднее значение из Stream
                                    System.out.println(Stream.of(1,2,3).collect(Collectors.averagingInt(x -> x)));

                            //  summingInt(ToIntFunction mapper)
                            //  summingLong(ToLongFunction mapper)
                            //  summingDouble(ToDoubleFunction mapper)
                            //       — коллектор, который преобразовывает объекты в int/long/double и подсчитывает сумму
                                    System.out.println(Stream.of(1, 2, 3, 4, 5).collect(Collectors.summingInt(x -> x)));

                            // partitioningBy() - сортирует на 2 группы(true/false) согласно заданного условия
                                    Map<Boolean, List<Integer>> map = Stream.of(1,2,3,4)
                                                                        .collect(Collectors.partitioningBy(x -> x > 2));
                                    System.out.println(map);

                            // groupingBy() - сортирует на 2 группы(true/false) согласно заданного условия
                                    Map<Integer, List<Integer>> map1 = Stream.of(1,2,1,4,1,1)
                                                                        .collect(Collectors.groupingBy(x -> x));
                                    System.out.println(map1);

                                    List<Human> humans = Arrays.asList(
                                            new Human("Ned", "STAK", 4),
                                            new Human("Robb", "STAK", 6),
                                            new Human("Aegon", "TARG", 3),
                                            new Human("Jaime", "LAN",5));

                                    Map<String, List<Human>> map2 = humans.stream()
                                                                    .collect(Collectors.groupingBy(Human::getSurName));
                                    System.out.println(map2);

                            // groupingBy() + counting()
                                    Map<Integer, Long> map3 = Stream.of(1,2,1,4,1,1)
                                                         .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
                                    System.out.println(map3);

                                    Map<String, Long> map4 = humans.stream()
                                              .collect(Collectors.groupingBy(Human::getSurName, Collectors.counting()));
                                    System.out.println(map4);

                            // groupingBy() + summingInt()
                                    Map<String, Integer> map5 = humans.stream()
                                       .collect(Collectors.groupingBy(Human::getSurName, Collectors.summingInt(Human::getFriends)));
                                    System.out.println(map5);

                            // groupingBy() + mapping
                                    Map<String, Set<String>> map6 = humans.stream()
                                            .collect(Collectors.groupingBy(Human::getSurName,          //группируем по фамилии
                                            Collectors.mapping(Human::getName, Collectors.toSet())));  // собираем имена в Set
                                    System.out.println(map6);


                            //  joining()
                            //  joining(CharSequence delimiter)
                            //  joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
                            //  — cобирает элементы в одну строку
                            //    дополнительно можно указать разделитель, а также префикс и суффикс для всей последовательности
                              System.out.println(Stream.of("s", "u" ,"p", "e", "r").collect(Collectors.joining()));
                              System.out.println(Stream.of("s", "u", "p", "e", "r")
                                                    .collect(Collectors.joining("-")));
                              System.out.println(Stream.of("s", "u", "p", "e", "r")
                                                     .collect(Collectors.joining(" , ", "[ ", " }")));
                              System.out.println(Stream.of(1,2)
                                                     .map(x -> x.toString(x))
                                                     .collect(Collectors.joining(",", "[", "}")));


            // collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
            //     — тот же, что и collect(collector), только параметры разбиты для удобства
            //          (supplier поставляет новые объекты (контейнеры), например new ArrayList(),
            //           accumulator добавляет элемент в контейнер,
            //           combiner объединяет части стрима воедино);


            // reduce(T identity, BinaryOperator accumulator) — преобразовывает все элементы стрима в один объект
            //       (посчитать сумму всех элементов, либо найти минимальный элемент),
            //              - cперва берётся объект identity и первый элемент стрима,
            //              - применяется функция accumulator и identity становится её результатом.
            //              - затем всё продолжается для остальных элементов
                System.out.println("\n" + Stream.of(1, 2, 3, 4).reduce(10, (acc, x) -> acc + x));         // 20

                System.out.println(Stream.of(1, 2, 3)
                        . reduce(10, (identity, val) -> identity * val, (left, right) -> left + right));  // 60

            // reduce(BinaryOperator accumulator) — такой же метод как и выше,
            //                                      но отсутствует начальный identity, им служит первый элемент стрима
                System.out.println(Stream.of(1, 2, 3, 4).reduce((acc, x) -> acc + x));                      // Optional[10]

                System.out.println(Stream.of(1, 2, 3, 4).reduce((acc, x) -> acc + x).get());                // 10

                System.out.println(Stream.of(2, 3, 5, 7)
                            //  . reduce((left, right) -> left < right ? left : right)
                                . reduce(Integer::min));                                                     // 2

                System.out.println(Stream.of("aaa", "bbb", "ccc", "ddd", "ffff")
                                .reduce((left, right) -> left.length() > right.length() ? left : right));    // ffff


            // Optional min(Comparator comparator)
            // Optional max(Comparator comparator)  - ищет min/max элемент, основываясь на переданном компараторе
                System.out.println(Stream.of(1, 2, 3, 4).min(Comparator.comparing(x -> x)));         // Optional[1]
                System.out.println(Stream.of(1, 2, 3, 4).min(Comparator.comparing(x -> x)).get());   // 1
                System.out.println(Stream.of(1, 2, 3, 4).max(Comparator.comparing(x -> x)));         // Optional[4]
                System.out.println(Stream.of(1, 2, 3, 4).max(Comparator.comparing(x -> x)).get());   // 4

            // findAny()   - вытаскивает первый попавшийся элемент, в виде обертки Optional
                System.out.println(Stream.of(33, 3, 3, 1).findAny().get());     // 33

                List<String> find = Arrays.asList("BLOB", "Java best", "Java 8", "Java 9", "Jac");
                    // для последовательных Stream результат будет всегда одинаковый
                        Optional<String> java = find.stream().filter(s -> s.contains("Java")).findAny();
                            System.out.println(java.get());
                    // для параллельных Stream результат будет всегда разный
                        System.out.println(find.parallelStream().filter(s -> s.contains("Java")).findAny().get());


            // findFirst() – вытаскивает первый элемент по порядку из Stream, в виде обертки Optional
                System.out.println(Stream.of(33, 3, 3, 1).findFirst().get());   // 33    без get  Optional[33]

                List<Integer> num = Arrays.asList(1, 5, 8, 10, 12, 15);
                    // для последовательных/параллельных Stream результат будет всегда одинаковый
                        System.out.println(num.stream().filter(s -> s > 10).findFirst().get());                 // 12
                        System.out.println(num.parallelStream().filter(s -> s > 10).findFirst().get());         // 12


            // allMatch(Predicate predicate) – возвращает true, если все элементы стрима удовлетворяют условию
            //                                         Если встречается какой-либо элемент, для которого результат вызова
            //                                    функции-предиката будет false, то оператор перестаёт просматривать элементы
            //                                    и возвращает false
                System.out.println(Stream.of(1, 2, 3, 4, 9).allMatch(x -> x <= 7));         // false
                System.out.println(Stream.of(1, 2, 3, 4, 5).allMatch(x -> x <= 7));         // true

            // anyMatch(Predicate predicate) — вернет true, если хотя бы один элемент стрима удовлетворяет условию predicate
                System.out.println(Stream.of(1, 2, 3, 4, 5).anyMatch(x -> x >= 7));         // false
                System.out.println(Stream.of(1, 2, 3, 4, 9).anyMatch(x -> x >= 7));         // true

            // noneMatch(Predicate predicate) — вернёт true, если, пройдя все элементы стрима, ни один не удовлетворил
            //                                  условию predicate
                System.out.println(Stream.of(1, 2, 3, 4, 9).noneMatch(x -> x >= 7));        // false
                System.out.println(Stream.of(1, 2, 3, 4, 5).noneMatch(x -> x >= 7));        // true


            // iterate(final T seed, final UnaryOperator<T> f)
            // concat(Stream<? extends T> a, Stream<? extends T> b) {
            // generate(Supplier<T> s)


    //-------------------------------------------- File / BufferedReader -----------------------------------------------
    System.out.println("\n--------- File / BufferedReader ---------");
        String path = "src\\B_readMe\\B27_Stream\\0_temp.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write("Привет, мой дорогой друг");
            bw.newLine();
            bw.write("Тестирую схему");
        }

        // lines() - Stream в классе Files
            List<String> lin = new ArrayList<>();
                try (Stream<String> lineStream = Files.lines(Paths.get(path))) {
                    lin = lineStream.collect(Collectors.toList());
                }
            System.out.println(lin);

        // lines() - Stream в классе BufferedReader
            lin = new ArrayList<>();
            try (Stream<String> lineStream = Files.newBufferedReader(Paths.get(path)).lines()) {
                lin = lineStream.collect(Collectors.toList());
            }
            System.out.println(lin);

        new File(path).delete();
    }
}

    class Car{
        String number;
        int year;

        public Car(String number, int year) {
            this.number = number;
            this.year = year;
        }

        public Car(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        public int getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "Car{" + "number='" + number + '\'' + '}';
        }
    }

    class Human{
        String name;
        String surName;
        int friends;
        List<String> pets;

        public Human(String name, List<String> pets) {
            this.name = name;
            this.pets = pets;
        }

        public Human(String name, String surName, int friends) {
            this.name = name;
            this.surName = surName;
            this.friends = friends;
        }

        public String getName() {
            return name;
        }

        public String getSurName() {
            return surName;
        }

        public int getFriends() {
            return friends;
        }

        public List<String> getPets() {
            return pets;
        }

        @Override
        public String toString() {
            return "Human{" + "name='" + name + '\'' + ", pets=" + pets + '}';
        }
    }