package B_ReadMe.B26_Lymbda;


//--------------------------------------- лямбда - выражение и поле объекта --------------------------------------------
interface MyInterface2 {
    int getNumber(int n);

}


class MyClass5 {
    private MyInterface2 ref;

    MyClass5(MyInterface2 mi){
        set(mi);
    }

    void set(MyInterface2 mi){
        ref=mi;
    }

    int get(int n){
        return ref.getNumber(n);
    }
}


public class J_LambdaAsFieldDemo {
    public static void main(String[] args) {

      MyClass5 obj = new MyClass5((int n)->{return n*n;});

        System.out.println("Аргумент:");
        for(int k = 0; k <= 5; k++)
            System.out.print(k + "\t");

        System.out.println();
        System.out.println("\nAргумент в квадрате: ");
        for(int k = 0; k <= 5; k++)
            System.out.print(obj.get(k) + "\t");


        obj.set((int n)->{return n*n*n;});
        System.out.println();
        System.out.println("\nАргумент в кубе: ");
        for(int k = 0; k <= 5; k++)
            System.out.print(obj.get(k) + "\t");
    }
}
