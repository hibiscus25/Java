package B_ReadMe.B6_Generic;

//---------------------------------------------- обобщенная подстановка ------------------------------------------------
    public class Exam15<T> {
        T value;

        Exam15(T val){
            value=val;
        }
    }

    class WildcardDemo {
        static<T> void show(Exam15<T> obj){
            System.out.print("Mетод show(): ");
            System.out.println(obj.value);
        }

        static void display(Exam15<?> obj){
            System.out.print("Mетод display(): ");
            System.out.println(obj.value);
        }


        public static void main(String[] args) {
            Exam15<Integer> A=new Exam15<>(100);
            Exam15 B=new Exam15<>('B');
                Exam15<?> C=new Exam15<>("Объект С");

            show(A);
            display(A);
            System.out.println("---------------------------");
            show(B);
            display(B);
            System.out.println("---------------------------");
            show(C);
            display(C);
        }
    }

