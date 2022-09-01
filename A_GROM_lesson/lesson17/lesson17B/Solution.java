package A_GROM_lesson.lesson17.lesson17B;

public class Solution {
    public static void main(String[] args) {
        String input = "Oracle corporate citizenship efforts are steadfast clear and effective";
        System.out.println(maxWord(input));
        System.out.println(minWord(input));
    }

    public static String maxWord(String input) {
        String[] str = input.split(" ");

        String strMax = str[0];
        for (int i = 1; i < str.length; i++) {
            if (strMax.length() < str[i].length())
                strMax=str[i];
        }
        return strMax;
    }

    public static String minWord(String input) {
        String[] str = input.split(" ");

        String strMin = str[0];
        for (int i = 1; i < str.length; i++) {
            if (strMin.length() > str[i].length())
                strMin=str[i];
        }
        return strMin;
    }
}

