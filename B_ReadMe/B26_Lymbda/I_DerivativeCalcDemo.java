package B_ReadMe.B26_Lymbda;


//------------------------------------ лямбда - выражение и результат метода -------------------------------------------
interface MyFunction1 {
    double method(double x);
}

// для примера без лямбда-выражения
class TempA implements MyFunction1{
    @Override
    public double method(double x) {
        return x*(3-x);
    }
}


public class I_DerivativeCalcDemo {
    // без лямбда-выражения
    static MyFunction1 DerivativeAnalog(MyFunction1 ref2) {
        double dx = 1e-5;

        MyFunction1 link = new MyFunction1() {
            @Override
            public double method(double x) {
                return (ref2.method(x + dx) - ref2.method(x))/dx;
            }
        };
        return link;
    }


    //лямбда-выражение
    static MyFunction1 Derivative(MyFunction1 ref) {
        double dx = 1e-5;
        return (x) -> {return (ref.method(x + dx) - ref.method(x)) / dx;};
    }


    public static void main(String[] args) {
    // аналогия без лямбда-выражения
        TempA tempA = new TempA();                          // создаем класс, который имплементирует интерфейс
        MyFunction1 tA = DerivativeAnalog(tempA);           // получаем ссылку на  link, связывая  tempA и link
        // tA.method(t)                                     // вызываем link.method(t)

    // лямбда-выражение
        MyFunction1 A = Derivative((x)-> {return x*(3-x);});

        System.out.println("Производная для первой функции");
        System.out.println("Вычислено:\t Tочно:\t\tБез лямбды");
        for(double t = 0; t <= 5; t++)
            System.out.printf("%8.5f\t%8.5f\t%8.5f\n", A.method(t), (3 - 2 * t), tA.method(t));
        System.out.println("------------------------------");

    //------------------------------------------------------------------------------------------------------
        MyFunction1 B = Derivative((x)-> {return x*Math.exp(-x);});

        System.out.println("Производная для второй функции");
        System.out.println("Вычислено:\t Точно:");
        for(double t=0; t<=5; t++)
            System.out.printf("%8.5f\t%8.5f\n", B.method(t), Math.exp(-t)*(1-t));
    }
}
