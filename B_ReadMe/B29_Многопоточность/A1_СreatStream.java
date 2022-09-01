package B_ReadMe.B29_Многопоточность;

/*      1. В каждом потоке есть свой Stack
        2. Cоздать дочерний поток можно несколькими способами:
                - наследованием класса Thread и переопределением run();
                - имплементировать интерфейс Runnable и реализовать метод run();
                      - с использованием анонимного класса
                      - с использованием лямбда-выражения
        3. Дочерний поток живет до конца выполнения метода run();
        4. Дочерние потоки создаются только при вызове метода start()
                    new MyThreads().run();      -      запустит run() в потоке main
                    new MyThreads.start();      -      создаст дочерний поток и запустит метод run()
        5. Потоки не вызываются несколько раз подряд (они создаются - выполняют работу - закрываются)
                    MyThreads my = new MyThreads();
                        my.start();                 - выполнится
                        my.start();                 - ошибка  - IllegalThreadStateException

                    new MyThreads().start();        - так будет работать все 4 раза
                    new MyThreads().start();
                    new MyThreads().start();
                    new MyThreads().start();
*/


class MyThreads extends Thread{
    @Override
    public void run(){
        System.out.println("Имя доп потока: " + Thread.currentThread().getName());
        someMethod();
    }

    private void someMethod(){
        System.out.println("This is new thread");
        //  throw new RuntimeException();   // укажет в каком потоке Exception in thread "Thread-0" java.lang.RuntimeException
    }
}


class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Имя доп потока: " + Thread.currentThread().getName());
        someMethod();
    }

    private void someMethod(){
        System.out.println("new Thread");
    }
}




public class A1_СreatStream {
    public static void main(String[] args) throws Exception{
        System.out.println("Имя главного потока: " + Thread.currentThread().getName() + "\n");

    // A. создание потоков
        MyThreads t1 = new MyThreads();                            // наследование Thread
            t1.start();
            t1.join();
        System.out.println("---------------------------");


        Thread t2 = new Thread(new MyRunnable());                  // implements Runnable
            t2.start();
            t2.join();
        System.out.println("---------------------------");


            Thread t3 = new Thread(new Runnable() {               // с использованием анонимного класса
                @Override
                public void run() {
                    System.out.println("Имя доп потока: " + Thread.currentThread().getName());
                    someMethod();
                }

                private void someMethod(){
                    System.out.println("Next Thread");
                }

            });
                t3.start();
                if(t3.isAlive())
                    t3.join();
            System.out.println("---------------------------");


            Runnable lyambda = ()->{                              // с использованием лямбда - выражения
                System.out.println("Имя доп потока: " + Thread.currentThread().getName());
            };

            Thread t4 = new Thread(lyambda);
                t4.start();
                t4.join();
            System.out.println("---------------------------\n");


    // B. при запуске нескольких потоков НЕТ гарантий какой поток запустится первым
    //    так как Java помещает все потоки в Pool, из которого потом достает и запускает их
            new MyThreed2().start();
            new MyThreed2().start();
            new MyThreed2().start();
    }
}


class MyThreed2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++)
            System.out.println("Thread name is: " + Thread.currentThread().getName() + " i =  " + i);
    }
}