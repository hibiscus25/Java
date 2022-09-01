package A_GROM_lesson.lesson30.A_HW;

import java.util.*;

public class ProjectDAO {
    private static ArrayList<Customer> list = new ArrayList<>(CustomerDAO.getCustomerSet());

    private static Set<Project> projectAll() {
        Set<Project> projectAll = new HashSet<>();
        projectAll.add(new Project("Project11", list.get(0)));
        projectAll.add(new Project("Project12", list.get(0)));
        projectAll.add(new Project("Project21", list.get(1)));
        projectAll.add(new Project("Project31", list.get(2)));
        projectAll.add(new Project("Project32", list.get(2)));
        projectAll.add(new Project("Project41", list.get(3)));
        projectAll.add(new Project("Project42", list.get(3)));
        projectAll.add(new Project("Project51", list.get(4)));
    return projectAll;
    }

    private static Set<Project> project2() {
        Set<Project> project2 = new HashSet<>();
        project2.add(new Project("Project11", list.get(0)));
        project2.add(new Project("Project21", list.get(1)));
        project2.add(new Project("Project31", list.get(2)));
        project2.add(new Project("Project41", list.get(3)));
        project2.add(new Project("Project51", list.get(4)));
    return project2;
    }

    private static Set<Project> project3() {
        Set<Project> project3 = new HashSet<>();
        project3.add(new Project("Project12", list.get(0)));
        project3.add(new Project("Project32", list.get(2)));
        project3.add(new Project("Project42", list.get(3)));
        return project3;
    }

    private static Set<Project> project4() {
        Set<Project> project4 = new HashSet<>();
        project4.add(new Project("Project12", list.get(0)));
        project4.add(new Project("Project21", list.get(1)));
        project4.add(new Project("Project31", list.get(2)));
        project4.add(new Project("Project32", list.get(2)));
        project4.add(new Project("Project41", list.get(3)));
        project4.add(new Project("Project42", list.get(3)));
        return project4;
    }

    public static Set<Project> getProjectSet() {
        return projectAll();
    }

    public static Set<Project> getProject2Set() {
        return project2();
    }

    public static Set<Project> getProject3Set() {
        return project3();
    }

    public static Set<Project> getProject4Set() {
        return project4();
    }
}
