package B_ReadMe.B9_Collection;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Z_CouncurrencyPackage {
    public static void main(String[] args) {
        // не блочат все методы, блочат только запись - выигрывается в производительности

        List<String> list = new CopyOnWriteArrayList<>();  // такой же как и ArrayList, но потокобезопасный
        // добавление будет занимать больше времени, чем в простом листе
        // на запись есть lock
        // на get нет lock

        Set<String> set = new CopyOnWriteArraySet<>();      // такой же как и Set, но потокобезопасный
        // работает на основе CopyOnWriteArrayList

        new ConcurrentHashMap<>();


    }
}
