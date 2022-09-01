package C1_Pattern.C_behavior;

import java.util.Date;



class Project{
    private String version;
    private Date date;

    public void setVersionAndDate(String version){
        this.version = version;
        this.date  = new Date();
    }

    public Save save(){
        return new Save(version);
    }

    public void load(Save save){
        version = save.getVersion();
        date = save.getDate();
    }


    @Override
    public String toString() {
        return "Project{" +
                "version='" + version + '\'' +
                ", date=" + date +
                '}';
    }
}


//-----------------------------------------------------------------------
class Save{
    private final String version;
    private final Date date;

    public Save(String version) {
        this.version = version;
        this.date = new Date();
    }

    public String getVersion() {
        return version;
    }

    public Date getDate() {
        return date;
    }
}


//-----------------------------------------------------------------------
class GitHubRepo{
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}

//-----------------------------------------------------------------------
public class S1_Momento {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHubRepo gitHub = new GitHubRepo();

        System.out.println("Creating new project. Version 1.0");
            project.setVersionAndDate("Version 1.0");
        System.out.println(" - " + project);

        System.out.println();
        System.out.println("Saving current version to gitHub ...");
            gitHub.setSave(project.save());

        System.out.println();
        Thread.sleep(3000);
        System.out.println("Updating poor code ...");
            project.setVersionAndDate("Version 1.1");
        System.out.println(" - " + project);

        System.out.println();
        System.out.println("Something went wrong ...");

        System.out.println();
        System.out.println("Rolling back to Version 1.0 ...");
            project.load(gitHub.getSave());
        System.out.println(" - " + project);
    }
}
