package B_ReadMe.B27_Stream;

import java.util.Optional;

public class A_Optional {
    public static void main(String[] args) {
        /*  Optional - новый класс в пакете java.util, является контейнером (оберткой) для значений
                       которая также может безопасно содержать null.
            Благодаря опциональным типам можно забыть про проверки на null и NullPointerException.
        */

    //----------------------------------------- Optional Basics --------------------------------------------------------
        // Для создания Optional используются методы:
        //   - Optional.of
                        Optional<String> name = Optional.of("John");
                        System.out.println(name);                                      // Optional[John]
        //        в метод Optional.of нельзя передавать null так как будет  -  NullPointerException
        //              System.out.println(Optional.of(null));                         // java.lang.NullPointerException

        //   - Optional.ofNullable
                        System.out.println(Optional.ofNullable("ofNullable"));         // Optional[Jack]
        //        в метод Optional.ofNullable  можно  передавать null
                        System.out.println(Optional.ofNullable(null));                 // Optional.empty

        //   - Optional.empty       для создания пустого Optional
                        System.out.println(Optional.empty());                          // Optional.empty

        //   для получения значения из Optional используется:
        //      - Optional.get, но он является небезопасным и может бросить NoSuchElementException
                        System.out.println(Optional.of("Optional.get").get());         // Optional.get
        //              System.out.println(Optional.ofNullable(null).get());           // java.util.NoSuchElementException:



        //----------------------------------- Optional isPresent/ifPresent ---------------------------------------------
        System.out.println("--------------------------");
        //  - Optional.isPresent    -   возвращает true, если значение в нем присутствует, иначе возвращает false
                        name = Optional.of("isPresent");
                        if (name.isPresent())
                            System.out.println(name.get());                            // isPresent

                        Optional<Object> empty = Optional.empty();
                        if (empty.isPresent())                                         // исключения не будет
                                System.out.println(empty.get());
        //                  P.S:  Optional.get лучше использовать в паре с Optional.isPresent, чтобы предотвратить исключения

        //  - Optional ifPresent    -   выполняет переданное действие, если значение в Optional присутствует, иначе игнорирует его
        //                              Метод принимает лямбда-выражение известное как потребитель (Consumer)

                        name = Optional.of("ifPresent");
                        name.ifPresent(val -> System.out.println(val));                 // условие true - ifPresent

                        empty = Optional.empty();
                        empty.ifPresent(val -> System.out.println(val));                // условие false - действие игнорируется



        //------------------------------------------- Optional orElse --------------------------------------------------
        System.out.println("--------------------------");
        //  - Optional.orElse       -       возвращает переданное значение, если Optional пустой
                        name = Optional.of("orElse");
                        System.out.println(name.orElse("blank"));                 // orElse

                        System.out.println(empty.orElse("blank2"));               // blank

        //  - Optional.orElseGet    -       возвращает переданное значение из лямбда-выражение, если Optional пустой
                        name = Optional.of("orElseGet");
                        System.out.println(name.orElseGet(() -> "blank3"));             // orElseGet

                        System.out.println(empty.orElseGet(() -> "blank4"));            // blank4

        //  - Optional.orElseThrow  -       бросает переданное исключение , если Optional пустой
                        name = Optional.of("orElseThrow");
                        System.out.println(name.orElseThrow(() -> new RuntimeException()));   // orElseThrow

        //              empty.orElseThrow(() -> new RuntimeException());                      // java.lang.RuntimeException



        //----------------------------------------- Optional map/flatMap -----------------------------------------------
        System.out.println("--------------------------");
        //  - Optional.map      -   служит для преобразования значения внутри Optional.
        //                          Если Optional пустой преобразование не будет происходить
                        name = Optional.of("MAP");
                        System.out.println(name.map(String::toLowerCase));          // Optional[map]

                        Optional<String> emptys = Optional.empty();
                        System.out.println(emptys.map(String::toLowerCase));        // Optional.empty

        //  - Optional.flatMap  -   преобразовывает значение внутри Optional, но при этом не оборачивает их
        //                          Если Optional пустой преобразование не будет происходить
                        Optional<Optional<String>> nam = Optional.of(Optional.of("FLATMAP"));
                        System.out.println(nam.flatMap(o -> o.map(String::toLowerCase)));       // Optional[flatmap]

                        Optional<Optional<String>> em = Optional.of(Optional.empty());
                        System.out.println(em.flatMap(o -> o.map(String::toLowerCase)));        // Optional.empty






    }

}

