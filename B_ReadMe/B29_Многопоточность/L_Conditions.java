package B_ReadMe.B29_Многопоточность;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class L_Conditions {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();             // типа аналог Wait and Notify, при использовании Lock
    static int account = 0;

    public static void main(String[] args) {
        new AccountPlus().start();
        new AccountMinus().start();
    }

    static class AccountPlus extends Thread{
        @Override
        public void run(){
            lock.lock();
            System.out.println("Заходит в AccountPlus");
                account +=10;
                condition.signal();                      // cигнализирует, что можно выполять операцию в потоке 2 дальше
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread{
        @Override
        public void run(){
            System.out.println("Заходит в AccountMinus");
            if(account<10){
                try {
                    lock.lock();
                        System.out.println(account + " перед засыпанием");
                        condition.await();            // если не удовлетворяет, ждем когда будет соответствовать условию
                        System.out.println(account + " после засыпания");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            account -=10;
            System.out.println(account);
        }
    }
}
