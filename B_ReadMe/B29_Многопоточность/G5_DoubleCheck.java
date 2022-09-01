package B_ReadMe.B29_Многопоточность;

public class G5_DoubleCheck {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();


    }

    static class Singleton{
        // добавляем volatile, чтобы соблюдался принцип  happens Before (последовательное выполнение)
        private volatile static Singleton singleton;

        private Singleton(){
        }

        public static Singleton getInstance(){
            if(singleton == null) {
                synchronized (Singleton.class) {
                    if(singleton == null)
                        singleton = new Singleton(); // synchronized не поддерживает happens Before, поэтому doubleCheck
                }
            }
            return singleton;
        }
    }
}
