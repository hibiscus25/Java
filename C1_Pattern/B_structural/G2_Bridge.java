package C1_Pattern.B_structural;

//TODO не понятен вообще смысл этого паттерна
interface IBridge{
    void drive();
}
//------------------------------------------------------------------------------
class CarBridge implements IBridge{

    @Override
    public void drive() {
        System.out.println("drive car");
    }
}

class TrackBridge implements IBridge{

    @Override
    public void drive() {
        System.out.println("drive track");
    }
}

//------------------------------------------------------------------------------
abstract class ICar{
    IBridge iBridge;

    public ICar(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract  void drive();
}


class ToyotaCars extends ICar{

    public ToyotaCars(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive toyota");
    }
}

class AudiCars extends ICar{

    public AudiCars(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive audi");
    }
}


//------------------------------------------------------------------------------
abstract class ITrack{
    IBridge iBridge;

    public ITrack(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract  void drive();
}


class ToyotaTrack extends ITrack{

    public ToyotaTrack(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive toyota+");
    }
}

class AudiTrack extends ITrack{

    public AudiTrack(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive audi+");
    }
}



//------------------------------------------------------------------------------
public class G2_Bridge {
    public static void main(String[] args) {
        ICar car = new ToyotaCars(new CarBridge());
            car.drive();
        ITrack track = new AudiTrack(new TrackBridge());
            track.drive();
    }
}
