package C1_Pattern.C_behavior;

import java.util.ArrayList;
import java.util.List;


interface Observer2{
    void handleEvent(List<String> vacancies);
}


class Subscriber implements Observer2{
    String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " + name + "\nWe have some changes in vacancies:\n" + vacancies +
                "\n=============================================================\n");
    }
}

//------------------------------------------------------------------------------------------------------
interface Observed{
    void addObserver(Observer2 observer);
    void removeObserver(Observer2 observer);
    void notifyObserver();
}


class JavaDeveloperWebSite implements Observed{
    List<String> vacancies = new ArrayList<>();
    List<Observer2> subcribers = new ArrayList<>();

    public void addVacancy(String vacancy){
        this.vacancies.add(vacancy);
        notifyObserver();
    }

    public void removeVacancy(String vacancy){
        this.vacancies.remove(vacancy);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer2 observer) {
        this.subcribers.add(observer);
    }

    @Override
    public void removeObserver(Observer2 observer) {
        this.subcribers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer2 el : subcribers)
            el.handleEvent(this.vacancies);
    }
}


//------------------------------------------------------------------------------------------------------
public class T1_Observable {
    public static void main(String[] args) {
        JavaDeveloperWebSite jobSite = new JavaDeveloperWebSite();
            jobSite.addVacancy("First java Position");
            jobSite.addVacancy("Second java Position");

        Observer2 firstSubscriber = new Subscriber("Ivan");
        Observer2 secondSubscriber = new Subscriber("Dolgorukov");
        Observer2 thirdSubscriber = new Subscriber("Mukola");

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);
        jobSite.addObserver(thirdSubscriber);

        jobSite.addVacancy("Third Java Position");

        System.out.println();
        jobSite.removeVacancy("First java Position");
    }
}
