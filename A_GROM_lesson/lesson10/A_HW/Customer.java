package A_GROM_lesson.lesson10.A_HW;

public class Customer {
    private String name;
    private String city;
    private String gender;
    private boolean comision;

    public Customer proverka(String gender) {
        if (gender==null || (!gender.equalsIgnoreCase("Мужской") && !gender.equalsIgnoreCase("Женский"))) {
            System.err.println("Поле может принимать только значение - \"Мужской\" или \"Женский\"  - " + gender);
            System.exit(0);
        }
        this.gender = gender;
        return this;
    }

    public Customer(String name, String city, String gender, boolean comision) {
        this.name = name;
        this.city = city;
        proverka(gender);
        this.comision = comision;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public boolean isComision() {
        return comision;
    }
}
