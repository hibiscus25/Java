package A_GROM_lesson.lesson30.A_HW;

import A_GROM_lesson.lesson30.A_HW.ENUM.DepartmentType;
import A_GROM_lesson.lesson30.A_HW.ENUM.Position;

public class Demo {
    public static void main(String[] args) {
        Firm firm=new Firm(DepartmentDAO.getDepartmentSet(),CustomerDAO.getCustomerSet());
        Controller controller=new Controller(firm);

        System.out.println(controller.employeesWithoutProject());
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DEVELOPER));
        System.out.println(controller.projectsByCustomer(new Customer("OOO", "Громнафта", "Ukraine")));
        System.out.println(controller.projectsByEmployee(new Employee("Klaus", "Sofa", Position.LEAD_DESIGNER,ProjectDAO.getProject3Set())));
        System.out.println(controller.employeesByTeamLead(new Employee("Gled", "Sofa", Position.TEAM_LEAD,ProjectDAO.getProject3Set())));
        System.out.println(controller.teamLeadsByEmployee(new Employee("Fedor", "Laks", Position.DEVELOPER,ProjectDAO.getProject4Set())));
        System.out.println(controller.employeesByCustomerProjects(new Customer("LTN", "TOYOTA", "JAPAN")));
        System.out.println(controller.employeesByProjectEmployee(new Employee("Nikolya", "Lorn", Position.ANALYST,ProjectDAO.getProject2Set())));
    }
}
