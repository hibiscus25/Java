package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.atomic.AtomicInteger;


public class E2_AtomicVariables {
    static int k;                                                             // не атомарная переменная
    static AtomicInteger atomicInteger = new AtomicInteger(0);             // атомарная переменная

    public static void main(String[] args) throws InterruptedException {
        for( int m = 0; m < 20; m++) {
            for (int i = 0; i < 20_000; i++)
                new MyThreadAtom().start();
            Thread.sleep(1_000);                            // делаем остановку для main потока

//            System.out.println(k);
//            k = 0;

            System.out.println(atomicInteger.get());
            atomicInteger.set(0);
        }
    }

    static class MyThreadAtom extends Thread{
        @Override
        public void run(){
            // k++;                                          // не атомарная операция (int var = k + 1;   k = var)
            atomicInteger.incrementAndGet();                // атомарная операция
        }
    }
}

