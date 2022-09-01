package A_GROM_lesson.lesson13.A_HW.homework10;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customerOwned=new Customer("Николай","Москва","Мужской",true);
        Customer customerOwned2=new Customer("Федор","Киев","Женский",true);

        ElectronicsOrder electronicsOrder=new ElectronicsOrder("Заказчик", new Date(), "Одесса", "Киев",700, customerOwned, 12);
        ElectronicsOrder electronicsOrder2=new ElectronicsOrder("Заказчик", new Date(), "Москва", "Калининград", 500, customerOwned2, 12);

        FurnitureOrder furniture=new FurnitureOrder("Заказчик", new Date(), "Киев", "Днепр", 500, customerOwned, "124578") ;
        FurnitureOrder furniture2=new FurnitureOrder("Заказчик", new Date(), "Одесса", "Харьков", 300, customerOwned2, "124578");

        electronicsOrder.validateOrder();
        electronicsOrder.calculatePrice();

        electronicsOrder2.validateOrder();
        electronicsOrder2.calculatePrice();

        furniture.validateOrder();
        furniture.calculatePrice();
    }
}
