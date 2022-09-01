package B_ReadMe.B29_Многопоточность;


public class C2_Synchronization {
    public static void main(String[] args) throws InterruptedException {
        /*          Два разных потока могут одновременно выполнять  synchronized статический и не статический метод,
                так как при статическом / не статическом синхронном методе выставляются разные lock (класс / объект);
                    Но тогда synchronized дает ошибки, поэтому так никогда не нужно делать
                    Поэтому synchronized должна быть или на уровне класса или на уровне метода
         */


        for(int i = 0; i < 20_000; i++) {
                Resource2.i = 5;
                    MyThreed5 th = new MyThreed5();
                        th.setName("one");
                    MyThreed5 th2 = new MyThreed5();
                        th.start();
                        th2.start();
                        th.join();
                        th2.join();
                if(Resource2.i != 9)
                    System.out.println(Resource2.i);
        }
    }
}


class MyThreed5 extends Thread {

    @Override
    public void run() {
        Resource2.changeStatickI();
        new Resource2().changeI();
    }
}


class Resource2{
    static int i;
    
//    public synchronized static void changeStatickI(){           // 1 - вариант
//        int i = Resource2.i;
//        if(Thread.currentThread().getName().equals("one"))
//            Thread.yield();
//        i++;
//        Resource2.i = i;
//    }

    public static void changeStatickI(){                            // 2 - вариант
        synchronized (Resource2.class) {
            int i = Resource2.i;
            if (Thread.currentThread().getName().equals("one"))
                Thread.yield();
            i++;
            Resource2.i = i;
        }
    }

    public void changeI(){
        synchronized (this) {
        //synchronized (Resource2.class) {                            // при таком использовании не будет ошибки
            int i = Resource2.i;
            if (Thread.currentThread().getName().equals("one"))
                Thread.yield();
            i++;
            Resource2.i = i;
        }
    }
}