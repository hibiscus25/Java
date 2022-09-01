package B_ReadMe.B29_Многопоточность;


// блокирует какой - то код на чтение, а какой-то на запись

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class А_ReadWriteLocked {
    public static void main(String[] args) {

    }
}
class Block{
    String name;
    int buyTime;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public void addBuy(){
        writeLock.lock();
            buyTime++;
        writeLock.unlock();
    }

    public void howManyBooksWereSale(){
        readLock.lock();
            System.out.println("Books were sale " + buyTime);
            sendReport(buyTime);
        readLock.unlock();
    }

    private void sendReport(int books){
        // ....
    }

}
