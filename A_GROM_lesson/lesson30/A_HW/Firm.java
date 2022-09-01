package A_GROM_lesson.lesson30.A_HW;

import java.util.*;

public class Firm {
    private Date dateFounded;
    private Collection<Department> departaments;
    private Collection<Customer> customers;

    public Firm(Collection<Department> departaments, Collection<Customer> customers) {
        this.departaments = departaments;
        this.customers = customers;
    }

    public Collection<Department> getDepartaments() {
        return departaments;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "Firm{" +
                ", departaments=" + departaments +
                ", customers=" + customers +
                '}';
    }
}
