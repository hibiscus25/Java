package A_GROM_lesson.lesson28.Comparator;

import java.util.*;

public class DemoСomparator {
    public static void main(String[] args) {
        Capability capability1=new Capability(1005,"arbait","sortr",true,new Date(1650000000000l));
        Capability capability2=new Capability(1007,"arbait","sortr",false,new Date(1680000000000l));
        Capability capability3=new Capability(990,"arbait","artr",true,new Date(1700000000000l));
        Capability capability4=new Capability(1001,"arbait","soutr",false,new Date(1690000000000l));
        Capability capability5=new Capability(1001,"arbait","Aortr",true,new Date());

        ArrayList<Capability> capabilities=new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);

//a. сортировка по АсtiveComparator (вначале идут активные объекты)
        System.out.println(capabilities);               //до сортировки
        capabilities.sort(new isActiveComparator());    //условия сортировки
        for(Capability c:capabilities) {                //после сортировки
            System.out.println(c);
        }

        System.out.println("");

//b. сортировка по dateCreated  (от текущей даты и до уменьшения)
        System.out.println(capabilities);
        capabilities.sort(new dateCreated());
        for(Capability c:capabilities) {
            System.out.println(c);
        }

        System.out.println("");

//c. сортировка по FullComparator (по полям сhannelName,figerprint,dateCreated (по алфавиту+по убыванию даты)
        System.out.println(capabilities);
        capabilities.sort(new FullComparator());
        for(Capability c:capabilities) {
            System.out.println(c);
        }

        System.out.println("");

//2- вариант - возможный вариант cортировки внутри класса, чтобы не делать отдельный класс
        Comparator<Capability> comparator=new Comparator<Capability>() {
            @Override
            public int compare(Capability o1, Capability o2) {
              if(!o1.getChannelName().equals(o2.getChannelName()))            //если не равны
            return o1.getChannelName().compareTo(o2.getChannelName());  //сортирую по getChannelName()
        if(!o1.getFingerprint().equals(o2.getFingerprint()))            //если не равны
            return o1.getFingerprint().compareTo(o2.getFingerprint());  //сортирую по getFingerprint()
        if(o1.getDateCreated().compareTo(o2.getDateCreated())<0)        //остальное сортирую по дате
            return 1;      //дата 1- min, дата 2 - max -"-1" - меняем
        else if(o1.getDateCreated().compareTo(o2.getDateCreated())==0)
            return 0;      // даты равные - ничего не меняем
        else
            return -1;
            }
        };

        capabilities.sort(comparator);          //условия сортировки
        for(Capability c:capabilities) {
            System.out.println(c);
        }

    }
}
