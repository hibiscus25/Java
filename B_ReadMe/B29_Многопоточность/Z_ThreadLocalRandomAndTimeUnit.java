package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Z_ThreadLocalRandomAndTimeUnit {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());              // в многопоточном используется этот

        Thread.sleep(1792150485);
        Thread.sleep(TimeUnit.DAYS.toMillis(14));               //используется TimeUnit, чтобы не указывать в мс
    }
}
