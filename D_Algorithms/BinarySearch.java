package D_Algorithms;

public class BinarySearch {
    public static void main(String[] args) {
    // вариант 1
        System.out.println(binarySearch(new int[] {-1, 3, 5, 8, 10, 15, 16, 20}, 3));

    // вариант 2
        // начальные low и high надо передавать в аргументы
        int[] a = {-5, -2, 1, 5, 6, 8, 10, 20};
        System.out.println(binarySearch(a, 1, 0, a.length - 1));
    }


    //вариант 1
    public static int binarySearch(int[] a, int key){
        int low = 0;
        int high = a.length-1;

        while (low <= high){
            int middle = low + (high - low) / 2;

            if (key < a [middle]){
                high = middle -1 ;
            } else if (key > a [middle]){
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // вариант 2 ( решение с помощью рекурсии
    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int middle = low + (high - low) / 2;                // считаем индекс центрального элемента

        if (low > high) {                                  // base case (условие выхода) - регион поиска пустой
            return -1;                                          // не нашли элемента, который равен ключу
        }

        if (key == sortedArray[middle]) {                // в случае, если элемент в центре равняется ключу (нашли элемент)
            return middle;
        } else if (key < sortedArray[middle]) {
                // рекурсивный вызов для левого подмассива
                // не забывайте здесь ключевое слово return (подумайте, зачем оно нужно)
            return binarySearch(sortedArray, key, low, middle - 1);
        } else {
                // рекурсивный вызов для правого помассива
            return binarySearch(sortedArray, key, middle + 1, high);
        }
    }
}
