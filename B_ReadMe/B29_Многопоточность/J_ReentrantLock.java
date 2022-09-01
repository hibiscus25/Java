package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Res{
    int i = 5;
    int k = 5;

    Lock lock = new ReentrantLock();                // аналогия synchronized, но более гибкая

    void changeI(){
        lock.lock();                                                        // начало lock
            System.out.println(Thread.currentThread().getName() + "  - зашел поток в lock");
            int i = this.i;
            if (Thread.currentThread().getName().equals("Thread-7"))
                Thread.yield();
            this.i = ++i;
          changeK();
    }

    void changeK(){
            int k = this.k;
            if (Thread.currentThread().getName().equals("Thread-7"))
                Thread.yield();
            this.k = ++k;
            System.out.println(Thread.currentThread().getName() + "  - вышел поток из lock");
        lock.unlock();                                                      // конец lock
    }
}


public class J_ReentrantLock {
    static class MyThreed extends Thread {
        Res res;

        @Override
        public void run() {
            res.changeI();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Res res = new Res();

        MyThreed th = new MyThreed();
            th.setName("Thread-7");
            th.res = res;
        MyThreed th2 = new MyThreed();
            th2.res = res;

            th.start();
            th2.start();
                th.join();
                th2.join();

        System.out.println(res.i + "  " + res.k);
    }
}


