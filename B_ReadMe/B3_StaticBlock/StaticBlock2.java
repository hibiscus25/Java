package B_ReadMe.B3_StaticBlock;

public class StaticBlock2 {
    static int a;
    static int b = 6;
    int aa;
    int bb = 6;

    static { System.out.println("static initializer");}
    static { System.out.println("second initializer");}
    { System.out.println("initializer");}
    { System.out.println("second initializer");}

    StaticBlock2(){
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println(a);
        new StaticBlock2();
        new StaticBlock2();
    }
}

// - изначально инициализируются  статические поля/блоки инициализации, потом не статические
//         - если запрашиваем только статическое значение System.out.println(a) , будет
//                  - инициализация статического поля
//                  - инициализация статических блоков
//                  - напечатает значение а
//         - если запускаем new StaticBlock();
//                  - сначала инициализируются статические поля/блоки
//                  - потом инициализируются не статические поля/блоки
//                  - статические поля / блоки инициализируются только один раз, не статические - каждый раз