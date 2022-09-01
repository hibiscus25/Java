package B_ReadMe.B9_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// быстрый поиск по коллекции
public class VBinarySearch {
    public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
                list.add(5);
                list.add(1);
                list.add(8);
                list.add(7);
                list.add(3);
            System.out.println("До сортировки:  " + list);

        Collections.sort(list);                                // без сортировки данный метод не работает
            System.out.println("После сортировки:  " + list);
        int index = Collections.binarySearch(list, 7);    // Exception - если такого значения нет
        System.out.println("Index = " + index);                     // находит индекс уже отсортированной коллекции
        System.out.println("Value = " + list.get(index));
            System.out.println("list в дальнейшем остается отсортированным :  " + list);
        System.out.println("-------------------------------------------------------------------------");

        System.out.println();
        List<String> lis = new ArrayList<>();
            lis.add("Николай");
            lis.add("Василий");
            lis.add("Юля");
            lis.add("Жанна");
            lis.add("Саша");
        System.out.println("До сортировки:  " + lis);

        Collections.sort(lis);
        System.out.println("После сортировки:  " + lis);
        int ind = Collections.binarySearch(lis, "Жанна");       // учитывает регистр
        System.out.println("Index = " + ind);
        System.out.println("Value = " + lis.get(ind));
        System.out.println("list в дальнейшем остается отсортированным :  " + lis);
        System.out.println("-------------------------------------------------------------------------");
    }
}
