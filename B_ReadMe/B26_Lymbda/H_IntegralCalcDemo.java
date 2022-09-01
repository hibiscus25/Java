package B_ReadMe.B26_Lymbda;


//---------------------------------- передача лямбда - выражения аргументом методу -------------------------------------
interface MyFunction {
    double method(double x);
}

public class H_IntegralCalcDemo {

    static double integrate(MyFunction obj, double a, double b){
        int n = 100;
        double h = (b-a) / n;
        double s = (obj.method(a) + obj.method(b)) * h / 2;           //через лямбду считает значение a и b
        for(int k=1; k <= n-1; k++)
            s += h * obj.method(a + k * h);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(" -       : " + integrate((x)->{return x*(1-x);},0,1));
        System.out.println(" - точное: " + 1.0/6);
        System.out.println("------------------------------");

        System.out.println(" -       : " + integrate((x)->{return 1/x;},1,2));
        System.out.println(" - точное: " + Math.log(2));
        System.out.println("------------------------------");

        System.out.println(" -       : " + integrate((x)->{return Math.exp(-x);},0,10));
        System.out.println(" - точное: " + (1 -Math.exp(-10)));
        System.out.println("------------------------------");
    }
}
