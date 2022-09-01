package B_ReadMe.B6_Generic;

//------------------------------------ суперкласс (generic) - наследники (generic) -------------------------------------
    public class Exam7<X> {
        X data;

        Exam7(X data){
            this.data=data;
        }

        void show(){
            System.out.print("Поле суперкласса: " + data + " - ");
        }
    }

    //-----------------------------------------------------------------------------
    class Inta<T, S> extends Exam7<T> {
        private S name;

        Inta(T data, S name){
            super(data);
            this.name = name;
        }

        void show(){
            super.show();
            System.out.println("  Поле наследника: " + name);

        }
    }

    //-----------------------------------------------------------------------------
    class FinishMethod{
        public static void main(String[] args) {
            Inta<Integer, String> A = new Inta(1_000, "String" );
            Inta<String, Integer> B = new Inta("String", 1_000);
            A.show();
            B.show();
        }
    }