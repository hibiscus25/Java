package A_GROM_lesson.lesson31;

import java.util.*;

public class MapIntro {
    public static void main(String[] args) {
        Map<String,Building> map=new TreeMap<>();

        Building building1=new Building("school...",5);
        Building building2=new Building("hospital...",8);
        Building building3=new Building("hospitadfl...",9);

        map.put("TTD2",building1);
        map.put("TTD3",building2);
        map.put("TTD4",building2);

        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.get("TTD2dfdf"));
        map.remove("TTD2");
        System.out.println(map);
        map.put("TTD3",building2);


    }
}
