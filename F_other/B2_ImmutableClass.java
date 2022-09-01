package F_other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class B2_ImmutableClass {
    public static void main(String[] args) {
        MyImmutable myImmutable = new MyImmutable(5, new ArrayList<>(), "hello", new Person());
            myImmutable.getPerson().age = 5;
        System.out.println(myImmutable.getPerson().age);
    }


    final static class MyImmutable{                             // класс, который не изменяется
        private final int i;
        private final List<String> list;
        private final String str;
        private final Person person;
    //    private final Object object;

        public MyImmutable(int i, List<String> list, String str, Person person){
            this.i = i;                                                     // изначально immutable
            this.list = Collections.unmodifiableList(cloneList(list));
            this.str = str;                                                 // изначально immutable
            this.person = (Person) person.clone();                          // есть доступ поэтому clone
           // this.object = object;                                         // классы к которым нет доступа, нужно писать обертку
        }

        private List<String> cloneList(List<String> list){
            List<String> clone = new ArrayList<>(list.size());
            for(String el : list)
                clone.add(el);
            return clone;
        }

        public int getI() {
            return i;
        }

        public List<String> getList() {
            return list;
        }

        public String getStr() {
            return str;
        }

        public Person getPerson() {
            return (Person) person.clone();
        }
    }


    static class Person implements Cloneable{
        int age;

        @Override
        protected Object clone(){
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
