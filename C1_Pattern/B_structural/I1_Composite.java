package C1_Pattern.B_structural;


import java.util.ArrayList;
import java.util.List;

interface Develop{
    void writeCode();
}

class JavaDevelop implements Develop{

    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code ...");
    }
}

class CppDevelop implements Develop{

    @Override
    public void writeCode() {
        System.out.println("Cpp developer writes Cpp code ...");
    }
}

//-------------------------------------------------------------------------------------
class Team{
    private List<Develop> developers = new ArrayList<>();

    public void addDeveloper(Develop develop){
        developers.add(develop);
    }

    public void removeDeveloper(Develop develop){
        developers.remove(develop);
    }

    public void createProject(){
        System.out.println("Team creates project ...");
        for (Develop el : developers)
            el.writeCode();
    }
}




//-------------------------------------------------------------------------------------
public class I1_Composite {
    public static void main(String[] args) {
        Team team = new Team();

        Develop firstJavaDeveloper = new JavaDevelop();
        Develop secondJavaDeveloper = new JavaDevelop();
        Develop cppDeveloper = new CppDevelop();

        team.addDeveloper(firstJavaDeveloper);
        team.addDeveloper(secondJavaDeveloper);
        team.addDeveloper(cppDeveloper);

        team.createProject();

    }
}
