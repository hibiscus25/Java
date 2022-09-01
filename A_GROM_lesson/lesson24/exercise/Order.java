package A_GROM_lesson.lesson24.exercise;

public class Order {
    private String name;
    private String description;

    public Order(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
