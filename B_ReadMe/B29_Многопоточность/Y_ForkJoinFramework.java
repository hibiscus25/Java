package B_ReadMe.B29_Многопоточность;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Y_ForkJoinFramework {
    static long numOfOperations = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();   // показывает кол-во процессоров на компьютере

    public static void main(String[] args) throws Exception {
        System.out.println("количество ядер: " + numOfThreads + "\n");

        long time = new Date().getTime();
            long k = 0;                                                   // операция выполняется за 11 сек
            for(long i = 0; i < numOfOperations; i++)
                k +=i;
            System.out.println(k);
        System.out.println("время операции: " + (new Date().getTime() - time)/1000.0 + " cек\n");


        time = new Date().getTime();
            ForkJoinPool  pool = new ForkJoinPool(numOfThreads);               // разделяет операции на несколько частей
                System.out.println(pool.invoke(new MyFork(0,numOfOperations)));
        System.out.println("время операции: " + (new Date().getTime() - time)/1000.0 + " cек");
    }

    static class MyFork extends RecursiveTask<Long>{
        long from, to;

        public MyFork(long from, long to){
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to - from) <= numOfOperations/numOfThreads){    // если операция разбита на достаточное кол-во частей,
                long k = 0;                                     //   тогда выполняем
                for(long i = from; i < to; i++)
                     k +=i;
                return k;
            }else{                                              // иначе разбиваем на части поменьше
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                    firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
