package C2_SOLID;

// не должны зависеть от интерфейсов, которые не используем

interface Worker{
    void work();
}

interface Eater{
    void eat();
}

interface IWorker extends Worker, Eater{}

//------------------------------------------------------------------
class Cooks implements IWorker{

    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}

class Waiter implements Worker{

    @Override
    public void work() {
        System.out.println("work");
    }
}


//------------------------------------------------------------------
public class D_InterfaceSugregation {
    public static void main(String[] args) {
        IWorker iWorker = new Cooks();
            iWorker.work();
            iWorker.eat();
            iWorker.work();
    }
}
