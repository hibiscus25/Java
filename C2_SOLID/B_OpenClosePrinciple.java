package C2_SOLID;

// каждый модуль должен быть открыт для расширения, но закрыт для модификации

interface Car{
    void workInTaxi();
}


class Toyota implements Car{
    void getPasangers(){
        System.out.println("get passangers");
    }

    @Override
    public void workInTaxi() {
        getPasangers();
    }
}

class Celica extends Toyota{
    void getPasangers(){
        System.out.println("get one passanger");
    }

    @Override
    public void workInTaxi() {
        getPasangers();
    }
}

//-----------------------------------------------------------
public class B_OpenClosePrinciple {
    static void workInTaxi(Car car){
        car.workInTaxi();
    }

    public static void main(String[] args) {
        Toyota toyota = new Toyota();
        workInTaxi(toyota);

        Celica celica = new Celica();
        workInTaxi(celica);
    }
}
