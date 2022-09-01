package A_GROM_lesson.lesson13.A_HW;

import A_GROM_lesson.lesson13.A_HW.homework10.Customer;
import A_GROM_lesson.lesson13.A_HW.homework10.ElectronicsOrder;
import A_GROM_lesson.lesson13.A_HW.homework10.FurnitureOrder;
import A_GROM_lesson.lesson13.A_HW.homework9.*;
import A_GROM_lesson.lesson13.A_HW.homework11.*;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
//test homework9
        UserRepository userRepository = new UserRepository();
    //test 0
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

    //test save
        //cохранение юзера+
        User user = new User(1001, "Ann", "1wewew");
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //сохранение того же юзера+
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда нет места в массиве+
        int n = 15;
        while (n > 0) {
            User user1 = new User(n, "Ann", "123kjsljd");
            System.out.println(userRepository.save(user1));
            n--;
        }
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда сохраняем null+
        userRepository.save(null);

    //test update
        //обновление юзера
        user = new User(1001, "Anna", "eredfdfdfd");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда нет юзера на обновление
        user = new User(999, "Anna", "eredfdfdfd");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда обновляем null
        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

//test homework10
    // Сustomer.proverka
        Customer customer=new Customer("Николай","Москва","Мужской",true);
        Customer customer2=new Customer("Николай","Москва","Женский",true);
        Customer customer3=new Customer("Николай","Москва","Разное",true);
        Customer customer4=new Customer("Николай","Москва",null,false);
        System.out.println(customer.proverka(customer.getName()));
        System.out.println(customer.proverka(customer2.getName()));
        System.out.println(customer.proverka(customer3.getName()));
        System.out.println(customer.proverka(customer4.getName()));

    //ElectronicsOrder.validateOrder()
        ElectronicsOrder electronics=new ElectronicsOrder("Заказчик", new Date(), "Киев", "Киев",700, customer, 12);
        ElectronicsOrder electronics2=new ElectronicsOrder("Заказчик", new Date(), "Одесса", "Киев",700, customer, 12);
        ElectronicsOrder electronics3=new ElectronicsOrder("Заказчик", new Date(), "Днепр", "Киев",700, customer, 12);
        ElectronicsOrder electronics4=new ElectronicsOrder("Заказчик", new Date(), "Ласвегас", "Киев",700, customer, 12);
        ElectronicsOrder electronics5=new ElectronicsOrder("Заказчик", new Date(), "Другой город", "Киев",700, customer, 12);
        ElectronicsOrder electronics6=new ElectronicsOrder("Заказчик", new Date(), null, "Киев",700, customer, 12);

        electronics4.validateOrder();
        electronics5.validateOrder();
        electronics6.validateOrder();

    //FurnitureOrder.validateOrder()
        FurnitureOrder furniture=new FurnitureOrder("Заказчик", new Date(), "Киев", "Днепр", 500, customer, "124578") ;
        FurnitureOrder furniture2=new FurnitureOrder("Заказчик", new Date(), "Львов", "Харьков", 300, customer, "124578");
        FurnitureOrder furniture3=new FurnitureOrder("Заказчик", new Date(), "Другой город", "Харьков", 300, customer, "124578");
        FurnitureOrder furniture4=new FurnitureOrder("Заказчик", new Date(), null, "Харьков", 300, customer, "124578");

        furniture.validateOrder();
        furniture2.validateOrder();
        furniture3.validateOrder();
        furniture4.validateOrder();

    // ElectronicsOrder.calculatePrice()
        ElectronicsOrder electronics7=new ElectronicsOrder("Заказчик", new Date(), "Киев", "Киев",50, customer, 12);
        electronics7.calculatePrice();
        ElectronicsOrder electronics8=new ElectronicsOrder("Заказчик", new Date(), "Киев", "Киев",150, customer, 12);
        electronics8.calculatePrice();
        ElectronicsOrder electronics9=new ElectronicsOrder("Заказчик", new Date(), "Харьков", "Харьков",10000, customer2, 12);
        electronics9.calculatePrice();
        System.out.println(electronics9.getTotalPrice());
    // FurnitureOrder.calculatePrice()
        FurnitureOrder furniture5=new FurnitureOrder("Заказчик", new Date(), "Киев", "Днепр", 10000, customer, "124578") ;
        furniture5.calculatePrice();
        System.out.println(furniture5.getTotalPrice());


//test homework11
        Demo2 demo =new Demo2();
        Room[] room= demo.getRequestRooms();
    //BookingComAPI.findRooms
        BookingComAPI bookingComAPI=new BookingComAPI(room);
        System.out.println(Arrays.toString(bookingComAPI.findRooms(50, 3, "Kiev", "Tanus")));
        System.out.println(bookingComAPI.findRooms(0, 0, "Kiev", "Tanus"));
    //TripAdvisorAPI.findRooms
        TripAdvisorAPI tripAdvisorAPI=new TripAdvisorAPI(room);
        System.out.println(Arrays.toString(tripAdvisorAPI.findRooms(50, 3, "Kiev", "Tanus")));
        System.out.println(tripAdvisorAPI.findRooms(0, 0, "Kiev", "Tanus"));
    //GoogleAPI.findRooms
        GoogleAPI googleAPI=new GoogleAPI(room);
        System.out.println(Arrays.toString(googleAPI.findRooms(190,3, "Kiev","Tranus")));
        System.out.println(Arrays.toString(googleAPI.findRooms(700,1, "Dnepr","Franus")));
        System.out.println(Arrays.toString(googleAPI.findRooms(100000,50, "Lyvov","TFnus")));
        System.out.println(googleAPI.findRooms(0, 0, "Kiev", "Tanus"));
    //GoogleAPI.getAll
        System.out.println(Arrays.toString(googleAPI.getAll()));
    //Controller.requestRooms
        Controller controller=new Controller(demo.getApi());

    //Controller.requestRooms - по трем  null
        Room[] root=controller.requestRooms(0,0, "Lyvov","TFnus");
        if (root==null)
            System.err.println("на выходе null");
            System.exit(0);

    //Controller.requestRooms - по трем  АПИ один массив
        Room[] root1=controller.requestRooms(100000,50, "Lyvov","TFnus");
        for(int i=0;i<root1.length;i++){
            System.out.println(root1[i]);
        }

    //Controller.requestRooms - выводит несколько массивов
        Room[] root2=controller.requestRooms(100,2, "Moscow","Gannus");
        for(int i=0;i<root2.length;i++){
            System.out.println(root2[i]);
        }

    //Controller.check - проверка на null
        API api1 = new BookingComAPI(room);
        API api2 = new TripAdvisorAPI(demo.getRequestRooms2());
        Room[] root3=controller.check(api1,api2);
        if (root3==null)
            System.err.println("на выходе null");
            System.exit(0);
        for(int i=0;i<root3.length;i++){
            System.out.println(root3[i]);
        }
    }
}
