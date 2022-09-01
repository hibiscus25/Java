package A_GROM_lesson.lesson30.A_HW;

import java.util.*;

public class CustomerDAO {

    private static Set<Customer> customer() {
        Set<Customer> customers = new LinkedHashSet<>();
        customers.add(new Customer("OOO", "Громнафта", "Ukraine"));
        customers.add(new Customer("OOO", "Украерорух", "Ukraine"));
        customers.add(new Customer("LTN", "Google", "America"));
        customers.add(new Customer("LTN", "SAMSUNg", "KOREA"));
        customers.add(new Customer("LTN", "TOYOTA", "JAPAN"));
    return customers;
    }

    public static Set<Customer>  getCustomerSet() {
        return customer();
    }
}
