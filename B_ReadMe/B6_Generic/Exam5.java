package B_ReadMe.B6_Generic;

//----------------------------------- cоздание нестатического обобщенного метода ---------------------------------------
    public class Exam5 {
        String name;

        <X> void show(X arg){
            System.out.println(name + " : " + arg);
        }

        Exam5(String txt){
            name=txt;
        }
    }


    class UsingGenMethodsDemo {
        public static void main(String[] args) {
            Exam5 A = new Exam5("Объект A");
            Exam5 B = new Exam5("Объект B");

            A.show(123);
            A.show("Alpha");
            A.show('A');

            B.show(123);
            B.show("Bravo");
            B.show('B');
        }
    }