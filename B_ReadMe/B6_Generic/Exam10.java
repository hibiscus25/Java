package B_ReadMe.B6_Generic;

//----------------------------- cоздание обычного класса на основе обобщенного интерфейса ------------------------------
    interface MyInterface<X> {
        X get();
        void set(X arg);
    }


    public class Exam10 implements MyInterface<Integer>{
        private Integer value;

        Exam10(Integer arg){
            value=arg;
        }

        void show(){
            System.out.println("Целочисленное поле: " + get());
        }

        public Integer get(){
            return value;
        }

        public void set(Integer arg){
            value=arg;
        }
    }


    class Symb implements MyInterface<Character>{
        private Character value;

        Symb(Character arg){
            value=arg;
        }

        void show(){
            System.out.println("Cимвольное поле: " + get());
        }

        public Character get(){
            return value;
        }

        public void set(Character arg) {
            value = arg;
        }
    }


    class MoreGenInterfaceDemo {
        public static void main(String[] args) {
            MyInterface ref;
                Exam10 A=new Exam10(123);
                Symb B=new Symb('A');
                A.show();

                ref=A;
                ref.set(321);
                A.show();
                B.show();

                ref=B;
                ref.set('B');
                B.show();
        }
    }