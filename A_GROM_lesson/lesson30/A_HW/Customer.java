package A_GROM_lesson.lesson30.A_HW;

import java.util.Objects;

public class Customer {
    private String firstname;
    private String lastName;
    private String country;
    private int monthlyPay;

    public Customer(String firstname, String lastName, String country) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstname.equals(customer.firstname) && lastName.equals(customer.lastName) && country.equals(customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName, country);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}




