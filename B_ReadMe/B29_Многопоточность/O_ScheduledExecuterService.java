package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


// выполнение потоков по расписанию

public class O_ScheduledExecuterService {
    public static void main(String[] args) {
        ScheduledExecutorService sk = Executors.newSingleThreadScheduledExecutor();
            sk.schedule(new MyThread(), 10, TimeUnit.SECONDS);
            sk.shutdown();
    }

    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("привет");
        }
    }
}
