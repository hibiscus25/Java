package B_ReadMe.B29_Многопоточность;

/*
    - поток main запускает поток Thread - 1
    - Thread 1:
        - начинает выполнение run
    - wait() - cообщает main, что я пока отдыхаю, когда закончите выполнение сообщите - main засыпает
    - когда run выполнился он передает notifY() - метод выполнен
    - после этого, просыпается метод main начинает дальше выполнять задачу
*/

public class H1_WaitAndNotify {
    static class ThrB extends Thread{
        int total;

        @Override
        public void run(){
            synchronized (this){
                for (int i =0; i < 5; i++){
                    total += i;
                    try{
                        System.out.println(getName() + " - засыпает " + (i+1) + " раз  на 2 сек");
                        sleep(2000);
                    } catch (InterruptedException e) {}
                }
                System.out.println(getName() + " - notify() - cообщает, что закончил выполнение");
                notify();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThrB th = new  ThrB();
            th.start();
        synchronized (th){          // объекты синхронизации должны совпадать / должны вызваться из синхрониз потоков
            System.out.println(Thread.currentThread().getName() + "    - засыпает из-за wait()");
            th.wait();
        }
            System.out.println(Thread.currentThread().getName() + "    - просыпается после wait()");
            System.out.println("Результат: " + th.total);
    }


}


