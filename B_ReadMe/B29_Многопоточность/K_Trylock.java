package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class K_Trylock {
    static Lock lock = new ReentrantLock();

    static class Thread1 extends Thread{
        @Override
        public void run(){
            lock.lock();
                System.out.println(getName() + "  - зашел в lock - уснул на 25 мс");
                try{
                    sleep(50);
                } catch (InterruptedException e) {}
                System.out.println(getName() + "  - вышел из lock");
            lock.unlock();
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run(){
            System.out.println(getName() + "  - зашел в run()");
            while(true) {
                if (lock.tryLock()) {                       // проверяет открытый lock, если нет, выполняет другую работу
                    try {                                                   // без try /finally
                        System.out.println(getName() + "  - WORKING");      // если поток 2 первый начинает
                        break;                                              // будем ловить  deadLock
                    } finally {                                             // т.к.  поток 2 при выполнении метода
                        lock.unlock();                                      // выставляет cвой lock, но не снимает
                    }
                } else {
                    System.out.println("     - " + getName() + "  - проверяет есть lock    -  waiting");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
            Thread.sleep(20);
        new Thread2().start();
    }
}
