package C1_Pattern.C_behavior;

interface Activity{
    void justDoIt();
}

class Coding implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Writing code ...");
    }
}

class Reading implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Reading book ...");
    }
}

class Sleeping implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Sleeping ...");
    }
}

class Training implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Training ...");
    }
}

//-----------------------------------------------------------------
class Develop{
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void changeActivity(){
        if (activity instanceof  Sleeping) {
            setActivity(new Training());
        }else if (activity instanceof  Training) {
            setActivity(new Coding());
        }else if (activity instanceof  Coding) {
            setActivity(new Reading());
        }else if (activity instanceof  Reading) {
            setActivity(new Sleeping());
        }
    }

    public void justDoIt(){
        activity.justDoIt();
    }
}

//-----------------------------------------------------------------
public class U1_State {
    public static void main(String[] args) {
        Develop develop = new Develop();
            develop.setActivity(new Sleeping());

        for(int i = 0; i < 6; i ++){
            develop.justDoIt();
            develop.changeActivity();
        }
    }
}
