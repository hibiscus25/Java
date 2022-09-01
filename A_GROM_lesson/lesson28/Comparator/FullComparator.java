package A_GROM_lesson.lesson28.Comparator;

import java.util.*;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
        if (!o1.getChannelName().equals(o2.getChannelName()))              //если не равны
            return o1.getChannelName().compareTo(o2.getChannelName());     //сортирую по getChannelName()
        if (!o1.getFingerprint().equals(o2.getFingerprint()))              //если не равны
            return o1.getFingerprint().compareTo(o2.getFingerprint());     //сортирую по getFingerprint()
        if (o1.getDateCreated().compareTo(o2.getDateCreated()) < 0)        //остальное сортирую по дате
            return 1;      //дата 1- min, дата 2 - max -"-1" - меняем
        else if (o1.getDateCreated().compareTo(o2.getDateCreated()) == 0)
            return 0;      // даты равные - ничего не меняем
        else
            return -1;
    }
}
