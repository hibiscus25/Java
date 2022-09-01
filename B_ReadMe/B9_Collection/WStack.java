package B_ReadMe.B9_Collection;

import java.util.*;


public class WStack {
    public static void main(String[] args) {
        // Stack - добавляем в конец, берем с конца
            // push     -   добавляем элемент
            // peek     -   возвращает последний элемент
            // pop      -   возвращает последний элемент и удаляет его
        Stack<String> st = new Stack<>();
            st.add("one");
            st.push("two");
            st.push("three");
                for (String s : st)
                    System.out.print(s + "    ");

        System.out.println("\n");
        System.out.println("First peek  " + st.peek());
        System.out.println("Second peek  " + st.peek());

        System.out.println();
        System.out.println("First pop  " + st.pop());
        System.out.println("Second pop  " + st.pop());
            for (String s : st)
                System.out.print(s + "    ");
        System.out.println();
        System.out.println("-----------------------------------");


        // Queue - добавляем в конец, берем сначала
            // offer/add      -   добавляем элемент
            // peek           -   достает первый элемент
            // poll/remove    -   достает первый элемент и удаляет его
        Queue<String> queue = new PriorityQueue<>();    // сразу сортирует по натуральному порядку
            queue.add("one");
            queue.add("two");
            queue.offer("three");
            queue.offer("four");
                for (String s : queue)
                    System.out.println(s);

            System.out.println();
            System.out.println("Peek1:  " + queue.peek());
            System.out.println("Peek2:  " + queue.peek());
            for (String s : queue)
                System.out.println(s);
                
            System.out.println();
            System.out.println("Pool:  " + queue.poll());
            System.out.println("Remove:  " + queue.remove());
                for (String s : queue)
                    System.out.println(s);
            System.out.println("-----------------------------------");


        // Deque - двунаправленная очередь (можем получать доступ как к первому, так и к последнему элементу)
            //   -  new ArrayDeque<>()    и  new LinkedList<>()
                // offer  /add          -   добавляем элемент по очереди
                //                               - addFirst/offerFirst      - добавляет в начало очереди
                //                               - addLast/offerLast        - добавляет в конец очереди
                // push                  -   добавляет элемент в начало очереди
                // peek / element        -   достает первый элемент
                //                               - peekFirst/getFirst       - достает первый элемент
                //                               - peekLast/getLast         - достает первый элемент
                // poll / pop / remove   -   достает первый элемент и удаляет его
                //                               - pollFirst/removeFirst    - достает первый элемент и удаляет его
                //                               - pollLast/removeLast      - достает последний элемент и удаляет его
        Deque<String> deque = new ArrayDeque<>();
        Deque<String> deque2 = new LinkedList<>();
             deque.add("one");
             deque.addLast("two");
             deque.addFirst("zero+");
             deque.offer("three");
             deque.offerLast("four");
             deque.offerFirst("zero");
             deque.push("end");
                for (String s : deque)
                    System.out.print(s + "    ");

             System.out.println("\n");
             System.out.println("Peek:  " + deque.peek());
             System.out.println("Element:  " + deque.element());
             System.out.println("Peek First:  " + deque.peekFirst());
             System.out.println("Peek Last:  " + deque.peekLast());
             System.out.println("Get First: " + deque.getFirst());
             System.out.println("Get last: " + deque.getLast());
                for (String s : deque)
                    System.out.print(s + "    ");

            System.out.println("\n");
            System.out.println("Remove: " + deque.remove());
            System.out.println("Poll: " + deque.poll());
            System.out.println("Pop: " + deque.pop());
            System.out.println("Remove First: " + deque.removeFirst());
            System.out.println("Pool First: " + deque.pollFirst());
            System.out.println("Remove Last: " + deque.removeLast());
            System.out.println("Pool Last: " + deque.pollLast());
            if(deque.size() == 0)
                System.out.print(" - Удалили все элементы");
    }
}
