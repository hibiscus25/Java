package A_GROM_lesson.lesson16;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        String test = "There is B_readMe.Test something new or jot sdf sdf sdf word B_readMe.Test op or";

        System.out.println(deleteDuplicates(test));
        System.out.println(Arrays.toString(countDuplicates(test, new String[]{"or", "some", "test"})));

        String str = "Today is good day... Hello dpsd";

        System.out.println(replace(str, "is", "that"));
        System.out.println(replace(str, "o", " "));
        System.out.println(replace(str, "To", "PPPP"));
        System.out.println(replace(str, "lo", "X"));


    }

    //delete replacing worlds
    public static String deleteDuplicates(String input) {
        //split() по "пробелу" делает массив слов
        String[] words = input.split(" ");

        //System.out.println(Arrays.toString(words));

        //for (i) - проверяем с остальными словами на совпадения
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j]))
                    words[j] = "";
            }
        }
        //System.out.println(Arrays.toString(words));

        //заново собираем массив, метод сложения
        String res = "";
        for (String word : words) {
            res += word;
            if (!word.isEmpty())
                res += " ";
        }
        return res;
    }

    public static int[] countDuplicates(String input, String[] words) {
        //split() по "пробелу" делает массив слов
        String[] strings = input.split(" ");

        //cоздаем массив, в который будем записывать кол-во повторений
        int[] res = new int[words.length];

        //если совпадает, увеличиваем на 1 значение в массиве
        for (String string : strings) {
            for (int i = 0; i < words.length; i++) {
                if (string.equals(words[i]))
                    res[i]++;
            }
        }
        return res;
    }

    public static String replace(String input, String target, String replacement) {
        //найти где возможна замена
        //проверить замену
        //если ок - заменить
                                //создаем массив = метод (делаем массив символов, узнаем первую букву)
        int[] indexes = findStartIndexes(input.toCharArray(), target.charAt(0));

        if (indexes.length == 0)                //перестраховка, если совпадений нет, сразу на возврат
            return input;

        for (int index : indexes) {
            if (checkReplace(input, target, index)) {                 //когда совпало, выполняется if
                return replace (input, target, replacement, index);
            }
        }
        return input;
    }

    private static String replace(String input, String target, String replacement, int index) {
        char[] res1 = new char[index];                          //cоздаем массив символов

        for (int i = 0; i < index; i++) {
            res1[i] = input.toCharArray()[i];
        }                                                       //до символа index - повторяется input

        //создаем остальное, после слова, которое необходимо поменять
        char[] res3 = new char[input.length() - res1.length - target.length()];
        for (int i = 0, j = res1.length + target.length(); i < res3.length && j < input.length(); i++, j++) {
            res3[i] = input.toCharArray()[j];
        }
                      //Input до index + cлово которое вставляем + остальное
        return new String(res1) + replacement + new String(res3);
    }
                                                                  //index - число из массива после метода find....
    private static boolean checkReplace(String input, String target, int index) {
        char[] inputChars = input.toCharArray();                    //делаем массив символов из input
        char[] replaceChars = target.toCharArray();                 //делаем массив cимволов из target

//        System.out.println(Arrays.toString(inputChars));
//        System.out.println(Arrays.toString(replaceChars));

        //проверка на совпадение букв с первой буквой target
        for (int i = 0; i < replaceChars.length && index < inputChars.length; i++, index++) {
            if (inputChars[index] != replaceChars[i]) {
                return false;
            }
        }
        return true;
    }
                              //аргумент (массив символов,  символ первой буквы, что меняем)
    private static int[] findStartIndexes(char[] inputChars, char beginningChar) {
        int count = 0;                                  //считает сколько совпадений
        for (char ch : inputChars) {                    //проходим массив - ищем совпадения с первой буквой
            if (ch == beginningChar) {
                count++;
            }
        }
//        System.out.println(count+" - количество совпадений первой буквы target");

        int[] indexes = new int[count];                     //создаем массив - размер = кол-ву совпадений

        int in = 0;
        int index = 0;
        for (char ch : inputChars) {                    //проходим массив и заполняем массив числами заполнения
            if (ch == beginningChar) {
                indexes[in] = index;
                in++;
            }
            index++;
        }
//        System.out.print(Arrays.toString(indexes));
//        System.out.println(" - массив(размер количество совпадений) - число = на каком символе совпало");

        return indexes;
    }
}
