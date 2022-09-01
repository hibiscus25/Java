package B_ReadMe.B3_StaticBlock;

    public class StaticBlock3Parent {
        StaticBlock3Parent() {
            System.out.println("parent constructor");           // 2 - конструктор родителя
        }
    }

    class InitExample extends StaticBlock3Parent {
        static {
            System.out.println("static init block");            // 1  - cтатический блок
        }

        {
            System.out.println("init block");                   // 3  - не статический блок
        }

        InitExample() {
            super();
            System.out.println("constructor");                  // 4  - конструктор
        }

        public static void main(String[] args) {
            new InitExample();
        }
    }