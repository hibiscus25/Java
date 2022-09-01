package C1_Pattern.C_behavior;

//позволяет сохранить  статус объекта в другой объект
class Originator{                                       // класс, что хотим сохранить
    String state;

    Momento createMomento(){
        return new Momento(state);
    }

    void getDateFromMomento(Momento momento){
        this.state = momento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


class Momento{                                          // класс, куда хотим сохранять
    String state;

    public Momento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}


//--------------------------------------------------------------------------------------------
class CareTaker{                                        // класс, который забоиться о процессе
    Momento momento;

    public Momento getMomento() {
        return momento;
    }

    public void setMomento(Momento momento) {
        this.momento = momento;
    }
}


//--------------------------------------------------------------------------------------------
public class S2_Momento {
    public static void main(String[] args) {
        Originator originator = new Originator();
            originator.setState("one");
        System.out.println(originator.getState());

        CareTaker careTaker = new CareTaker();
            careTaker.setMomento(originator.createMomento());

        System.out.println();
        originator.setState("two");
            System.out.println(originator.getState());
        originator.getDateFromMomento(careTaker.getMomento());
            System.out.println(originator.getState());
    }
}
