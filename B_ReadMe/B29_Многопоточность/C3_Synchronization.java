package B_ReadMe.B29_Многопоточность;

public class C3_Synchronization {
    static void run(Counter counter, String str){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000_000; i++)
            counter.increase();
        System.out.println(str  + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        run(new CounterA(), "Без ничего - ");
        run(new CounterB(), "Переменная volatile - ");
        run(new CounterC(), "Метод synchronized - ");
        run(new CounterD(), "Переменная volatile + метод synchronized - ");

    }

    static abstract class Counter{
        abstract void increase();
    }

    static class CounterA extends Counter{
        int i;
        public void increase(){
            i++;
        }
    }

    static class CounterB extends Counter{
        volatile int i;
        public void increase(){
            i++;
        }
    }

    static class CounterC extends Counter {
        int i;
        public synchronized void increase(){
            i++;
        }
    }

    static class CounterD extends Counter{
        volatile int i;
        public synchronized void increase(){
            i++;
        }
    }
}