//    Согласно Oracle, объект Optional — это “объект-контейнер, который может содержать или не содержать значение non-null”.
//    Optional впервые появился в Java 8 и использовался командой SpringBoot во многих проектах.
//
//        Чаще всего Optionals используется в проекте Spring Data. Давайте посмотрим на интерфейс JpaRepository и пример метода.
//
//        Например, у нас есть объект User с целочисленным типом Id и для него есть JpaRepository.
//
//@Repository
//public interface IUserRepo extends JpaRepository<User, Integer>
//{
//    Optional<User> findByUserName(String userName);
//}
//
//    Мы определили метод, который ищет пользователя по его имени и возвращает Optional для User.
//        Удобные методы Optional
//        Optional входит в множество методов, которые позволяют нам писать чистый и читаемый код.
//        map(..).or(...)
//        map(...).orElse(...)
//        полный список можно найти в документации Oracle.
//        Однако есть один метод с опасно неожиданным поведением.
//        Познакомьтесь с методом orElse
//        Согласно документации Oracle:
//
//public T orElse(T other)
//
//        Верните значение, если оно есть, в противном случае верните другое.
//
//        Теперь мы можем добавить вызов метода в качестве параметра orElse, который будет запущен, если параметр Optional пуст,
//        верно?
//
//        Да, это правильно, но что, если я скажу вам, что оно будет работать в любом случае,
//        независимо от наличия значения в Optional или нет.
//
//        Давайте проверим:
//
//@Test
//public void orElseTest()
//        {
//        String result = Optional.of("hello").orElse(someMethod());
//        assertThat(result).isEqualTo("hello");
//        }
//private String someMethod()
//        {
//        System.out.println("I am running !!");
//        return "hola";
//        }
//
//        Тест прошел успешно, но можно заметить, что на консоли распечатана строка “I am running”.
//        Почему так происходит?
//        Java запускает метод, чтобы предоставить значение, которое будет возвращено в случае Else.
//        Так что будьте осторожны!
//        Нужно быть осторожным, если метод внутри orElse может иметь побочный эффект, потому что он все равно будет запущен.
//        Что же делать?
//        Вы можете использовать метод OrElseGet, который принимает метод поставщика (supplier method) для выполнения, если существует Optional.
//        Как отображать и суммировать элементы из списка в Java
//        Источник: DZone
//
//        В этой публикации вы узнаете, как из списка в Java отобразить и суммировать количество элементов. Отображение элементов из списка (List) означает, что каждый элемент из этого списка будет преобразован в другой объект. Суммирование элементов из списка означает, что все элементы из этого списка будут объединены в один объект, который не обязательно имеет тот же тип, что и исходный.
//
//        Допустим, у нас есть список заказов, и в каждом заказе есть список продуктов.
//
//record Order(String customer, List<Product> products) {
//}
//
//record Product(String brand, String modelName, BigDecimal price) {
//}
//
//    Что бы вы сделали, если бы требовалось узнать, сколько денег поступает из списка заказов?
//
//        Для каждого заказа вам нужно будет получить список присутствующих в нем продуктов, а для каждого продукта в этих списках нужно получить его стоимость. После этого вам требуется суммировать все эти цены, и так вы получите результат.
//
//        При переводе приведенного выше на Map / Reduce вам необходимо:
//        Сопоставить каждый заказ со списком продуктов.
//        Отобразить для каждого продукта его цену.
//        Суммировать все цены, сложив их друг с другом.
//        Итак, сделаем это на Java:
//
//public class OrderMapReducer {
//    public BigDecimal getTotal(List<Order> orders) {
//        return orders.stream() // 1
//                .map(Order::products) // 2
//                .flatMap(List::stream) // 3
//                .map(Product::price) // 4
//                .reduce(BigDecimal::add) // 5
//                .orElse(BigDecimal.ZERO); // 6
//    }
//}
//    Создаем поток заказов.
//        Сопоставляем каждый заказ с его списком продуктов.
//        Сопоставляем каждый список продуктов с потоком. Обратите внимание, что здесь нам пришлось использовать flatMap, иначе мы получим Stream <Stream <Product>>.
//        Отображаем для каждого продукта его цену.
//        Суммируем все цены.
//        Если список заказов (Order List) пуст, возвращаем zero.
//        Вот и все! Теперь мы можем создать тест, чтобы убедиться, что все работает должным образом.
//
//@Test
//void getTotalPrice() {
//        List<Order> orders = createOrders();
//        OrderMapReducer orderMapReducer = new OrderMapReducer();
//        assertEquals(new BigDecimal(17800), orderMapReducer.getTotal(orders));
//        }
//
//private static List<Order> createOrders() {
//        var strato = new Product("Fender", "Stratocaster", new BigDecimal(3500));
//        var sg = new Product("Gibson", "SG", new BigDecimal(4800));
//        var lesPaul = new Product("Gibson", "Les Paul", new BigDecimal(4500));
//        var rr = new Product("Jackson", "RR", new BigDecimal(5000));
//
//        return List.of(
//        new Order("David Gilmour", List.of(strato)),
//        new Order("Toni Iommi", List.of(sg)),
//        new Order("Randy Rhoads", List.of(lesPaul, rr))
//        );
//        }
//
//        Как видите, сопоставление и суммирование (Map and Reduce) помогает в тех случаях,
//        когда вам нужно извлечь информацию из Collection.
