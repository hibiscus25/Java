package A_GROM_lesson.lesson18.A_HW.lesson18C;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findNumber("-12")));
//        System.out.println(Arrays.toString(findNumber("125.0")));
//        System.out.println(Arrays.toString(findNumber("0.57575")));
//        System.out.println(Arrays.toString(findNumber("0000000000012")));
//
//        System.out.println(Arrays.toString(findNumber(null)));
//        System.out.println(Arrays.toString(findNumber("11a")));
//        System.out.println(Arrays.toString(findNumber("aaaaa")));
//        System.out.println(Arrays.toString(findNumber("aaaaa  adfadfaf")));
    }

    public static int[] findNumber(String text) {
        int res;
        try {
            res = Integer.parseInt(text);
        } catch (Exception e) {
            System.out.println(text + " not a number");
            return null;
        }


        if (res >= 0) {
            int[] result = new int[res];
            for (int i = 0; i < result.length; i++) {
                result[i] = i;
            }
            return result;
        } else {
            int number=res*(-1);
            int[] result = new int[number];
            for (int i = 0; i < result.length; i++) {
                result[i] = res++;
            }
            return result;
        }
    }
}
