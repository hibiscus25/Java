package B_ReadMe.B29_Многопоточность;


/*     явление "состояние гонки" заключается в том, что:
           - потоки делят между собой некоторый ресурс
           - и код написан таким образом, что не предусматривает корректную работу в таком случае

       Ошибка:
                Exception in thread "Thread-0" java.lang.IllegalStateException: 17398 + 1 = 17400
	                at B_ReadMe.B29_Многопоточность.G4_RaceCondition.lambda$main$0(G4_RaceCondition.java:18)
	                at java.lang.Thread.run(Thread.java:748)

	      - пока выполнялась операция newValue = ++value, какой - то из потоков успел поменять value
 */


public class G4_RaceCondition {
    public static int value = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++) {
                int oldValue = value;
                int newValue = ++value;
                if (oldValue + 1 != newValue)
                    throw new IllegalStateException(oldValue + " + 1 = " + newValue);
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
