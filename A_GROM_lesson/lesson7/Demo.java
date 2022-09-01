package A_GROM_lesson.lesson7;

import A_GROM_lesson.lesson6.Car;
import A_GROM_lesson.lesson6.DbConnector;
import A_GROM_lesson.lesson6.User;

public class Demo {
    public Demo() {
    }

    public static void main(String[] args) {
        new User();
        new User("Jack");
        new Car(10000, 2015, "Anton");
        new DbConnector();
    }
}
