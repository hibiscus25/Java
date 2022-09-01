package C1_Pattern.A_сreational;

class Person{
    // пустой конструктор
    private Person(){
    }

    // метод, который возвращает сам себя
    public static Person  create(){
        return new Person();
    }
}

public class A31_FactoryMethod {
    public static void main(String[] args) {
        Person person = Person.create();
    }
}