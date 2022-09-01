package C1_Pattern.A_сreational;


interface  Developer{
    void writeCode();
}

interface  Tester{
    void testCode();
}

interface  ProjectManager{
    void manageProject();
}

interface  ProjectTeamFactory{
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}

//----------------------------------------------------------------------------------------------------------------------
class JavaDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println(" - Java developer writes Java code ...");
    }
}

class QATester implements Tester{
    @Override
    public void testCode() {
        System.out.println(" - QA tester tests banking code ...");
    }
}

class BankingPM implements ProjectManager{
    @Override
    public void manageProject(){
        System.out.println(" - Banking PM manages banking projects ...");
    }
}


class BankingTeamFactory implements ProjectTeamFactory{

    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}

//----------------------------------------------------------------------------------------------------------------------
class PhpDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println(" - Php developer writes php code ...");
    }
}

class ManualTester implements Tester{
    @Override
    public void testCode() {
        System.out.println(" - Manual tester tests website ...");
    }
}

class WebSitePM implements ProjectManager{
    @Override
    public void manageProject() {
        System.out.println(" - Website PM manages Website project ...");
    }
}


class WebsiteTeamFactory implements ProjectTeamFactory{

    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebSitePM();
    }
}

//----------------------------------------------------------------------------------------------------------------------
public class A21_AbstractFactory {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
            Developer developer = projectTeamFactory.getDeveloper();
            Tester tester = projectTeamFactory.getTester();
            ProjectManager projectManager = projectTeamFactory.getProjectManager();

            System.out.println("Creating bank system.....");
                developer.writeCode();
                tester.testCode();
                projectManager.manageProject();


        projectTeamFactory = new WebsiteTeamFactory();
            developer = projectTeamFactory.getDeveloper();
            tester = projectTeamFactory.getTester();
            projectManager = projectTeamFactory.getProjectManager();

            System.out.println();
            System.out.println("Creating auction website .....");
                developer.writeCode();
                tester.testCode();
                projectManager.manageProject();
    }
}









