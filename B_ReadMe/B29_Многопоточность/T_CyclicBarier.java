package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T_CyclicBarier {
    public static void main(String[] args) throws InterruptedException {
        // cycl - ждет пока будет запущено 3 потока, после чего запускает Run()
        //        если запустится, только 2 потока будет ждать 3 потока
        CyclicBarrier cycl = new CyclicBarrier(3, new Run());
            new Sportsman(cycl);
            new Sportsman(cycl);
            new Sportsman(cycl);
    }

    static class Run extends Thread{
        CyclicBarrier cyclicBarrier;

        @Override
        public void run(){
            System.out.println("Run is begun");
        }
    }

    static class Sportsman extends Thread{
        CyclicBarrier cyclicBarrier;

        public Sportsman(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
            start();
        }

        @Override
        public void run(){
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
