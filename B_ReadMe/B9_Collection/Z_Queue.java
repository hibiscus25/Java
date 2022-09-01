package B_ReadMe.B9_Collection;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Z_Queue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Queue<String> priority = new PriorityQueue<>(); //работает на основании массива, преимущество сортирует
        Queue<String> lock = new LinkedBlockingDeque<>(); //блокирующие очереди работают в многопоточном программировании
                                                            //есть размер очереди, если очередь занята, нельзя добавить элемент
                                                            // если освободилось место, можно добавить элемент

        Deque<String> deque = new LinkedList<>();

        Deque<String> array = new ArrayDeque<>();       //быстрее работает чем LinkedList, Stack

            array.add("a");
            array.add("c");
            array.add("b");
        System.out.println(array);

            priority.add("a");
            priority.add("c");
            priority.add("b");
        System.out.println(priority);       // не сортированный
            while (priority.size() != 0)
                System.out.print(priority.remove());      // cортированній
        System.out.println();
    }
}
