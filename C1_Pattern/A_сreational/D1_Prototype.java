package C1_Pattern.A_сreational;



class Project implements Cloneable{
    private int id;
    private String projectName;

    public Project(int id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    @Override
    protected Project clone() throws CloneNotSupportedException {
        return (Project) super.clone();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}

//----------------------------------------------------------------------------------------------------------------------
class ProjectFactory{
    Project project;

    public ProjectFactory(Project project){
        this.project = project;
    }

    Project cloneProject() throws CloneNotSupportedException {
        return project.clone();
    }
}

//----------------------------------------------------------------------------------------------------------------------
public class D1_Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Project master = new Project(1, "SuperProject");
            System.out.println(master);

        ProjectFactory factory = new ProjectFactory(master);
        Project masterClone = factory.cloneProject();
            System.out.println(masterClone);

        System.out.println(master == masterClone);
    }
}
