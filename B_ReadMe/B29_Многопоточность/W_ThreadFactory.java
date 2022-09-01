package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.ThreadFactory;

public class W_ThreadFactory {
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getPriority());
        }
    }

    static class MyRun2 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getPriority());
        }
    }


    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {     // используется, чтобы настроить многие потоки по аналогии
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                    thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        threadFactory.newThread(new MyRun()).start();
        threadFactory.newThread(new MyRun2()).start();
    }
}
