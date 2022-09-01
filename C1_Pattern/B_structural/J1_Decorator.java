package C1_Pattern.B_structural;

interface Developerz{
    String makeJob();
}


class JavaDev implements Developerz{

    @Override
    public String makeJob() {
        return "Write Java code.  ";
    }
}

//----------------------------------------------------------------------------------------------------------------------
class DevelopDecorator implements Developerz{
    Developerz developerz;

    public DevelopDecorator(Developerz developerz) {
        this.developerz = developerz;
    }

    @Override
    public String makeJob() {
        return developerz.makeJob();
    }
}

//----------------------------------------------------------------------------------------------------------------------
class SeniorJavaDeveloper extends DevelopDecorator{

    public SeniorJavaDeveloper(Developerz developerz) {
        super(developerz);
    }

    public String makeCodeReview() {
        return "Make code review. ";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}


class JavaTeamLead extends DevelopDecorator{

    public JavaTeamLead(Developerz developerz) {
        super(developerz);
    }

    public String sendWeekReport() {
        return "Send week report to customer. ";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }
}


//----------------------------------------------------------------------------------------------------------------------
public class J1_Decorator {
    public static void main(String[] args) {
        Developerz dev = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDev()));
            System.out.println(dev.makeJob());
    }
}
