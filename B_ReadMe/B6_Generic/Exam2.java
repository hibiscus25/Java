package B_ReadMe.B6_Generic;

//------------------------------------ обобщенный класс с несколькими параметрами --------------------------------------
    public class Exam2<X> {
        private X first;

        Exam2(X first){
            set(first);
        }

        void set(X first){
            this.first=first;
        }

        X get(){
            return first;
        }
    }


    class Second<X, Y> {
        Exam2<X> obj;

        Y second;

        Second(X first, Y second) {
            obj = new Exam2<X>(first);
            this.second = second;
        }

        void show(){
            System.out.println("Значение " + obj.get() + " и " + second);
        }
    }


    class UsingGenericDemo {
        public static void main(String[] args) {
            Second<Integer,Character> A=new Second<>(100,'B');
            A.show();

            Second<String,Double> B=new Second<>("Bravo",12.345);
            A.show();
        }
    }