package B_ReadMe.B26_Lymbda;


//-------------------------------------------- ссылка на конструктор Kласса --------------------------------------------
interface MyInterface {         //  критерии удовлетворяют выражение вида    new MyClass(число)
    MyClass3 create(int n);     //        - интерфейс возвращает значение типа MyClass3
}                               //        - аргумент метода совпадает с аргументом конструктора MyClass3


class MyClass3 {
    private int number;

    MyClass3 (int n){
        number=n;
    }

    void show(){
        System.out.println("Значение поля: " + number);
    }

    void set(int n){
        number=n;
    }
}


class F_ConstructorReferenceDemo {
    public static void main(String[] args) {
        MyInterface ref = MyClass3 :: new;      // после этого вызов ref.create(100) == new MyClass(100)
        MyClass3 obj = ref.create(100);
            // aналогичный вариант           MyInterface ref1 = (n) -> new MyClass3(n);
            //                               MyClass3 obj = ref1.create(100);
            obj.show();
            obj.set(200);
            obj.show();
    }
}