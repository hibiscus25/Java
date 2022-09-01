package B_ReadMe.B29_Многопоточность;

public class X_ThreadLocal {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("hello world");                             // для каждого потока будет свое значение
            ThreadOne one = new ThreadOne();
            ThreadTwo two = new ThreadTwo();
                one.start();
                two.start();

                one.join();
                two.join();

        System.out.println("Main " + threadLocal.get());

    }

    static class ThreadOne extends Thread{
        @Override
        public void run(){
            threadLocal.set("ThreadOne");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
            System.out.println("ThreadOne  " + threadLocal.get());
        }
    }

    static class ThreadTwo extends Thread{
        @Override
        public void run(){
            threadLocal.set("ThreadTwo");
            System.out.println("ThreadTwo  " + threadLocal.get());
        }
    }
}
