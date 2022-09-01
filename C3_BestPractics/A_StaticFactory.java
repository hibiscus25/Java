package C3_BestPractics;

public class A_StaticFactory {
    public static void main(String[] args) {
        Car car = Car.getSportCar();
    }
}

class Car{
    String color;
    int doors;

    private Car(String color){
        this.color = color;
    }

    private Car (int doors){
        this.doors = doors;
    }

    public static Car getWhiteCar(){            // используются такие методы, когда много констркторов,
        return  new Car("white");         // это удобно т.к. из названия можно интуитивно понять, что возвращает метод
    }

    public static Car getSportCar(){
        return new Car (2);
    }

}
