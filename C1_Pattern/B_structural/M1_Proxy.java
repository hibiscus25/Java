package C1_Pattern.B_structural;

interface Project{
    void run();
}

class RealProject implements Project{
    private String url;

    public RealProject(String url) {
        this.url = url;
        load();
    }

    public void load(){
        System.out.println("Loading project from  " + url + " .... ");
    }

    @Override
    public void run() {
        System.out.println("Running project " + url + " .... ");
    }
}

//---------------------------------------------------------------------------------
class ProxyProject implements Project{
    private String url;
    private RealProject realProject;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if(realProject == null)
            realProject = new RealProject(url);
        realProject.run();
    }
}

//---------------------------------------------------------------------------------
public class M1_Proxy {
    public static void main(String[] args) {
        Project project = new RealProject("https://www.github.com/proselyter");
            project.run();

        System.out.println();
        Project project1 = new ProxyProject("https://www.github.com/proselyter");
            project1.run();

    }
}
