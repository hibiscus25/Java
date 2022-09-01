package B_ReadMe.B6_Generic;

//-------------------------------------- суперкласс (generic) - наследники (нет) ---------------------------------------
    public class Exam6<X> {
        X data;

        Exam6(X data){
            this.data=data;
        }

        void show(){
            System.out.println(data);
        }
    }

    //-----------------------------------------------------------------------------
    class Int extends Exam6<Integer> {
        Int(Integer n){
            super(n);
        }

        void show(){
            System.out.print("Целочисленное поле: ");
            super.show();
        }
    }

    class Str extends Exam6<String> {
        Str(String txt) {
            super(txt);
        }

        void show() {
            System.out.print("Текстовое поле: ");
            super.show();
        }
    }

    class Symbol extends Exam6<Character> {
        Symbol(Character s){
            super(s);
        }

        void show(){
            System.out.print("Cимвольное поле: ");
            super.show();
        }
    }

    //-----------------------------------------------------------------------------
    class ExtendingGenClassDemo {
        public static void main(String[] args) {
            Int A=new Int(123);
            Str B=new Str("объект В");
            Symbol C=new Symbol('C');

            A.show();
            B.show();
            C.show();
        }
    }