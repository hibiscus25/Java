package C1_Pattern.B_structural;


interface CarI{
    void drive();
}


class Reno implements CarI{
    @Override
    public void drive() {
        System.out.println("drive reno");
    }
}

//------------------------------------------------------------
class CarProxy implements CarI{
    CarI car = new Reno();

    @Override
    public void drive() {
        System.out.println("proxy code");
        car.drive();
    }
}

//------------------------------------------------------------
public class M2_Proxy {
    public static void main(String[] args) {
        CarI car = new CarProxy();
        car.drive();
    }
}
