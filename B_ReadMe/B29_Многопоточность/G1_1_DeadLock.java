package B_ReadMe.B29_Многопоточность;

public class G1_1_DeadLock {
    static class Friend {
        private  final String name;

        public Friend(String name) {
            this.name = name;
        }

        public  String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            /* Thread - 1 - заходит в свою копию метода bow
                 - synchronized блокирует доступ до объекта - Friend t1, в котором выполняется метод bow
                 - выводит данные в консоль, bower.getName() - не блокирует, так как метод не синхронизирован,
                   то есть synchronized не блокирует объект Friend t2 для выполнения метода getName()
             !!! - в это время (Thread - 2 - заходит в свою копию метода bow)
                     - выводит данные в консоль, ситуация аналогичная
                 - Thread - 1:
                     - пытается выполнить копию метода bowBack объекта Friend t2, но для этого нужно
                       выставить lock Friend t2, который заблокирован при выполнении копии метода bow
                     - переходит в ожидание, когда Friend t2 разблокируется
                 - Thread - 2:
                     - аналогичная ситуация, только с объектом Friend t1

               PS:  в итоге получается DeadLock
            */
            System.out.println("Каждый объект имеет свою копию метода");
            System.out.format("%s:  %s has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back - to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        Friend t1 = new Friend("Thread - 1");
        Friend t2 = new Friend("Thread - 2");
        new Thread(() -> t1.bow(t2)).start();
        new Thread(() -> t2.bow(t1)).start();
    }
}
