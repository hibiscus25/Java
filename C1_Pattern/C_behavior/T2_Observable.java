package C1_Pattern.C_behavior;


import java.util.ArrayList;
import java.util.List;

class Observer{
    static List<Observer> observers = new ArrayList<>();
    String name;
    String state;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state){
        this.state = state;
        notifyAllObservers();
    }

    void notifyAllObservers(){
        for (Observer el : observers)
            el.update();
    }

    void update(){
        System.out.println(name + " change status: " + state);
    }

    @Override
    public String toString() {
        return "Observer{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}


public class T2_Observable {
    public static void main(String[] args) {
        Observer ob1 = new Observer("one");
            for(Observer el : Observer.observers)
                System.out.println(el);

        System.out.println();
        Observer ob2 = new Observer("two");
            for(Observer el : Observer.observers)
                System.out.println(el);

        System.out.println();
        ob1.setState("new State");
            for(Observer el : Observer.observers)
                System.out.println(el);

        System.out.println();
        ob2.setState("hello");
            for(Observer el : Observer.observers)
                System.out.println(el);
    }
}
