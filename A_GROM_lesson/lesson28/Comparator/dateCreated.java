package A_GROM_lesson.lesson28.Comparator;

import java.util.*;

public class dateCreated implements Comparator<Capability>{

    @Override
    public int compare(Capability o1, Capability o2) {
        int res=o1.getDateCreated().compareTo(o2.getDateCreated());
        if(res<0)
            return 1;      //дата 1- min, дата 2 - max -"-1" - меняем
        else if(res==0)
            return 0;      // даты равные - ничего не меняем
        else
            return -1;     //дата 2-min, датa 1-max -"-1" - меняем
    }
}

//int res=date1.compareTo(date2) - c
//если res=0  - даты равны
//если res<0  - дата 1 предшествует дате 2
//если res>0  - дата 2 предшествует дате 1


