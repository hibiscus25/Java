package A_GROM_lesson.lesson18.A_HW.lesson18D;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findNumbers("-11")));
        System.out.println(Arrays.toString(findNumbers("125")));
        System.out.println(Arrays.toString(findNumbers("0")));

        System.out.println(Arrays.toString(findNumbers(null)));
        System.out.println(Arrays.toString(findNumbers("11a")));
        System.out.println(Arrays.toString(findNumbers("aaaaa")));
        System.out.println(Arrays.toString(findNumbers("aaaaa  adfadfaf")));
    }

    public static int[] findNumbers(String text) {
        //проверка на null
        if (text == null) {
            System.out.println(text + " not a number");
            return null;
        }

        //проверка на число / не число
        char[] simbol = text.toCharArray();
        int count = 0;

        if ((int) simbol[0] == 45) {            //проверка на отрицательное число или нет
            count = 1;
        }
        int a;
        int number = count;
        for (int i = number; i < simbol.length; i++) {
            a = (int) simbol[i];
            if (a == 48 || a == 49 || a == 50 || a == 51 || a == 52 || a == 53 || a == 54 || a == 55 || a == 56 || a == 57)
                count++;
        }

        if (count != simbol.length) {
            System.out.println(text + " not a number");
            return null;
        }

        //нужно еще  ограничение на числа от -2147483648 до 2147483647  ***очень долго писать****

        int resultFinaly = Integer.parseInt(text);


        if (resultFinaly >= 0) {
            int[] result = new int[resultFinaly];
            for (int i = 0; i < result.length; i++) {
                result[i] = i;
            }
            return result;
        } else {
            int numberFianly =resultFinaly * (-1);
            int[] result = new int[numberFianly];
            for (int i = 0; i < result.length; i++) {
                result[i] = resultFinaly++;
            }
            return result;
        }

    }
}
