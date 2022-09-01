package A_GROM_lesson.lesson10.A_HW;

import java.util.Date;

public abstract class Order {
    private String itemName;            //имя элемента
    private Date dateCreated;           //дата создания
    public Date dateConfirmed;          //дата подтверждения - не создаем
    public Date dateShipped;            //дата отправки - не создаем
    private String shipFromCity;        //корабль из города
    private String shipToCity;          //корабль в город
    int basePrice;                      //базовая цена
    public double totalPrice;           //итоговая цена     - не создаем
    private Customer customerOwned;
    public double price;                //промежуточное значение - сам создал

    public Order(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    abstract void validateOrder();

    abstract void calculatePrice();

    public void confirmShipping(){
        if(dateShipped == null)
            dateShipped = new Date();
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    public int getBasePrice() {
        return basePrice;
    }
}
