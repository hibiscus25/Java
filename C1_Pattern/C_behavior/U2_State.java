package C1_Pattern.C_behavior;


interface States{
   void doAction(Context context);
}

class LoverCaseState implements States{
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCaseState implements States{
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

//-------------------------------------------------------------
class Context{
    States states;
    String name;

    public Context(States states, String name) {
        this.states = states;
        this.name = name;
    }

    public void setState(States states) {
        this.states = states;
    }

    void doAction(){
        states.doAction(this);
    }
}

//-------------------------------------------------------------
public class U2_State {
    public static void main(String[] args) {
        Context context = new Context(new LoverCaseState(), "Maxvel");
            context.doAction();
        context.setState(new UpperCaseState());
            context.doAction();
    }
}
