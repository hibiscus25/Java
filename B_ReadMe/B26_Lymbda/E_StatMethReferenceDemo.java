package B_ReadMe.B26_Lymbda;


//--------------------------------------- ссылка на статический метод Kласса -------------------------------------------
interface MyShow {
    void myShow();                                    // в аргумент ссылка на объект не нужна
}

interface MySum {
    int mySum(int n);                                 // в аргумент ссылка на объект не нужна
}

interface MyPrinter {
    void myPrint(Object t);
}


class MyClass2 {
    static void show(){
        System.out.println("Метод класса MyClass");
    }

    static int sum(int n){
        int k,s=0;
        for(k=1; k<=n; k++){
            s += k;
        }
        return s;
    }
}


public class E_StatMethReferenceDemo {
    public static void main(String[] args) {
        MyShow A    = MyClass2 :: show;
        MySum B     = MyClass2 :: sum;
        MyPrinter P = System.out :: println;                    // аналогично (o) -> System.out.println(o);
            A.myShow();
            P.myPrint("Cумма чисел: " + B.mySum(10));    // аргумент преобразуется в объект String
    }
}
