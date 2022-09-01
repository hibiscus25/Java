package B_ReadMe.B9_Collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//--------------------------------------- cортировка примитивного типа -------------------------------------------------
    class Compares implements Comparator<String> {
        @Override
        public int compare(String obj1, String obj2){
            return obj1.compareTo(obj2);
        }
    }


    public class TSortComparator1 {
        public static void main(String[] args){
            TreeSet<String> data = new TreeSet();
                data.add("Змей Горыныч");
                data.add("Баба Яга");
                data.add("Илья Муромец");
                data.add("Алеша Попович");
                data.add("Соловей Разбойник");

            Iterator<String> i = data.iterator();
            while(i.hasNext())
                System.out.println(i.next());
        }
    }

