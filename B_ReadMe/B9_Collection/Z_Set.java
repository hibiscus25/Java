package B_ReadMe.B9_Collection;

import java.util.*;

public class Z_Set {
    public static void main(String[] args) {
        Set<String> hashset = new HashSet<>();          // 3 имплементации
        Set<String> linkset = new LinkedHashSet<>();
        Set<String> treeset = new TreeSet<>();

        // можно ложить null
//            hashset.add(null);
//                System.out.println(hashset.contains(null));  // да
//            linkset.add(null);
//                System.out.println(linkset.contains(null));  // да
         //   treeset.add(null);                                          // NullPointerExceptio
         //       System.out.println(treeset.contains(null));  // нет       // NullPointerExceptio


        // разница между 3 имплементациями
            hashset.add("one");
            hashset.add("two");
            hashset.add("three");
            hashset.add("four");
            hashset.add("five");
        System.out.println(hashset);        // хранит в рондомном порядке

            linkset.add("one");
            linkset.add("two");
            linkset.add("four");
            linkset.add("three");
            linkset.add("five");
        System.out.println(linkset);        // хранит в порядке добавления

            treeset.add("e");
            treeset.add("a");
            treeset.add("a");
            treeset.add("d");
            treeset.add("b");
        System.out.println(treeset);       // хранит в отсортированном (натуральному) порядке


        // cколько раз запуститься equals  и hashcode
        Set<Student> hash = new HashSet<>();
        // hashcode  -  5 раз,  equals - 1
            // cначала проверяет совпадение по hash, если совпадение есть - проверяет equals
            hash.add(new Student (1));
            hash.add(new Student (1));
            hash.add(new Student (3));
            hash.add(new Student (4));
            hash.add(new Student (5));
        System.out.println(hash);


        System.out.println();
        Set<Student> linhash = new LinkedHashSet<>();
        // LinkedHashCode  -  5 раз,  equals - 1
            linhash.add(new Student (1));
            linhash.add(new Student (1));
            linhash.add(new Student (3));
            linhash.add(new Student (4));
            linhash.add(new Student (5));
        System.out.println(linhash);


        System.out.println();
        Set<Student> thash = new TreeSet<>();
        // ни одного раза, так как все делает через compareTo
        // compareTo нужно делать по всем элементам
            thash.add(new Student (20));
            thash.add(new Student (1));
            thash.add(new Student (4));
            thash.add(new Student (1));
            thash.add(new Student (5));
        System.out.println(thash);
    }



    static class Student implements Comparable{
        int id;

        public Student(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }


        @Override
        public int compareTo(Object o) {
            System.out.println("compareTO = " + (id - ((Student) o).id) + "   id = " + id + "   o.id = " + ((Student) o).id);
            return id - ((Student) o).id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    '}';
        }
    }
}
