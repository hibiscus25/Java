package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.TimeUnit;

public class B_LifeCycle {
    public static void main(String[] args) throws InterruptedException {
        /*   жизненный цикл потока - вызываем start() :
              -   будет в состоянии New (просто создан и есть возможность его запустить)
              -   помещается в Pool потоков и переходит в состояние Runnable
                     - в Java есть свое расписание (нет гарантий) как запускать потоки, поэтому Java может
                       как продолжать выполнять поток main, так и запустить run()
              -  когда поток переходит в состояние Running, он начинает выполнять run(), но может остановить выполнение,
                 при этом будет работать поток main (то есть перейти в состояние Runnable)
              -  также поток может перейти в блок состояний (Waiting, Sleeping, Blocking)
                    - sleeping          - поток засыпает
                    - waiting/blocking  - поток приостанавливается
              -  из блока состояний (Waiting, Sleeping, Blocking) попадает в состояние Runnable
              -  dead - конечное состояние потока

              PS: в состоянии Running находится только один поток, остальные в Pool, но они могут прыгать
                  из Runnable - Running
         */

/**
    // cостояние Sleeping (вызывает исключение InterruptedException)
            new MyThreed3().start();                    // доп поток НЕ БУДЕТ успевает выполнить первым печать в консоль
                System.out.println("Thread - main");

            new MyThreed3().start();                    // доп поток БУДЕТ успевать, так как задаем задержку на 1 с
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                }
                System.out.println("Thread - main");
            System.out.println("----------------------");
*/


/**
    // interrupt() - позволяет  выставить статус internal flag called interrupt status (прекратить поток)
            Runnable task = () -> {
                try {
                     TimeUnit.SECONDS.sleep(60);         // переводим в сон
                } catch (InterruptedException e) {
                     System.out.println("Interrupted");
                }
            };
            Thread thread = new Thread(task);
                thread.start();
                thread.interrupt();                             // не будет задержки 60 сек, сразу в сatch

         //      если поток в процессе выполнения (не спит, а выполняет какое-то действие), можно предусмотреть прекращение
         //  выполнения потока снаружи
            Runnable task2 = () -> {
                while(!Thread.currentThread().isInterrupted()) {
                        //Do some work
                }
                System.out.println("Finished");
            };
            Thread thread2 = new Thread(task2);
                thread2.start();
                thread2.interrupt();

        // P.S.:       Про флаг isInterrupted важно знать то, что если мы поймали InterruptedException,
                   флаг isInterrupted сбрасывается, и тогда isInterrupted будет возвращать false.
                       Также есть статический метод, который относится только к текущему потоку — Thread.interrupted(),
                   но данный метод сбрасывает значение флага на false!
 */


/**
    // Thread.yield() - предлагает передать другому потоку приоритет (поток, который передает в Runnable, может запуститься)
            MyThreed3 th = new MyThreed3();
                th.setPriority(Thread.MAX_PRIORITY);  // выставили приоритет - 10, по умолчанию - 5, min - 1 (не гарантировано)
                th.start();
                Thread.yield();                       // предлагает передать другому потоку (сам в Runnable) (не гарантированно)
                System.out.println("Thread2 - main");
*/

    // join() - является методом, который выполняет wait, пока поток, на котором он вызван, живёт
    //          как только поток умирает (при завершении), ожидание прерывается
            MyThreed3 th = new MyThreed3();
                    th.start();
                    th.join();
            System.out.println("Thread3 - main");
    }
}


class MyThreed3 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread - " + Thread.currentThread().getName());
    }
}