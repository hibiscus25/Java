package B_ReadMe.B6_Generic;

//------------------------------------ обобщенные подстановки с ограничениями ------------------------------------------
    public class Exam17<T> {
        private T obj;

        Exam17(T arg){
            obj=arg;
        }

        public String toString(){
            return obj.toString();
        }
    }

    //-------------------------------------------------------------------------
        class Gamma {
            private String name;

            Gamma(String txt){
                name=txt;
            }

            public String toString(){
                return name;
            }
        }

        class Lava extends Gamma{
            Lava(String txt){
                super(txt);
            }
        }

        class Tora extends Lava{
            Tora (String txt){
                super(txt);
            }
        }

        class Sory extends Tora{
            Sory(String txt){
                super(txt);
            }
        }

        class Yul extends Sory{
            Yul (String txt){
                super(txt);
            }
        }

    //-------------------------------------------------------------------------
    class WildcardsDemo {
        static void show (Exam17<?  extends Tora> obj){
            System.out.println(obj);
        }

        static void display (Exam17<? super Tora> obj){
            System.out.println(obj);
        }


        public static void main(String[] args) {
            Exam17<Gamma> A=new Exam17<>(new Gamma("Объект А"));
            Exam17<Lava> B=new Exam17<>(new Lava("Объект B"));
                Exam17<Tora> C=new Exam17<>(new Tora("Объект C"));
                    Exam17<Sory> D=new Exam17<>(new Sory("Объект D"));
                    Exam17<Yul> E=new Exam17<>(new Yul("Объект E"));

            display(A);     // Exam17<?  extends Tora>     - только Tora и все его суперклассы
            display(B);
            display(C);
            System.out.println("---------------------------");
            show(C);        // Exam17<? super Tora>        - только Tora и все его наследники
            show(D);
            show(E);
        }
    }