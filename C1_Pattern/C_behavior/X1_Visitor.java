package C1_Pattern.C_behavior;



interface ProjectElement{
    void beWritten(Devels developer);
}

class ProjectClass implements ProjectElement{
    @Override
    public void beWritten(Devels developer) {
        developer.create(this);
    }
}

class DataBaseClass implements ProjectElement{
    @Override
    public void beWritten(Devels developer) {
        developer.create(this);
    }
}

class TestClass implements ProjectElement{
    @Override
    public void beWritten(Devels developer) {
        developer.create(this);
    }
}

class Projects implements ProjectElement{
    ProjectElement[] projectElements;

    public Projects(){
        this.projectElements = new ProjectElement[]{
                new ProjectClass(),
                new DataBaseClass(),
                new TestClass()
        };
    }

    @Override
    public void beWritten(Devels developer) {
        for(ProjectElement el : projectElements)
            el.beWritten(developer);
    }
}


//-------------------------------------------------------------------
interface Devels{
    void create(ProjectClass projectClass);
    void create(DataBaseClass dataBaseClass);
    void create(TestClass testClass);
}


class JunDevelop implements Devels{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Writing poor class ....");
    }

    @Override
    public void create(DataBaseClass dataBaseClass) {
        System.out.println("Drop database ....");
    }

    @Override
    public void create(TestClass testClass) {
        System.out.println("Creating  not reliable test ....");
    }
}


class SenDevelop implements Devels{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewriting class after junior ....");
    }

    @Override
    public void create(DataBaseClass dataBaseClass) {
        System.out.println("Fixing database ....");
    }

    @Override
    public void create(TestClass testClass) {
        System.out.println("Creating  reliable test ....");
    }
}


//-------------------------------------------------------------------
public class X1_Visitor {
    public static void main(String[] args) {
        Projects project = new Projects();

        Devels jun = new JunDevelop();
        Devels sen = new SenDevelop();

        System.out.println("Junior connection");
            project.beWritten(jun);
        System.out.print("\n==========================================\n");
        System.out.println("Senior connection");
            project.beWritten(sen);
    }
}
