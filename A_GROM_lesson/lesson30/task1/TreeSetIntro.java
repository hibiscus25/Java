package A_GROM_lesson.lesson30.task1;

import java.util.*;

public class TreeSetIntro {
    public static void main(String[] args) {
        File file1=new File("pict.txt",100);
        File file2=new File("home.txt",100);
        File file3=new File("hame.txt",300);
        File file4=new File("hame.txt",105);

        Set<File> files=new TreeSet<>();  //обязательно нужно сортировать, без сортировки - ошибка
        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);

        System.out.println(files);
    }
}
