package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.*;

/*   пул потоков Java
        - когда программа создает большое количество потоков,
          чтобы задать необходимое кол-во создаваемых потоков используется пул потоков,
          который не создает потоки заново, а повторно используется несколько раз
*/

public class N_Executors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    //   Executor executor;                     // меньше возможностей
    //   ExecutorService executorService;       // более расширенный интерфейс (extends Executor)

    ExecutorService execut = Executors.newSingleThreadExecutor();                   // cоздаст один поток
                    execut = Executors.newFixedThreadPool(20);             // создаст заданное кол-во потоков
    //              execut = Executors.newCachedThreadPool(ThreadFactory threadFactory);
                        // получает фабрику потоков (не фиксированное кол - во потоков),
                        // которая создает потоки по необходимости,
                        // есть задержка 60 секунд, если поток не используется за это время  он умирает
                        // если поток приходит в течение 60 сек его можно переиспользовать

                    execut = Executors.newFixedThreadPool(2);
                                execut.submit(new MyRunable());
                                System.out.println(execut.submit(new MyCallab()).get());
                    execut.shutdown();         // завершает пул потоков и  ждет выполнение методов
                //  ex.shutdownNow();          // завершает пул потоков, но НЕ ждет выполнение методов
    }


    static class MyRunable implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }


    static class MyCallab implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
