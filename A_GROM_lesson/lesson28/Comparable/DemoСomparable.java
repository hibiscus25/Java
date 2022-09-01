package A_GROM_lesson.lesson28.Comparable;

import java.util.*;

public class DemoСomparable {
    public static void main(String[] args) {
        Capability capability1=new Capability(1005,"test","rrrr",true,new Date());
        Capability capability2=new Capability(1001,"test","rrrr",true,new Date());
        Capability capability3=new Capability(990,"test","rrrr",true,new Date());

        Set<Capability> set=new TreeSet<>();
        set.add(capability1);
        set.add(capability2);
        set.add(capability3);

        System.out.println(set);
    }
}
