package A_GROM_lesson.lesson13.A_HW.homework10;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if (logicCity(getShipFromCity())) {
            System.err.println("Заказы осуществлются, только из городов: Киев, Одесса, Днепр, Харьков  - " + getShipFromCity());
            return;
        }
        if (logicCity(getShipToCity())) {
            System.err.println("Доставка осуществляется, только в город: Киев, Одесса, Днепр, Харьков  - " + getShipFromCity());
            return;
        }
    }

    @Override
    public void calculatePrice() {
        price=getBasePrice();

        if (price < 0 || price < 100) {
            System.err.println("Минимальная цена заказа - 100 грн");
        return;
        }

        if (!getCustomerOwned().getGender().equalsIgnoreCase("Женский")){
            System.err.println("Пол может быть только Женский");
        return;
        }

        if(getBasePrice()>1000 && getCustomerOwned().isComision())
                price*=0.95;

        if(getShipToCity().equalsIgnoreCase("Киев") || getShipToCity().equalsIgnoreCase("Одесса"))
                totalPrice=price+getBasePrice() * 0.15;
        else
                totalPrice=price+getBasePrice() * 0.1;
}

    private boolean logicCity(String str) {
        if (str == null || (!str.equalsIgnoreCase("Киев") && !str.equalsIgnoreCase("Одесса")
                && !str.equalsIgnoreCase("Днепр") && !str.equalsIgnoreCase("Харьков")))
            return true;
        return false;
    }
}
