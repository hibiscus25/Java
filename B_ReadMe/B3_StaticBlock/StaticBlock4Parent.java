package B_ReadMe.B3_StaticBlock;

    public class StaticBlock4Parent {
        static {
            System.out.println("static parent init block");     // 1 - cтатический блок родителя
        }

        StaticBlock4Parent() {
            System.out.println("parent constructor");           // 4 - конструктор
        }
    }

    class InitExample2 extends StaticBlock4Parent {
        static {
            System.out.println("static1 init block");           // 2 - статический блок класса
        }
        {
            System.out.println("init1 block");                  // 5 - не статический блок класса
        }

        InitExample2() {
            super();
            System.out.println("constructor");                  // 7 - конструктор
        }

        static {
            System.out.println("static2 init block");           // 3 - статический блок класса
        }
        {
            System.out.println("init2 block");                  // 6 - не статический блок класса
        }

        public static void main(String[] args) {
            new InitExample2();
        }
    }
