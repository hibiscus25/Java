package A_GROM_lesson.lesson13.A_HW.homework10;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if (getShipFromCity() == null || (!getShipFromCity().equalsIgnoreCase("Киев")
                && !getShipFromCity().equalsIgnoreCase("Львов"))) {
            System.err.println("Из города " + getShipFromCity() + " не осуществляются заказы.\nВыберите из городов: Киев, Львов");
            return;
        }
    }

    @Override
    public void calculatePrice() {
        price=getBasePrice();

        if (price < 500) {
            System.err.println("Минимальная цена заказа - 500 грн");
            return;
        }

        if (getCustomerOwned().getName().equalsIgnoreCase("Тест")){
            System.err.println("Имя не может быть \"Тест\"");
            return;
        }

        if(getBasePrice()<5000)
            totalPrice=getBasePrice()+getBasePrice() * 0.05;
        else
            totalPrice=getBasePrice()+getBasePrice() * 0.02;
    }
}