package A_GROM_lesson.lesson27.A_HW.lesson27A;

public class Order {
    private long id;
    private int price;
    private String currency;
    private String itemName;
    private String shopIdentificator;

    public Order(long id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
