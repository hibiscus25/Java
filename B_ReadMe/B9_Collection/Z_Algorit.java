package B_ReadMe.B9_Collection;

import java.util.*;

public class Z_Algorit {
    public static void main(String[] args) {
        /*
            - o(1)          - сonstant      - когда можно получить элементы коллекции за одну операцию
                (машину находим по номеру гаража в гаражномкооперативе)

        //o(lon(n))     - logarithmic   - поиск с учетом деления на половину
                (открываем гараж по середине гаражного коператива, там подсказка, в какой стороне машина (лев / права)
                   путем деления, каждый раз количество гаражей уменьшается на половину

        //o(n)          - liner         - перебор каждого элемента для поиска
                (открываем каждый гараж подряд, пока не найдем машину

        //0(n*log(n))   - quasilinear -
                (гаражи разбросаны, нужно сначала отсортировать, потому использует логарифмический поиск)
         */


        // поиск элементов
        String[] str;                                   //const
        ArrayList<String> array;                        //const
        ArrayDeque<String> deque;                       //const

                                                        // коллизии не возникает, если правильно переопределить HashCode
        HashMap<String, String> hashMap;                //если коллизий нет - const, если есть -  liner
        HashSet hashSet;                                //если коллизий нет - const, если есть -  liner

        LinkedHashSet linkedHashSet;                    //const - ?
        LinkedHashMap linkedHashMap;                    //const - ?


        LinkedList list;                                //liner

        TreeMap treeMap;                                //logarithmic
        TreeSet treeset;                                //logarithmic





    }
}
