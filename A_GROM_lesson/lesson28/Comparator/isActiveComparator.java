package A_GROM_lesson.lesson28.Comparator;

import java.util.*;

public class isActiveComparator implements Comparator<Capability>{

    @Override
    public int compare(Capability o1, Capability o2) {
        System.out.println("isActiveComparator is used");
        if(o1.isActive() && !o2.isActive())
            return -1;              //если true && false, тогда -1 - не меняем
        else if((o1.isActive() && o2.isActive()) || (!o1.isActive() && !o2.isActive()))
            return 0;               //если true && true или false && false - тогда 0 - оставляем
        else
            return 1;               //в других случаях меняем
    }
}
