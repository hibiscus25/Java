package A_GROM_lesson.lesson31.A_HW;

import java.util.*;

public class Solution {

    public static Map<Character, Integer> countSymbol(String text) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] str = text.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int count = 0;
            for (int j = i + 1; j < str.length; j++) {
                if (str[i] == str[j]) {
                    count++;
                }
            }
            if (!map.containsKey(str[i])) {
                map.put(str[i], count);
            }
        }
        return map;
    }


    //возвращает Мар, которая содержит количество повторений слов во входящем тексте
    public static Map<String, Integer> words(String text) {
        Map<String, Integer> map = new TreeMap<>();

        String[] str = text.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 2) {
                int count = 0;
                for (int j = i + 1; j < str.length; j++) {
                    if (str[i].equalsIgnoreCase(str[j])) {
                        count++;
                    }
                }
                if (!map.containsKey(str[i])) {
                    map.put(str[i], count);
                }
            }
        }
        return map;
    }

}
