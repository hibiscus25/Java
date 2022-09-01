package D_Algorithms;


import java.util.Arrays;
import java.util.Collections;

//пример жадного алгоритма
public class GreedyAlgorithms {
    public static void main(String[] args) {

    // задача 1:     из цифр создать самое большое число
            int[] digits = {3,1,7,9,9,5,7,9};
            System.out.println(maxNumberFromDigits(digits));
            System.out.println(maxNumberFromDigitsAnalog(digits));

    // задача 2:     нахождение оптимальных остановок при движении с точки А в точку B
            int capacity = 400;                                 // cколько км может проехать автомобиль
            int[] stations = {0, 200, 375, 550, 750, 950};      // возможные остановки
            System.out.println(minStops(stations, capacity));

    // задача 3:     нахождение оптимальных остановок при движении с точки А в точку B

    }


    //------------------------------------- решение задачи 1 ----------------------------------------------------------
        //O(nlog(n))
        //вариант 1
        public static StringBuilder maxNumberFromDigits(int[] digits){
            Arrays.sort(digits);                                        //cортировка по возрастанию

            StringBuilder result = new StringBuilder(digits.length);

            for (int i = digits.length-1; i>=0; i--){
                result.append(digits[i]);
            }

            return result;
        }

        //вариант 2
        public static String maxNumberFromDigitsAnalog(int[] digits) {
            return String.join("",Arrays.stream(digits).boxed()
                    .sorted(Collections.reverseOrder())
                    .map(String::valueOf)
                    .toArray(String[]::new));
        }

    //-------------------------------------- решение задачи 2 ----------------------------------------------------------
        // возвращает -1, если не возможно доехать из точки А до точки B
        public static int minStops(int[] stations, int capacity){
            int result = 0;                             // оптимальное количество остановок
            int currentStop = 0;                         // где машина находится


            while(currentStop < stations.length - 1){
                int nextStop = currentStop;                     // cледующая заправка
                System.out.println("nextStop = " + nextStop + "   " + "currentStop = " + currentStop);
                System.out.println("Stations/nextop = " + stations[nextStop + 1] + "Stations currentStop = " + stations[currentStop]);

                while ((nextStop < stations.length-1) && (stations[nextStop + 1] - stations[currentStop] <= capacity)) {
                    nextStop++;
                    System.out.println(nextStop);
                }

                System.out.println("currentStop = " + currentStop + "  " + "nextStop = " + nextStop);

                    if (currentStop == nextStop)
                        return -1;

                    if (nextStop < stations.length-1)
                        result++;

                    currentStop = nextStop;

                System.out.println("Последний while " + "    currentStop = " + currentStop + "  " + "nextStop = " + nextStop);
            }
        return result;
        }
}
