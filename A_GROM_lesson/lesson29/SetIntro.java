package A_GROM_lesson.lesson29;

import java.util.*;

public class SetIntro {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();          //HashSet<>         -не гарантирует порядок в структуре
//      Set<String> set=new LinkedHashSet<>();    //LinkedHashSet<>   -гарантирует порядок в структуре
        set.add("testStr");
        set.add("111");
        set.add("aaa");
        set.add("222");
        System.out.println(set);

        set.add("aaa");             //не добавит, так как  уже такой есть в set
        set.add("111");             //не добавит, так как  уже такой есть в set
        System.out.println(set);

        Set<File> files=new HashSet<>();
        File file1=new File("pict.txt",100);
        File file2=new File("home.txt",178);
        File file3=new File("home.txt",178);       //недобавляет так как уже такой есть
        files.add(file1);                                           //проверяет по txt
        files.add(file2);
        files.add(file3);

        System.out.println(files);
    }
}
