package B_ReadMe.B29_Многопоточность;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class V_BlockingQueue {
    public static void main(String[] args) throws InterruptedException{
       // Queue<String> queue = new PriorityQueue<>();
        BlockingQueue<String> block = new PriorityBlockingQueue<>();

        new Thread(){
            @Override
            public void run(){
               // System.out.println(queue.remove());             // будет ошибка, если отработает этот поток
                                                                  // так как пытается удалить, а в очереди ничего нет

                try {
                    System.out.println(block.take());             // в этом случае поток заснет, пока не появится элемент
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                // queue.add("this is String");
                block.add("this is String");
            }
        }.start();
    }
}
