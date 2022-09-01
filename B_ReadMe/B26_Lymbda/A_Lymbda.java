package B_ReadMe.B26_Lymbda;


//--------------------- использования функционального интерфейса и лямбда - выражений ----------------------------------
interface MyNums {                                                      // функциональный интерфейс
    default void show(int n){
        System.out.println("  Аргумент: " + n + "     " + "  Результат: " + get(n));
    }

    int get(int n);
}


class Function implements MyNums{                                 // 1 - вар:   отдельный класс
    @Override
    public int get(int n) {
        int k, s = 0;
        for (k = 1; k <= n; k++) {
            s += k;
        }
        return s;
    }
}


public class A_Lymbda {
    public static void main(String[] args) {
        Function clas = new Function();                               // отдельный класс

        MyNums anonClass = new MyNums() {                             // 2 - вар: анонимный класс
            public int get(int n) {
                int k, s = 0;
                for (k = 1; k <= n; k++) {
                    s += k;
                }
                return s;
            }
        };

        MyNums lymbda = (int n) -> {                                   // 3 - вар: лямбда, вместо анонимного класса
            int k, s = 0;
            for (k = 1; k <= n; k++) {
                s += k;
            }
            return s;
        };


        System.out.println("Отдельный класс");
            clas.show(10);
        System.out.println("Анонимный класс");
            anonClass.show(10);
        System.out.println("Лямбда");
            lymbda.show(10);
        System.out.println("ПРОВЕРКА: ");
        System.out.println(" - Отдельный класс: " + clas.get(10));
        System.out.println(" - Анонимный класс: " + anonClass.get(10));
        System.out.println(" - Лямбда: " + lymbda.get(10));
        System.out.println("---------------------------------------------------");


        System.out.println("Отдельный класс");
            Function clas2 = new Function(){
                @Override
                public int get(int n) {
                    return n * n;
                }
            };
            clas.show(10);
            clas2.show(20);
        System.out.println("Анонимный класс");
            MyNums anonClass2 = new MyNums() {
                public int get(int n) {
                    return n * n;
                }
            };
            anonClass.show(10);
            anonClass2.show(20);
        System.out.println("Лямбда");
            MyNums lymbda2 =  n -> n * n;
            lymbda.show(10);
            lymbda2.show(20);
    }
}
