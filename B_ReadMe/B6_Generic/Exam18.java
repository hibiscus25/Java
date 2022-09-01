package B_ReadMe.B6_Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//--------------------------------------------- Bounded Wildcard -------------------------------------------------------
    public class Exam18 {
        int a;

        Exam18(int a){
            this.a = a;
        }

        public String toString(){
            return "Exam - " + a;
        }
    }

    class Sub extends Exam18 {
        int b;

        Sub(int a, int b) {
            super(a);
            this.b = b;
        }

        public String toString(){
            return "Sub - " + b;
        }
    }

    class Fin{
        static void draw(List<Exam18> c) {
            Iterator<Exam18> i = c.iterator();
                while (i.hasNext())
                    System.out.println(i.next());
        }

        static void Draw(List<? extends Exam18> c) {
            Iterator<? extends Exam18> i = c.iterator();
                while (i.hasNext())
                    System.out.println(i.next());
        }


        public static void main(String[] args) {
            List<Exam18> l = new ArrayList<>();
                l.add(new Exam18(5));
                l.add(new Exam18(15));
            List<Sub> ll = new ArrayList<>();
                ll.add(new Sub(10,30));
                ll.add(new Sub(20,40));

            draw(l);    // ОК
//          draw(ll);   // Ошибка из-за несовместимости типов
            System.out.println("--------------");

            // Использование <? super Exam301> позволяет использовать тип Sub и всех его предков вплоть до Object
            Draw(l);
            Draw(ll);
        }
    }
