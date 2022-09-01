package B_ReadMe.B6_Generic;

//--------------------------------- cоздание обобщенного класса на основе интерфейса -----------------------------------
    interface MyMethods <X> {
        X get();
        void set(X arg);
    }


    public class Exam9<X> implements MyMethods<X> {
        private X value;

        Exam9(X arg){
            value=arg;
        }

        void show(){
            System.out.println("Значение поля: " + get());
        }

        public X get(){
            return value;
        }

        public void set (X arg){
            value=arg;
        }
    }


    class GenInterfaceDemo {
        public static void main(String[] args) {
            MyMethods ref;
                Exam9<Integer> A=new Exam9<>(123);
                Exam9<Character> B=new Exam9<>('A');
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
