package B_ReadMe.B9_Collection;

import java.util.*;

public class CollectionExam {
    public static void main(String[] args) {
    //Пример 1:  перебор коллекции с помощью Iterator и For
    System.out.println("------ Пример 1 -------");
            List<String> states = new ArrayList<String>();
                states.add("Германия");
                states.add("Франция");
                states.add("Италия");
                states.add("Испания");

            Iterator<String> iter = states.iterator();
                while(iter.hasNext())
                    System.out.println(iter.next());
            System.out.println("--------------------------");

            for (String element : states)
                System.out.println(element);


    //Пример 2:  перебор коллекции с помощью ListIterator
    System.out.println("------ Пример 2 -------");
            ArrayList<String> states2 = new ArrayList<>();
                states2.add("Германия");
                states2.add("Франция");
                states2.add("Италия");
                states2.add("Испания");

            ListIterator<String> listIter = states.listIterator();
            while(listIter.hasNext())
                System.out.println(listIter.next());                    // выводим данные ArrayList по порядку
            System.out.println("--------------------------");

                listIter.set("Португалия");                             // меняем последний элемент

            while(listIter.hasPrevious())
                System.out.println(listIter.previous());                // выводим данные ArrayList в обратном порядке


    //Пример 3:  пример ArrayList
    System.out.println("------ Пример 3 -------");
            ArrayList <String> list = new ArrayList <>();
                list.add("Школа");
                list.add("Садик");
                list.add("Госпиталь");
                list.add("Больница");
                list.add(0,"новая Школа");
                    System.out.println(list.indexOf("Садик"));             // индекс элемента
                    System.out.println(list.contains("Садик"));            // наличие элемента
                    System.out.println (list.size());                      // размер списка
                    System.out.println (list.get(0));                      // значение элемента по номеру элемента
                list.set(0, "Персик");                                     // замена элемента по индексу элемента
                    System.out.println (list.get(0));
                list.remove(0);                                      // удаление элемента по индексу
                list.remove("Садик");                                   // удаление элемента по значению

                String[] array = list.toArray(new String[list.size()]);    // конвертация в массив
                    System.out.println(Arrays.deepToString(array));


    //Пример 4:  пример LinkedList
    System.out.println("------ Пример 4 -------");
            LinkedList<String> stat = new LinkedList<>();
                stat.add ("Германия");                                  // добавление элемента
                stat.add ("Франция");
                stat.addLast ("Великобритания");                    // добавляем элемент в конец
                stat.addFirst ("Испания");                          // добавляем элемент в первую позицию
                stat.add (1, "Италия");                  // добавляем элемент по индексу
                    System.out.println(states.size());                 // количество элементов в списке
                    System.out.println(states.get(1));                 // вывод 1 элемента списка
                stat.set(1, "Дания");                                  // замена 1 элемента списка

                    for (String els : stat)                           // перебор элементов
                        System.out.print(els + " ");
                    System.out.println();

                if (stat.contains("Германия"))                        // проверка на наличие элемента в списке
                    System.out.println("ОК");

                stat.remove("Германия");                           // удаление элемента
                stat.removeFirst();                                   // удаление первого элемента
                stat.removeLast();                                    // удаление последнего элемента


    //Пример 5:  пример HashSet
    System.out.println("------ Пример 5 -------");
            HashSet<String> hashSet = new HashSet<>();
                hashSet.add("Картофель");
                hashSet.add("Морковь");
                hashSet.add("Свекла");
                hashSet.add("Огурцы");
                hashSet.add("Картофель");                            // не должна попасть в набор, так как такая уже есть
                    System.out.println(hashSet.size());              // размер набора данных

                    Iterator<String> itr = hashSet.iterator();
                        while (itr.hasNext())
                            System.out.println(itr.next());          // выводит 4 записи вместо 5


    //Пример 6:  пример HashSet с целочисленными значениями
        // в набор добавляем значения от 0 до 9 из 25 возможных случайным образом выбранных значений - дублирования не будет
    System.out.println("------ Пример 6 -------");
            Random random = new Random(25);
            Set<Integer> iset = new HashSet<Integer>();
                for(int i = 0; i < 25; i++)
                    iset.add(random.nextInt(10));

                Iterator<Integer> it = iset.iterator();
                while (it.hasNext())
                    System.out.println(it.next());


    //Пример 7:  пример TreeSet
    System.out.println("------ Пример 7 -------");
            Set<String> treeSet = new TreeSet<>();              // аналог -  SortedSet<String> treeSet = new TreeSet<>()
                treeSet.add("Свекла");
                treeSet.add("Огурцы");
                treeSet.add("Помидоры");
                treeSet.add("Картофель");
                treeSet.add("Морковь");
                treeSet.add("Картофель");                           // данная запись не попадает в набор
                    System.out.println(treeSet.size());             // размер набора данных

                    for(String el : treeSet)
                        System.out.print(el + " ");
                    System.out.println();


    //Пример 8:  пример TreeSet c целочисленными значениями
    System.out.println("------ Пример 8 -------");
            Random randoms = new Random(30);
            Set<Integer> isa = new TreeSet<>();                   // аналог -  SortedSet<Integer> isa = new TreeSet<>();
                for(int i = 0; i < 25; i++)
                    isa.add(randoms.nextInt(10));

                    for(Integer el : isa)
                        System.out.print(el + " ");
                    System.out.println();


    //Пример 9:  пример Hashtable (телефонный справочник, содержащий имена и телефоны)
            //  используем механизм хеш-таблиц для эффективного поиска записей по ключу
    System.out.println("------ Пример 9 -------");
            Hashtable phoneBook = new Hashtable();
                phoneBook.put("Оксана Л.", "(926) 111-222-333");                // добавление записей в справочник
                phoneBook.put("Сергей М.", "(929) 333-222-111");
                phoneBook.put("Петр Ж."  , "(915) 333-111-222");
                phoneBook.put("Михаил Н.", "(926) 222-333-111");

            // для чтения списка ключей используется метод keys класса Hashtable, который возвращает объект класса Enumeration
            Enumeration keys = phoneBook.keys();                                // Список ключей
                while (keys.hasMoreElements()) {
                    String user  = (String) keys.nextElement();
                    String value = (String) phoneBook.get(user);
                    System.out.println("key (user) = " + user + ", value (phone) = " + value);
                }


    //Пример 10:  HashMap
    System.out.println("------ Пример 10 -------");
            Map<String, String> map = new HashMap<>();
                map.put("key1", "value1");
                    map.put("key1", "value11");             // не добавит т.к. такой ключ есть
                    if (map.get("key1") == null)            // поэтому правильно проверять наличие ключа, а потом добавлять
                        map.put("key1", "value11");
                                 // putIfAbsent - проверяет наличие ключа и если есть, игнорирует добавление
                    map.putIfAbsent("key1", "value111");
                                            //  если нет, добавляет ключ - значение
                    map.putIfAbsent("key2", "value2");

                map.put("key3", "value3");
                                // computeIfPresent - проверяет наличие ключа, если есть совершает действие и сохраняет
                    map.computeIfPresent("key3", (key, value) -> key + "; " + value);
                                            //  если нет ничего не делает
                    map.computeIfPresent("key6", (key, value) -> key + "; " + value);

                map.put("key4", "value4");
                                // computeIfPresent - проверяет наличие ключа, если нет совершает действие и сохраняет
                    map.computeIfAbsent("key5", key -> key + " || " + "AMAZ");
                                            //  если есть ничего не делает
                    map.computeIfAbsent("key4", key -> key + " || " + "AMAZ");

                map.put("key7", "value7");
                                // merge() - объединяет значение в Map c другим, если ключ ест соединяет
                    map.merge("key7", " + Blabla", (oldVal, newVal) -> oldVal + newVal);
                                            //  если такой пары (ключ - значение) - будет создана
                    map.merge("key8", " + Blabla", (oldVal, newVal) -> oldVal + newVal);
            System.out.println(map);


                // getOrDefault() - возвращает значение по умолчанию, если ключ есть - возвращает его значение
            System.out.println(map.getOrDefault("key2", ""));
                                                                  //  если ключа нет - возвращает значение по умолчанию
            System.out.println(map.getOrDefault("key15", "значение по умолчанию"));


            Map<String, String> map2 = new HashMap<>();
                map2.put("key9", "value9");
                map2.put("key10", "value10");
                map2.put("key11", "value11");
                map2.put("key12", "value12");


                map.putAll(map2);                                       // добавление набора данных
                map.remove("key9");                                // удаление объекта по ключу
                map.remove("key10", "value12");                             // по ключу и не верному значению - не удалит
                map.remove("key10", "value10");                             // по ключу и верному значению    - удалит
                    System.out.println(map.size());                     // размер набора

            String exists = (map.containsKey("key2")) ?  "найден" : "не найден";  // поиск по ключу
                    System.out.println("Объект с ключом 'key2' " + exists);

            exists = (map.containsValue("value2")) ? "найден" : "не найден";      // поиск по значению
                    System.out.println("Объект со значением 'value2' " + exists);

            Set<Map.Entry<String, String>> set = map.entrySet();                  // перебор значений
                for (Map.Entry<String, String> me : set)
                    System.out.print("ключ : " + me.getKey() + ", значение = " + me.getValue() + " | ");
                System.out.println();
            map.clear();                                                          // очистка объекта


        //Пример 11:  LinkedHashMap
    System.out.println("------ Пример 11 -------");
        Map<String, Double> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("Apple", new Double(91.98));
            linkedHashMap.put("Sony" , new Double(16.76));
            linkedHashMap.put("Dell" , new Double(30.47));
            linkedHashMap.put("HP"   , new Double(33.91));
            linkedHashMap.put("IBM"  , new Double(181.71));
                System.out.println("Содержимое : " + linkedHashMap);

                System.out.println("Значения записей : ");
                for (String key : linkedHashMap.keySet())
                    System.out.println(key + ":\t" + linkedHashMap.get(key));

            System.out.println("Значение цены IBM : " +  linkedHashMap.get("IBM"));     // получение значения цены IBM по ключу
            System.out .println(linkedHashMap.size());                                  // размер linkedHashMap
            System.out.println(linkedHashMap.isEmpty());                                // наличие записей
            System.out.println(linkedHashMap.containsKey("Sony"));                      // наличие записей по значению ключа
            System.out.println(linkedHashMap.containsValue(999.0));                     // наличие записей в значении по значению
            System.out.println(linkedHashMap.remove("Dell"));                      // удаление записи Dell
                linkedHashMap.clear();                                                  // очистка набора данных


    //Пример 12:  TreeMap
    System.out.println("------ Пример 12 -------");
        TreeMap <Integer, String> maps = new TreeMap<>();
            maps.put(1, "Понедельник");
            maps.put(2, "Вторник");
            maps.put(3, "Среда");
            maps.put(4, "Четверг");
            maps.put(5, "Пятница");
            maps.put(6, "Суббота");
            maps.put(7, "Воскресенье");
                System.out.println("Ключи : " + maps.keySet());                     // все ключи
                System.out.println("Значения : " + maps.values());                  // все значения
                System.out.println("Ключ = 3, значение = " + maps.get(3));          // пятое значение
                System.out.println(maps.firstKey() + maps.get(maps.firstKey()));    // первый ключ и его значение
                System.out.println(maps.lastKey() + maps.get(maps.lastKey()));      // последний ключ и значение
                System.out.println(maps.remove(maps.firstKey()));                   // удаляем первый ключ и значение
                System.out.println("Ключи : " + maps.keySet());
                System.out.println("Значения : " + maps.values());
                System.out.println(maps.remove(maps.lastKey()));                    // удаляем последний ключ и значение
                System.out.println("Ключи : " + maps.keySet());
                System.out.println("Значения : " + maps.values());


    //Пример 13:  TreeMap с Comparator
    System.out.println("------ Пример 13 -------");
        new SortedTreeMap();
    }
}
    class SortedTreeMap implements Comparator<Object>{
        private TreeMap<String, String> tm = new TreeMap<>();

        public SortedTreeMap(){
            tm.put("33", "book");
            tm.put("11", "art");
            tm.put("22", "cook");
            tm.put("24", "dog");
            tm.put("31", "cool");
            tm.put("14", "rest");
            tm.put("12", "lost");
            tm.put("11", "value");

            TreeMap<String, String> tm1 = new TreeMap<>();
                tm1.putAll (tm);

            Iterator<Map.Entry<String, String>> it = tm1.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, String> me = it.next();
                    System.out.println(me.getKey() + "  " + me.getValue());
                }
        }

        public int compare( Object o1, Object o2 ){
            return tm.get(o1).compareTo(tm.get(o2));
        }
    }