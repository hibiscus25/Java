package B_ReadMe.B29_Многопоточность;

import javax.swing.*;

import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

/*        Демон - потоки в основном выполняются в фоновом режиме и играют некоторую "вспомогательную" роль по обслуживанию
     других потоков
          Главна особенность в том, что при завершении главного потока демон-поток завершается автоматически
*/

public class A2_Demon {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            int k=1, s=0;
            while(true){
                System.out.println(Thread.currentThread().getName() + ": " + s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                s+=k;
                k++;
            }
        }, "Вычисление суммы");

        t.setDaemon(true);                  // включаем Daemon поток
        t.start();
        int res;
        do{
            Thread.sleep(3000);
            res = showConfirmDialog(null, "Закончить вычисление суммы", "Cумма чисел", JOptionPane.YES_NO_OPTION);
        }while (res!=YES_OPTION);
    }
}
