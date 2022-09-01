package B_ReadMe.B29_Многопоточность;


public class D2_Volatile {
    //static  int i;                // потоки будут использовать каждый свою локальную копию переменной

    volatile static int i;          // volatile  - указывает JVM, что не нужно кэшировать переменную
                                    //             это позволяет всем потокам видеть актуальное значение переменной

    public static void main(String[] args) {
        new MyThreadWrite().start();
        new MyThreadRead().start();
    }


    static class MyThreadWrite extends Thread{
        @Override
        public void run(){
            while (i<5){
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread{
        @Override
        public void run(){
            int localVar = i;
            while (localVar < 5){
                if(localVar != i){
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}
