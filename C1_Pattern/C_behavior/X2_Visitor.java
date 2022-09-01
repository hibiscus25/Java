package C1_Pattern.C_behavior;

interface  Animals{
    void doJob(Vizitors vizitors);
}

class Dogs implements Animals{
    @Override
    public void doJob(Vizitors vizitors) {
        vizitors.doDog();
    }
}

class Cats implements Animals{
    @Override
    public void doJob(Vizitors vizitors) {
        vizitors.doCat();
    }
}

//-----------------------------------------------------
interface Vizitors {
    void doDog();
    void doCat();
}

class ConcreteVisitor implements Vizitors{
    @Override
    public void doDog() {
        System.out.println("haw");
    }

    @Override
    public void doCat() {
        System.out.println("may");
    }
}

//-----------------------------------------------------
public class X2_Visitor {
    public static void main(String[] args) {
        Animals animals = new Dogs();
            animals.doJob(new ConcreteVisitor());
        Animals animals2 = new Cats();
            animals2.doJob(new ConcreteVisitor());

    }
}
