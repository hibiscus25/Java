package B_ReadMe.B26_Lymbda;


//-------------------------------------- ссылка на перегруженный метод Объекта -----------------------------------------
interface Alpha1 {
    void none();
}


interface Bravo1 {
    void one(int n);
}


class MyClass4 {
    int number;

    void set(){
        number=5;
    }

    void set(int n){
        number=n;
    }
}


public class G_OverloadedMethRefDemo {
    public static void main(String[] args) {
        MyClass4 obj = new MyClass4();
            Alpha1 A = obj::set;            // ссылается на set()       так как нет аргументов
            Bravo1 B = obj::set;            // ссылается на set(int n)  так как один целочисленный аргумент

        A.none();
            System.out.println("Значение поля: " + obj.number);
        B.one(100);
            System.out.println("Значение поля: " + obj.number);
    }
}
