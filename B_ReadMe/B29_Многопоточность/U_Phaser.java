package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.Phaser;

public class U_Phaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);          // разбивает работу по фазам, пока не закончится фаза
            new Washer(phaser);                        //  новая фаза не начинается
            new Washer(phaser);
            new Washer(phaser);
    }

    static class Washer extends Thread{
        Phaser phaser;

        public Washer(Phaser phaser){
            this.phaser = phaser;
            start();
        }

        @Override
        public void run(){
            for(int i =0; i<3; i++) {
                System.out.println(getName() + " washing the car");
                phaser.arriveAndAwaitAdvance();                             // ждет, когда 3 потока дойдут
            }                                                               // после чего переходит на новый цикл
        }
    }
}
