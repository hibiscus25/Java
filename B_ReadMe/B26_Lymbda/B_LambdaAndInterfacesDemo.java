package B_ReadMe.B26_Lymbda;


//------------------------------------ несколько интерфейсов и ссылка на метод -----------------------------------------
interface Alpha {
    default void show(int n){
        System.out.println(n);
    };

    void showA();
}

interface Bravo {
    void showB();
}

interface Charlie {
    default void show2(int n, int a){
        System.out.println(n + "   " + a);
    };

    void showC();
}


public class B_LambdaAndInterfacesDemo {
    public static void main(String[] args) {
        Alpha A = ()-> System.out.println("Лямбда - выражение - 1");
        A.showA();

        Bravo B = ()-> System.out.println("Лямбда - выражение - 2");
        B.showB();

    /*        Даже учитывая, что  А и B присваиваются одинаковые значения (л - выражения),
        присвоить значение одной переменной другую нельзя.
                   A = B;                   // ошибка

              Также нельзя присвоить переменной С значение переменной А, или переменной В.
                   Charlie C = A;                   // ошибка
                   Charlie C2 = B;                  // ошибка

        Причина в том, что переменные относятся к разным типам, то есть к разным интерфейсам.
    */


    System.out.println("-------------------------------------------");
    /*  Но одинаковые лямбда - выражения  могут присваиваться переменным разных интерфейсов (в т.ч. функциональных)
             - достаточно, чтобы абстрактный метод в каждом таком интерфейсе соответствовал параметрам:
                    - количество аргументов
                    - тип аргументов
    */
        Charlie C = A::showA;               // присваивается ссылка на метод интерфейса A
        C.showC();

        Charlie D = B::showB;               // присваивается ссылка на метод интерфейса B
        D.showC();
    }
}
