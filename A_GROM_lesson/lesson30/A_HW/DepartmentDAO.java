package A_GROM_lesson.lesson30.A_HW;

import java.util.*;
import A_GROM_lesson.lesson30.A_HW.ENUM.DepartmentType;

public class DepartmentDAO {

    private static Set<Department> department() {
        Set<Department> departmets = new HashSet<>();
        departmets.add(new Department(DepartmentType.MANAGER, EmployeeDAO.getEmployeeManager()));
        departmets.add(new Department(DepartmentType.HR, EmployeeDAO.getEmployeeHr()));
        departmets.add(new Department(DepartmentType.FINANCE, EmployeeDAO.getEmployeeFinance()));
        departmets.add(new Department(DepartmentType.DEVELOPER, EmployeeDAO.getEmployeeDeveloper()));
        departmets.add(new Department(DepartmentType.DESIGNER, EmployeeDAO.getEmployeeDesigner()));
    return departmets;
    }

    public static Set<Department> getDepartmentSet () {
            return department();
    }
}