package B_ReadMe.B6_Generic;

import java.util.List;

//--------------------------------------------- Wildcard Capture -------------------------------------------------------
    public class Exam21 {

        void swap(List<?> list, int i, int j) {
//           list.set(i, list.get(j));      // Ошибка __ метод List.set() не может работать с List<?> - не известен тип List
        }


    // Напишем еще один метод с параметризованной переменной и будем его использовать внутри нашего метода.
        void swap2(List<?> list, int i, int j) {
             swapImpl(list, i, j);
        }

        <T> void swapImpl(List<T> list, int i, int j) {
            T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
        }
    }