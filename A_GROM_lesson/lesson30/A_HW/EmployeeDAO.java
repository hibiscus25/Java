package A_GROM_lesson.lesson30.A_HW;

import A_GROM_lesson.lesson30.A_HW.ENUM.Position;
import java.util.*;

public class EmployeeDAO {

    private static Set<Employee> employManager() {
        Set<Employee> employManager = new HashSet<>();
        employManager.add(new Employee("Andrey", "Nikiforov", Position.MANAGER,ProjectDAO.getProjectSet()));
    return employManager;
    }

    private static Set<Employee> employHr() {
        Set<Employee> employHr = new HashSet<>();
        employHr.add(new Employee("Inna", "Frolova", Position.HR,ProjectDAO.getProjectSet()));
    return employHr;
    }

    private static Set<Employee> employFinance() {
        Set<Employee> employFinance = new HashSet<>();
        employFinance.add(new Employee("Katya", "Globa", Position.FINANCE,ProjectDAO.getProjectSet()));
    return employFinance;
    }

    private static Set<Employee> employDeveloper() {
        Set<Employee> employDeveloper = new HashSet<>();
        employDeveloper.add(new Employee("Ivan", "Dorn", Position.TEAM_LEAD,ProjectDAO.getProject2Set()));
        employDeveloper.add(new Employee("Gled", "Sofa", Position.TEAM_LEAD,ProjectDAO.getProject3Set()));
        employDeveloper.add(new Employee("Nikolya", "Lorn", Position.ANALYST,ProjectDAO.getProject2Set()));
        employDeveloper.add(new Employee("Kolya", "Gordon", Position.ANALYST,null));
        employDeveloper.add(new Employee("Gled", "Sirov", Position.DEVELOPER,ProjectDAO.getProject3Set()));
        employDeveloper.add(new Employee("Fedor", "Samsonov", Position.DEVELOPER,null));
        employDeveloper.add(new Employee("Fedor", "Laks", Position.DEVELOPER,ProjectDAO.getProject4Set()));
        employDeveloper.add(new Employee("Kolya", "Rudenkoa", Position.DEVELOPER,null));
        employDeveloper.add(new Employee("Oleg", "Pak", Position.DEVELOPER,ProjectDAO.getProject3Set()));
        employDeveloper.add(new Employee("Foma", "Kim", Position.DEVELOPER,null));
        employDeveloper.add(new Employee("Sergey", "Koxan", Position.DEVELOPER,ProjectDAO.getProject3Set()));
    return employDeveloper;
    }

    private static Set<Employee> employDesigner() {
        Set<Employee> employDesigner = new HashSet<>();
        employDesigner.add(new Employee("Ivan", "lord", Position.LEAD_DESIGNER,ProjectDAO.getProject4Set()));
        employDesigner.add(new Employee("Klaus", "Sofa", Position.LEAD_DESIGNER,ProjectDAO.getProject3Set()));
        employDesigner.add(new Employee("Minsu", "Sofa", Position.DESIGNER,ProjectDAO.getProject3Set()));
        employDesigner.add(new Employee("Ense", "Mazur", Position.DESIGNER,null));
        employDesigner.add(new Employee("An", "Kraizer", Position.DESIGNER,ProjectDAO.getProject2Set()));
    return employDesigner;
    }


    public static Set<Employee> getEmployeeManager() {
       return employManager();
    }

    public static Set<Employee> getEmployeeHr() {
        return employHr();
    }

    public static Set<Employee> getEmployeeFinance() {
        return employFinance();
    }

    public static Set<Employee> getEmployeeDeveloper() {
        return employDeveloper();
    }

    public static Set<Employee> getEmployeeDesigner() {
        return employDesigner();
    }
}