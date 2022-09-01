package B_ReadMe.B6_Generic;

//-------------------------------------------- <X extends Суперкласс> --------------------------------------------------
    public class Exam11 {
        String name;

        Exam11(String txt){
            name=txt;
        }

        void show(){
            System.out.println("Текстовое поле: " + name);
        }
    }

    // ----------------------------------------- наследники --------------------------------------------
    class Ints extends Exam11 {
        int number;

        Ints(String txt, int n){
            super(txt);
            number=n;
        }

        void show(){
            super.show();
            System.out.println("Целочисленное поле: " + number);
        }
    }

    class Symbols extends  Ints {
        char symbol;

        Symbols(String txt, int n, char s){
            super(txt,n);
            symbol=s;
        }

        void show(){
            super.show();
            System.out.println("Cимвольное поле: " + symbol);
        }
    }

    // -------------------------------------- наследники с дженериком --------------------------------------------------
    class Generic <X extends Exam11>{               //подходит Суперкласс и его наследники
        X obj;

        Generic(X obj){
            this.obj=obj;
        }

        void show(){
            System.out.println("Объект класса MyClass");
            obj.show();
        }
    }

    // ---------------------------------- наследники без использования дженерика ---------------------------------------
    class Gen extends Exam11 {              // пример как нужно будет писать, если мы не используем дженерик
        Exam11 obj;

        Gen(Exam11 obj){
            super(obj.name);
            this.obj = obj;
        }

        void show(){
            System.out.println("Объект класса MyClass");
            obj.show();
        }
    }

    class Gena extends Exam11 {
        Ints obj;

        Gena(Ints obj){
            super(obj.name);
            this.obj = obj;
        }

        void show(){
            System.out.println("Объект класса MyClass");
            obj.show();
        }
    }

    class Genb extends Exam11 {
        Symbols obj;

        Genb(Symbols obj){
            super(obj.name);
            this.obj = obj;
        }

        void show(){
            System.out.println("Объект класса MyClass");
            obj.show();
        }
    }


    // -----------------------------------------------------------------------------------------------------------------
    class GenTypeExtendingDemo {
        public static void main(String[] args) {
            Exam11 ex = new Exam11("Mordor");
            Ints ints =new Ints("Alpha",123);
            Symbols symbols = new Symbols("Bravo",321,'B');

            Generic<Exam11> A=new Generic<>(ex);                //аргумент суперкласс
                Generic<Ints> B=new Generic<>(ints);                //аргумент наследник
                Generic<Symbols> C=new Generic<>(symbols);          //аргумент наследник

            Gen D = new Gen(ex);
                Gena E = new Gena(ints);
                Genb F = new Genb(symbols);

            // наследники
            ints.show();
            System.out.println();
            symbols.show();
            System.out.println("-----------------");

            // наследники с дженериком
            A.show();
            System.out.println();
            B.show();
            System.out.println();
            C.show();
            System.out.println("-----------------");

            // наследники без дженерика
            D.show();
            System.out.println();
            E.show();
            System.out.println();
            F.show();
        }
    }