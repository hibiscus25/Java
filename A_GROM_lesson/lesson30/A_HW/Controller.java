package A_GROM_lesson.lesson30.A_HW;

import java.util.*;

import A_GROM_lesson.lesson30.A_HW.ENUM.DepartmentType;
import A_GROM_lesson.lesson30.A_HW.ENUM.Position;

public class Controller {
    private static Firm firm;
    private static Set<Employee> employeeAll;

    public Controller(Firm firm) {
        this.firm = firm;
        employeeAll=employeeAll();
    }

//a. список сотрудников, не участвующих ни в одном проекте
    public Set<Employee> employeesWithoutProject() {
        return resultSet(employeeAll());
    }

//a1.cписок сотрудников из заданного отдела, не участвующих ни в одном проекте
    public static Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        Department department = null;
        Set<Department> set = (Set<Department>) firm.getDepartaments();
        for (Department el : set) {
            if (el.getType().equals(departmentType)) {
                department = el;
            }
        }
        return resultSet((Set<Employee>) department.getEmployees());
    }

//c.список проектов, выполняемых для заданного заказчика
    public static Set<Project> projectsByCustomer(Customer customer) {
        Set<Project> projectAll = ProjectDAO.getProjectSet();

        Set<Project> result = new HashSet<>();
        for (Project el : projectAll) {
            if (el.getCustomer().equals(customer)) {
                result.add(el);
            }
        }
        return result;
    }

//d. список проектов, в которых участвует заданный сотрудник
    public static Set<Project> projectsByEmployee(Employee employee) {
        Set<Project> project = new HashSet<>();
        for (Employee el : employeeAll) {
            if (el.equals(employee)) {
                project = (Set<Project>) el.getProjects();
            }
        }
        return project;
    }

//d1. список подчиненных для заданного руководителя(по всем проектам, которыми он руководит)
    public static Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Project> projectAll = projectsByEmployee(lead);

        Set<Employee> result = new HashSet<>();
        for (Employee el : employeeAll) {
            if (el.getProjects() != null) {
                if (!el.equals(lead)) {
                    if (projectBoolean(el, projectAll)) {
                        result.add(el);
                        System.out.println(el);
                    }
                }
            }
        }
        return result;
    }

//d2. список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
         return employeesByTeamLead(employee);
    }

//e. список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Project> projectAll = projectsByEmployee(employee);

        Set<Employee> teamLead = new HashSet<>();                         //нашли теам леад
        for (Employee el : employeeAll) {
            if (el.getProjects() != null) {
                if (el.getPosition().equals(Position.TEAM_LEAD)) {
                    teamLead.add(el);
                }
            }
        }
        Set<Employee> result = new HashSet<>();
        for (Employee el : teamLead) {
            if (projectBoolean(el, projectAll)) {
                result.add(el);
            }
        }
        return result;
    }

//f. список сотрудников, участвующих в проектах,выполняемых для заданного заказчика
    public Set<Employee> employeesByCustomerProjects(Customer customer) {
        Set<Project> projectAll = projectsByCustomer(customer);

        Set<Employee> result = new HashSet<>();
        for (Employee el : employeeAll) {
            if (el.getProjects() != null) {
                if (projectBoolean(el, projectAll)) {
                    result.add(el);
                }
            }
        }
        return result;
    }

//other method
    private static Set<Employee> employeeAll() {                                            //формирование общей коллекции всех людей
        Set<Department> set = (Set<Department>) firm.getDepartaments();
        Set<Employee> employeeAll = new HashSet<>();
        Department department = null;
        for (Department el : set) {
            department = el;
            Set<Employee> employ = (Set<Employee>) department.getEmployees();
            employeeAll.addAll(employ);
        }
        return employeeAll;
    }

    private static boolean projectBoolean(Employee employees, Set<Project> projectAll) {      //проверка на совпадение проектов
        Set<Project> projectsEmployee = (Set<Project>) employees.getProjects();
        for (Project el : projectsEmployee) {
            for (Project els : projectAll) {
                if (el.equals(els)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Set<Employee> resultSet(Set<Employee> setEmployees) {          //добавление людей, если проекты null
        Set<Employee> result = new HashSet<>();
        for (Employee el : setEmployees) {
            if (el.getProjects() == null) {
                result.add(el);
            }
        }
        return result;
    }
}
