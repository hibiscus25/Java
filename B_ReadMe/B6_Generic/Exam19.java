package B_ReadMe.B6_Generic;

import java.util.ArrayList;
import java.util.Collection;

//------------------------------------------ Lower bounded wildcard ----------------------------------------------------
    class Test implements Comparable<Object> {
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }


    public class Exam19 {
            //  <T extends Comparable<T>>     -   обозначает что Т обязан реализовывать интерфейс Comparable<T>
        static  <T extends Comparable<T>> T max(Collection<T> c) {
            return null;
        }

            // Lower bounded wildcard - метод не только для T, но и для его супер типов (родительских типов)
        static <T extends Comparable<? super T>> T newMax(Collection<T> c) {
            return null;
        }


        public static void main(String[] args) {
            Integer I = max(new ArrayList<Integer>());
//          Test t = max(new ArrayList<Test>());       // Ошибка____из-за того, что Test  реализует интерфейс Comparable<Object>

            Integer Ii = newMax(new ArrayList<Integer>());
            Test tt = newMax(new ArrayList<Test>());
        }
    }
