package B_ReadMe.B6_Generic;

//--------------------------------------- суперкласс (нет) - наследники (generic) --------------------------------------
    public class Exam8 {
        String data;

        Exam8(String data){
            this.data=data;
        }

        void show(){
            System.out.print("Поле суперкласса: " + data + " - ");
        }
    }

    //-----------------------------------------------------------------------------
    class Generics<T> extends Exam8 {
        private T name;

        Generics(String data, T name){
            super(data);
            this.name = name;
        }

        void show(){
            super.show();
            System.out.println("  Поле наследника: " + name);
        }
    }

    //-----------------------------------------------------------------------------
    class FinMethod{
        public static void main(String[] args) {
            Generics<Integer> A = new Generics("String", 1_000);
            Generics<String> B = new Generics("String", "strings");
            A.show();
            B.show();
        }
    }


