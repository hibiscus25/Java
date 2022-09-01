package B_ReadMe.B29_Многопоточность;

public class D3_Volatile {
    static int k;
    volatile static int i;                  // при определении одной как volatile - не будут кэшироваться все переменные
                                            // кроме этого volatile запрещает менять порядок выполнения операций

    public static void main(String[] args) {
        new MyThreadWrite().start();
        new MyThreadRead().start();
    }


    static class MyThreadWrite extends Thread{
        @Override
        public void run(){
            while (i<5){
                System.out.println("increment k to " + (++k));
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        }
    }

    static class MyThreadRead extends Thread{
        @Override
        public void run(){
            int local = k;
            int localVar = i;
            while (localVar < 5){
                if(localVar != i){
                    System.out.println(local = k);
                    System.out.println(localVar = i);
                }
            }
        }
    }
}
