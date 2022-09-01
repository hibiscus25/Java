package B_ReadMe.B6_Generic;

//---------------------------------------  обобщенный класс с одним параметром типа -----------------------------------
    public class Exam1<T> {             // буква T в Exam1<T> указываем, что данный тип T будет использоваться этим классом
        T data;                         //              - вместо T можно подставить любой тип переменной
                                        //              - буква Т выбрана произвольно
        Exam1(T data){
            this.data=data;
        }

        void show(){
            System.out.println("Значение поля: " + data);
        }
    }

    class UsingGenClassDemo {
        public static void main(String[] args) {
            Exam1<Integer> A = new Exam1<Integer>(100);                 // будет использоваться Integer
            Exam1<Character> B = new Exam1<Character>('B');               // будет использоваться Character
            Exam1<String> C = new Exam1<>("Зеленый");             // будет использоваться String
            A.show();
            B.show();
            C.show();
        }
    }

