package B_ReadMe.B9_Collection;

import java.util.*;

public class Z_Maps {
    public static void main(String[] args) {
    // имплементации Map - есть еще конкурентная Map
        Map<String, String> map = new HashMap<>();              // складывает по хэш
        Map<String, String> link = new LinkedHashMap<>();       // запоминает порядок
        Map<String, String> tree = new TreeMap<>();             // отсортированный
        Map<String, String> table = new Hashtable<>();          // то же HashMap но все синхронизированно
        Map<String, String> sync = Collections.synchronizedMap(new HashMap<>());    // может сделать синхронизированным

    //  ширина  - HashMap - 16  изначально, мах  2 в 30 степени (выше Int нельзя)

    // loadFactor - в одну и ту же ячейку hash будут складываться много элементов  = 0.75 по умолчанию
        // как только будет заполниться 75 % она перехишурется станет 32, опять заполнилось ещ на 64
        // для уменьшения коллизий при складывании в одну ячеку по hash
        // они происходят, так как складываются по формуле - остаток от деления hash на 16

    // как увеличилась производительность на 8 джава
    //  из линкед листа превращается в красное - черное дерево, поєтому увеличивается производительность

    // может ли HashMap становиться меньше
        // скорее всего не будет

    // NavigateMap - позволяет получить teil, headMap
        TreeMap<String, String> maps = new TreeMap<>();
            maps.put("a","1");
            maps.put("b","2");
            maps.put("c","3");
            maps.put("d","4");
            maps.put("e","3");
            maps.put("f","3");
        System.out.println(maps.subMap("a","c"));       // a - включительно, с - не включительно
        System.out.println(maps.subMap("d","f"));       // d - включительно, f - не включительно

        System.out.println(maps.subMap("a","c").firstKey());  // a
        System.out.println(maps.subMap("a","c").lastKey());   // b


        System.out.println(maps.tailMap("c"));                  // c - включительно  и до конца
        System.out.println(maps.tailMap("c").firstKey());       // c
        System.out.println(maps.tailMap("c").lastKey());        // f
        System.out.println(maps.headMap("c"));   // cначало и до с - не включительно
        System.out.println(maps.headMap("c").firstKey());       // a
        System.out.println(maps.headMap("c").lastKey());        // b


    // что занимает больше места HashMap или treemap
        // больше HashMap, т.к. изначально создает количество ячеек (в которых минимум 25 % - при 0.75, забито пустыми элементами)
        // TreeMap постепенно добавляет каждый объект





    }
}
