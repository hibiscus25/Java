package A_GROM_lesson.lesson30.A_HW;

import A_GROM_lesson.lesson30.A_HW.ENUM.Position;
import java.util.*;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private Collection<Project> projects;

    public Employee(String firstName, String lastName, Position position, Collection<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.projects = projects;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && position == employee.position && projects.equals(employee.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, position, projects);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", projects=" + projects +
                '}';
    }
}
