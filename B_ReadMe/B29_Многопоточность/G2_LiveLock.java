package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*      Livelock заключается в том, что потоки внешне как бы живут, но при этом не могут ничего сделать,
    т.к. условие, по которым они пытаются продолжить свою работу, не могут выполниться.
        По сути Livelock похож на deadlock, но только потоки не "зависают" на системном ожидании монитора,
    а вечно что-то делают

        В примере:
            если первым запустится Thead-1, то мы получим Livelock:
                  - оба потока поочередно пытаются захватить оба lock, но им это не удается
                  - при этом они не в deadlock, то есть визуально с ними всё хорошо и они выполняют свою работу.
*/

public class G2_LiveLock {
        public static final String RED = "\u001B[31m";
        public static final String BLUE = "\u001B[34m";
        public static final String GREEN = "\u001B[32m";

        public static void log(String text) {
            String name = Thread.currentThread().getName();
            String color = RED;

            int val = Integer.valueOf(name.substring(name.lastIndexOf("-") + 1)) + 1;   //номер потока  + 1
            if (val <= 1)
                color = BLUE;
            System.out.println(color + name + ": " + text );

            try {
                System.out.println(color + name + ": wait for " + val + " sec");
                Thread.currentThread().sleep(val * 1000);
            } catch (InterruptedException e) {}
        }


    public static void main(String[] args) {
        Lock first = new ReentrantLock();                               // 1-й lock
        Lock second = new ReentrantLock();                              // 2-й lock

        Runnable locker = () -> {
            boolean firstLocked = false;
            boolean secondLocked = false;
            try {
                while (!firstLocked || !secondLocked) {
                    System.out.println(GREEN + Thread.currentThread().getName());
                        firstLocked = first.tryLock(100, TimeUnit.MILLISECONDS);   // проверяет есть lock
                            log("First Locked: " + firstLocked);
                        secondLocked = second.tryLock(100, TimeUnit.MILLISECONDS);
                            log("Second Locked: " + secondLocked);
                }
                first.unlock();
                second.unlock();
            } catch (InterruptedException e) {}
        };

        new Thread(locker).start();
        new Thread(locker).start();
    }
}
