package B_ReadMe.B29_Многопоточность;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

class ResourceA {
    ResourceB resourceB;


    // выставляем sleep, чтобы thB зашел в свой метод getI()
    public synchronized int getI() {            // thA при выполнении getI() из - за synchronized блокирует resourceA
        try {
            Thread.sleep(135);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }                                       // если до выполнения этой строки thB заходит в свой getI()
                                                // thB  для выполнения getI() делает lock resourceB
        return resourceB.returnI();             // thA для выполнения строки synchronized нужно получить еще lock на resourceB
    }                                           // но так как он уже занят, он ждет когда lock cнимится   - ждет
                                                // аналогичная ситуация происходит и в resourceB

    public synchronized int returnI(){
        return 1;
    }
}


class ResourceB {
    ResourceA resourceA;

    public synchronized int getI(){
       return resourceA.returnI();
    }

    public synchronized int returnI(){
        return 2;
    }
}


public class G1_2_DeadLock {
    public static void main(String[] args) throws InterruptedException {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
            resourceA.resourceB = resourceB;
            resourceB.resourceA = resourceA;

        MyThA thA = new MyThA();
        MyThB thB = new MyThB();
            thA.resourceA = resourceA;
            thB.resourceB = resourceB;

            thA.start();
            thB.start();


        // таким способом узнаем есть у нас deadLock или нет
            Thread.sleep(1000);
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
            if(deadlockedThreads != null) {
                ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
                for (ThreadInfo el : threadInfo)
                    System.out.println(el);
            }
    }
}

class MyThA extends Thread{
    ResourceA resourceA;

    @Override
    public void run(){
        System.out.println(resourceA.getI());
    }
}

class MyThB extends Thread{
    ResourceB resourceB;

    @Override
    public void run(){
        System.out.println(resourceB.getI());
    }
}

