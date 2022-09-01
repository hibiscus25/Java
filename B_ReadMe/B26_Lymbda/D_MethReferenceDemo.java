package B_ReadMe.B26_Lymbda;


//--------------------------------------- ccылка на нестатический метод Kласса -----------------------------------------
interface MyGetter1 {
    int myGet(MyClass1 obj);                                    // в аргумент добавляется ссылка на объект
}


interface MySetter1 {
    void mySet(MyClass1 obj, int n);                            // в аргумент добавляется ссылка на объект
}


class MyClass1 {
    private int number;

    MyClass1(int n){
        number=n;
    }

    int get(){
        return number;
    }

    void set(int k){
        number=k;
    }
}


public class D_MethReferenceDemo {
    public static void main(String[] args) {
        MyClass1 obj = new MyClass1(100);
            System.out.println("Cоздан объект с полем 100");

    // ccылку на методы get/set() выполняем через класс, а не через объект
        MyGetter1 A = MyClass1::get;  // аналогично  (MyClass1 ob) -> ob.get()              or      (ob) -> ob.get()
        MySetter1 B = MyClass1::set;  // аналогично  (MyClass1 ob,int k) -> {ob.set(k)}     or      (ob, k) -> ob.set(k)


    /* в соответствии с новым форматом ссылок, иначе объявляются и методы myGet/mySet()
             - добавляется дополнительный первый аргумент, который является объектом MyClass
             - этот аргумент определяет объект, из которого вызывается соответственно метод  get() и set();
    */
        System.out.println(" - Переменная А: " + A.myGet(obj));
        System.out.println(" - Переменная obj: " + obj.get());
        System.out.println("---------------------------");

        obj.set(200);
        System.out.println("Полю присвоено значение 200");
        System.out.println(" - Переменная А: "+ A.myGet(obj));
        System.out.println("---------------------------");

        B.mySet(obj,300);
        System.out.println("Выполнена команда B.myset(obj,300)");
        System.out.println(" - Переменная А: "+ A.myGet(obj));
        System.out.println(" - Переменная obj: "+ obj.get());
        System.out.println("---------------------------");

        obj = new MyClass1(400);                                // создается новый объект
        System.out.println("Cоздан объект с полем 400");
        System.out.println(" - Переменная А: "+ A.myGet(obj));
        System.out.println(" - Переменная obj: "+ obj.get());
        System.out.println("---------------------------");

        B.mySet(obj,500);
        System.out.println("Выполнена команда B.myset(obj,500)");
        System.out.println(" - Переменная А: "+ A.myGet(obj));
        System.out.println(" - Переменная obj: "+ obj.get());
    }
}
