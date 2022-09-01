package A_GROM_lesson.lesson6;

import java.util.Date;


public class User {
    String name;
    int age;
    String city;
    Date lastActiveDate;
    boolean isActive;

    public User() {
    }

    public User(String name, int age, String city, Date lastActiveDate, boolean isActive) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.lastActiveDate = lastActiveDate;
        this.isActive = isActive;
    }

    public User(String name) {
        this.name = name;
    }

    public void logIn() {
        this.lastActiveDate = new Date();
    }

    public void isActive(boolean status) {
        this.isActive = status;
    }

    public void increaseAge() {
        ++this.age;
    }
}
