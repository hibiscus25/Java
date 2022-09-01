package C1_Pattern.C_behavior;


interface Activ{
    void justDoIt();
}


class Codings implements Activ {
    @Override
    public void justDoIt() {
        System.out.println("Coding ...");
    }
}

class Readings implements Activ{
    @Override
    public void justDoIt() {
        System.out.println("Reading ...");
    }
}

class Sleepings implements Activ{
    @Override
    public void justDoIt() {
        System.out.println("Sleeping ...");
    }
}

class Trainings implements Activ{
    @Override
    public void justDoIt() {
        System.out.println("Training ...");
    }
}

//------------------------------------------------------------
class Developerz{
    Activ activ;

    public void setActiv(Activ activ) {
        this.activ = activ;
    }

    public  void executeActivity(){
        activ.justDoIt();
    }
}


//------------------------------------------------------------
public class V1_Strategy {
    public static void main(String[] args) {
        Developerz dev = new Developerz();
            dev.setActiv(new Sleepings());
            dev.executeActivity();

            dev.setActiv(new Trainings());
            dev.executeActivity();

            dev.setActiv(new Codings());
            dev.executeActivity();

            dev.setActiv(new Readings());
            dev.executeActivity();

            dev.setActiv(new Sleepings());
            dev.executeActivity();
    }
}
