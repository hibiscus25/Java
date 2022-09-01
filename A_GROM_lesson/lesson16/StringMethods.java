package A_GROM_lesson.lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String test="someStringExample";

    //isEmpty() - узнает, пустой String или нет (если не пустой -true)
        System.out.println(test.isEmpty());
        String test2=new String("");
        System.out.println(test2.isEmpty());
        String test3="";
        System.out.println(test3.isEmpty());

    //length() - подсчитывает количество символов в String
        System.out.println(test.length());

    //charAt(4) - возвращает  символ, указанный как аргумент
        System.out.println(test.charAt(4));

    //replace("me","T") - замена символов на указанный символ
        System.out.println(test.replace("me","T"));
        System.out.println(test.replace("met","T")); // если не находит, не выдает false

        System.out.println(test.replaceAll("me","T")); //заменяет, но работает с regex

    //contains("me") - возвращает, есть ли такая комбинация в String
        System.out.println(test.contains("me"));

    //split("e") - делает String на массив под String, по значению
        System.out.println(Arrays.toString(test.split("e")));

        String phrase="Hello there ";
        System.out.println(Arrays.toString(phrase.split(" ")));

    //trim() - удаляет пробел в начале и конце String
        System.out.println(" test ".trim());
        System.out.println(" test a".trim());

    //substring(5) - удаляет значение String до 5 символа, остальное выводит
        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(5,8)); //выводит с 5 по 7

    //toUpperCase() - весь стринг в большие буквы
        System.out.println(test.toUpperCase());
    //toLowerCase() - весь стринг в маленькие буквы
        System.out.println(test.toLowerCase());
    }
}
