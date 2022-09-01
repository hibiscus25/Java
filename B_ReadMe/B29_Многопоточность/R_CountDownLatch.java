package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.CountDownLatch;

// используется, когда хотим посчитать какие - то данные, а потом их куда-то записать

public class R_CountDownLatch {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch count = new CountDownLatch(3);           // cколько раз нужно выполнить

            new Work(count);
            new Work(count);
            new Work(count);

            count.await();                                      // будет ждать пока  countDown() = 0
            System.out.println("all job done");
    }
}

class Work extends Thread{
    CountDownLatch count;

    public Work(CountDownLatch count) {
        this.count = count;
        start();
    }

    @Override
    public void run(){
        try{
            sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("- done work");
        count.countDown();
    }
}