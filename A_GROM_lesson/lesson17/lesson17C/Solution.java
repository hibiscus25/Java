package A_GROM_lesson.lesson17.lesson17C;

public class Solution {
    public static void main(String[] args) {
        //результат - null
        String input = "Oracle corporate citizenship efforts are steadfast clear and effective";
        //результат - oracle
        String input2 = "corporate efforts oracle are Oracle  steadfast oracle and effective";
        //результат - string
        String input3 = "string corporate string oracle efforts Oracle are steadfast oracle and string effective";

        System.out.println(moustCountedWords(input));
        System.out.println(moustCountedWords(input2));
        System.out.println(moustCountedWords(input3));
    }

    public static String moustCountedWords(String input) {
        String result = null;
        String[] str = input.toLowerCase().split(" ");
        int[] ints = new int[str.length];
//    System.out.println(Arrays.toString(str));

        int count = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].equals(str[j])) {
                    ints[i]++;
                    count++;
                }
            }
        }
//    System.out.println(Arrays.toString(ints));
        if (count == 0)
            return result;

        int countPlaced = 0;
        int res = ints[0];
        for (int i = 0; i < str.length; i++) {
            if (res < ints[i]) {
                res = ints[i];
                countPlaced = i;
            }
        }
//    System.out.println(countPlaced);

        return str[countPlaced];
    }
}