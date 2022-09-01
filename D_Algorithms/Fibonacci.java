package D_Algorithms;

import java.util.Arrays;

// число Фибоначи
// пример: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 , 55, 89, 144
        // при  0 будет 0
        // при 1  будет 1
        // потом сумма двух предыдущих чисел
public class Fibonacci {
    public static void main(String[] args) {
    //пример (медленное решение)
//        System.out.println(fibNative(3));           //2
//        System.out.println(fibNative(5));           //5
//        System.out.println(fibNative(10));          //55
//        System.out.println(fibNative(100));         //пример будет выполняться 50 тысяч лет (поэтому этот метод не эффективен)

    //пример (быстрого решения)
//        System.out.println(fibEffective(0));      // 0
//        System.out.println(fibEffective(1));      // 1
//        System.out.println(fibEffective(2));      // 1
//        System.out.println(fibEffective(3));      // 2
//        System.out.println(fibEffective(5));      // 5
//        System.out.println(fibEffective(10));     // 55
//        System.out.println(fibEffective(100));    // 3736710778780434371

    //пример мемоизации
        int n = 10;
        long[] mem = new long [n+1];
        Arrays.fill(mem, -1);                                   // заполняем весь массив  -1
                    System.out.println(Arrays.toString(mem));       // [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
            System.out.println(fibNaive(n,mem));                    // 55
                     System.out.println(Arrays.toString(mem));      // [-1, -1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
    }


    // наивный, медленный, очевидный
    // O(2^n)
        private static long  fibNative(int n){
            if ( n <= 1)
                return n;
            return fibNative(n-1) + fibNative(n - 2);
        }

    // быстрый алгоритм для числа Фибоначи
    // O(n)
        private static long fibEffective(int n){
            long[] array = new long[n+1];
            for (int i = 0 ; i <= n; i++){
                if(i <= 1) {
                    array[i] = i;
                    continue;
                }
                array[i] = array[i-1] + array[i-2];
            }
            return array[n];
        }

    // мемоизация (запоминание) - сохранение результатов выполнения функций для предотвращения повторных вычислений
    // переделываем  пример не эффективного вычисления числа Фибоначчи (рекурсивный метод)
        private static long fibNaive(int n, long[] mem){
            if (mem [n] != -1)                                   // если такое число в массиве уже есть, используем его
                return mem[n];

            if (n <= 1)
                return n;

            long result = fibNaive (n-1,mem) + fibNaive(n-2, mem);
            mem[n] = result;

            return result;
        }
    }
