package C1_Pattern.E_Other;

interface Animal{
    void eat();
}

class Lion implements Animal{
    @Override
    public void eat() {
        System.out.println("Lion eat");
    }
}

//-----------------------------------------------------
class NoAnimal implements Animal{
    @Override
    public void eat() {
    }
}

//-----------------------------------------------------
public class NullObject {
    static Animal getAnimal(){
        try{

        }finally{
            return new NoAnimal();                              // чтобы не возвращать null, создаем класс
        }
    }

    public static void main(String[] args) {
        Animal animal = getAnimal();
    }
}
