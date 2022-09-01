package C1_Pattern.B_structural;

// ---------------------------- (обертка) превращает старый интерфейс в новый интерфейс --------------------------------
class CarWash{
    public void washCar(Cars cars){
        cars.wash();
    }
}

//------------------------------------------------------------------
interface Cars{
    void wash();
}

class AudiCar implements Cars{
    @Override
    public void wash() {
        System.out.println("wash car Audi");
    }
}

class ToyotaCar implements Cars{
    @Override
    public void wash() {
        System.out.println("wash car Toyota");
    }
}

//--------------------------- Adapter -----------------------------
class TrackWrap implements Cars{
    Track track;

    public TrackWrap(Track track){
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}

//------------------------------------------------------------------
interface Track{
    void clean();
}

class MyTrack implements Track{
    @Override
    public void clean() {
        System.out.println("track is clean");
    }
}

//------------------------------------------------------------------
public class F2_Adapter {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
            carWash.washCar(new AudiCar());
            carWash.washCar(new ToyotaCar());
            carWash.washCar(new TrackWrap(new MyTrack()));
    }
}
