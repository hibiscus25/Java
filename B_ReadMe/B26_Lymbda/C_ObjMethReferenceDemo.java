package B_ReadMe.B26_Lymbda;


//-------------------------------------------- ссылка на метод Oбъекта -------------------------------------------------
interface MyGetter {
    int myGet();
}


interface MySetter {
    void mySet(int n);
}


class MyClass {
    private int number;

    MyClass(int n){
        number=n;
    }

    int get(){
        return number;
    }

    void set(int k){
        number=k;
    }
}



public class C_ObjMethReferenceDemo {
    public static void main(String[] args) {
        MyClass obj = new MyClass(100);
            System.out.println("Cоздан объект с полем 100");

    // сигнатура myGet()        интерфейса MyGetter     cоответствует       сигнатуре метода get()      MyClass
    //           mySet(int n)   интерфейс MySetter      cоответствует       сигнатуре метода set(int n) MyClass

    /* интерфейсным переменным присваиваются ссылки на методы объекта obj  ( obj :: get/set)
            - при таком присваивании:
                    - создается объект анонимного класса, в котором реализуется интерфейс MyGetter/MySetter
                    - при этом метод myGet/mySet() определяется как вызов метода get/set() из MyClass()
                    - то есть при вызове myGet/mySet() на самом деле вызывается метод get/set() из obj
    */
        MyGetter A = obj::get;
        MySetter B = obj::set;

        System.out.println(" - Переменная A: " + A.myGet());
        System.out.println(" - Переменная obj: " + obj.get());
        System.out.println("----------------------------");

        obj.set(200);
        System.out.println("Полю присвоено значение 200");
        System.out.println(" - Переменная A: "+ A.myGet());
        System.out.println("----------------------------");

        B.mySet(300);
        System.out.println("Выполнена команда B.mySet(300)");
        System.out.println(" - Переменная A: "+ A.myGet());
        System.out.println(" - Переменная obj: " + obj.get());
        System.out.println("----------------------------");

        obj = new MyClass(400);                                         // cоздается новый объект
        System.out.println("Cоздан объект с полем 400");
        System.out.println(" - Переменная A: "+ A.myGet());                 // значение предыдущего объекта
        System.out.println(" - Переменная obj: " + obj.get());
        System.out.println("----------------------------");

        B.mySet(500);
        System.out.println("Выполнена команда B.mySet(500)");
        System.out.println(" - Переменная A: "+ A.myGet());
        System.out.println(" - Переменная obj: " + obj.get());
    }
}
