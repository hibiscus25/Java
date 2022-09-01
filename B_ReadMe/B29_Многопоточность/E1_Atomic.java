package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.atomic.AtomicInteger;

/*      Атомарные операции — это операции, которые нельзя разделить.
            - например:
                    - операция присваивания значения переменной - атомарная
                    - инкремент - не атомарная операция, т.к. для инкремента требуется:
                                        - получить старое значение
                                        - прибавить к нему единицу
                                        - сохранить значение
*/

public class E1_Atomic {
    public static int value = 0;
    public static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                value++;
                atomic.incrementAndGet();
            }
        };

        for (int i = 0; i < 3; i++)
            new Thread(task).start();

        Thread.sleep(300);
        System.out.println(value);
        System.out.println(atomic.get());
    }
}
