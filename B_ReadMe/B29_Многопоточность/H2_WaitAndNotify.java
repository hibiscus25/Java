package B_ReadMe.B29_Многопоточность;

import java.util.*;


public class H2_WaitAndNotify {
    static List<String> str = Collections.synchronizedList(new ArrayList<>());

    static class Operator extends Thread{
        @Override
        public void run(){
            Scanner scanner = new Scanner(System.in);
            System.out.println(getName() + "  - зашел в class Operator");
            while(true){
                synchronized (str){
                        System.out.println(getName() + "  - ждет ввода данных....");
                    str.add(scanner.nextLine());
                        System.out.println(getName() + "  - notify() cообщает о завершении");
                    str.notify();
                }
                try {                                // задержка, чтобы не было голодание потоков
                    Thread.sleep(1000);        //        - успевал работать str.wait();
                } catch (InterruptedException e) {}
            }
        }
    }

    static class Machine extends  Thread{
        @Override
        public void run(){
            System.out.println(getName() + "  - зашел в class Machine");
            while(str.isEmpty()){
                synchronized (str){
                    try {
                        System.out.println(getName() + "  - wait() переводит поток в ожидание");
                        str.wait();
                    } catch (InterruptedException e) {}
                    System.out.println("Выводит/удаляет результат: " + str.remove(0).toUpperCase() + "\n");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Machine().start();
            Thread.sleep(100);
        new Operator().start();

    }
}
