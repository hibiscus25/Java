package C1_Pattern.A_сreational;

//--------------------------------------------- Factory 1 --------------------------------------------------------------
interface Bicycle{
    void drive();
}

class Trek implements Bicycle{
    @Override
    public void drive() {
        System.out.println("drive Trek");
    }
}

class Scott  implements Bicycle{
    @Override
    public void drive() {
        System.out.println("drive Scott");
    }
}

class FactoryBicycle implements FactoryInterface{
    public Bicycle createBicycle(String typeOfBicycle){
        switch (typeOfBicycle){
            case "Trek":
                return new Trek();
            case "Scott":
                return new Scott();
            default:
                return null;
        }
    }

    @Override
    public Tank createTank(String typeOfTank) {
        return null;
    }
}


//--------------------------------------------- Factory 2 --------------------------------------------------------------
interface Tank{
    void drive();
}

class Leopard implements Tank{
    @Override
    public void drive() {
        System.out.println("drive Leopard");
    }
}

class T72  implements Tank{
    @Override
    public void drive() {
        System.out.println("drive T72");
    }
}

class FactoryTank implements FactoryInterface{

    public Tank createTank(String typeOfTank){
        switch (typeOfTank){
            case "Leopard":
                return new Leopard();
            case "T72":
                return new T72();
            default:
                return null;
        }
    }

    @Override
    public Bicycle createBicycle(String typeOfBicycle) {
        return null;
    }
}


//-------------------------------------------Abstract Factory ----------------------------------------------------------
interface FactoryInterface{
    Bicycle createBicycle(String typeOfBicycle);
    Tank createTank(String typeOfTank);
}


class AbstractFactory{
    FactoryInterface createFactory(String typeOfFactory){
        switch (typeOfFactory){
            case "Bicycle":
                return new FactoryBicycle();
            case "Tank":
                return new FactoryTank();
            default:
                return null;
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------
public class A22_AbstractFactory {
    public static void main(String[] args) {
        FactoryInterface BicycleFactory = new AbstractFactory().createFactory("Bicycle");
        FactoryInterface TankFactory = new AbstractFactory().createFactory("Tank");
            Bicycle trek = BicycleFactory.createBicycle("Trek");
            Bicycle scott = BicycleFactory.createBicycle("Scott");
            Tank leopard = TankFactory.createTank("Leopard");
            Tank t72 = TankFactory.createTank("T72");

            trek.drive();
            scott.drive();
            leopard.drive();
            t72.drive();

    }
}

