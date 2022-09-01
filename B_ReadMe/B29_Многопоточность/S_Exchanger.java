package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.Exchanger;

public class S_Exchanger {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        new Mike(exchanger);
        new Anket(exchanger);
    }


    static class Mike extends Thread {
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Hi my name is Mike");               //обменяется с 1 exchanger
                sleep(1000);
                System.out.println(exchanger.exchange(null));           //обменяется со 2 exchanger
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Anket extends Thread{
        Exchanger<String> exchanger;

        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));       //обменяется с 1 exchanger
                sleep(1000);
                exchanger.exchange("My names valya");               //обменяется со 2 exchanger
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

