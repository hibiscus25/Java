package C1_Pattern.C_behavior;


import java.util.ArrayList;
import java.util.List;

// облегчает общение между объектами (пример radio button)
interface Mediator{
    void requestAll(Collegue collegue);
}

class ConcreteMediator implements Mediator{
    List<Collegue> coll = new ArrayList<>();

    void add(Collegue collegue){
        coll.add(collegue);
    }

    @Override
    public void requestAll(Collegue collegue) {
        collegue.setTrue();
        for(Collegue el : coll){
            if(el != collegue)
                el.setFalse();
        }
    }
}


//---------------------------------------------------------------------------------
interface Collegue{
    void setFalse();
    void setTrue();
    void changeStatus();
}

class ConcreteCollegue implements Collegue{
    boolean status;
    Mediator mediator;
    String name;

    public ConcreteCollegue(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println(name + " status is False");
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println(name + " status is True");
    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }

    @Override
    public String toString() {
        return "ConcreteCollegue{" +
                "status=" + status +
                ", mediator=" + mediator +
                ", name='" + name + '\'' +
                '}';
    }
}


//------------------------------------------------------------------------------------------
public class R2_Mediator {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
            mediator.add(new ConcreteCollegue(mediator, "One"));
            mediator.add(new ConcreteCollegue(mediator, "Two"));
            mediator.add(new ConcreteCollegue(mediator, "Three"));
            ConcreteCollegue concret = new ConcreteCollegue(mediator, "Four");
                mediator.add(concret);
        concret.changeStatus();
    }
}
