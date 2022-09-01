package A_GROM_lesson.lesson13.A_HW.homework11;

import java.util.Arrays;
import java.util.Date;

public class Demo2 {
//массив комнат - 1
    Room room1 = new Room(1l, 40, 3, new Date(1650000000000l), "Tanus", "Kiev");
    Room room2 = new Room(2l, 00, 1, new Date(1650000000000l), "Franus", "Dnepr");
    Room room3 = new Room(3l, 100000, 50, new Date(1650000000000l), "TFnus", "Lyvov");
    Room room4 = new Room(4l, 80, 2, new Date(1650000000000l), "Tanus", "Lyvov");
    Room room5 = new Room(5l, 100, 2, new Date(1650000000200l), "Gannus", "Moscow");
    Room room6 = new Room(6l, 20, 0, new Date(1650000200000l), "Lanus", "Germani");
    Room room7 = new Room(7l, 120, 3, new Date(1650000300000l), "Tranus", "Kiev");
    Room room8 = new Room(8l, 110, 1, new Date(1650000400000l), "Tanrus", "English");
    Room[] requestRooms = new Room[]{room1, room2, room3, room4, room5, room6, room7, room8};

//массив комнат - 2
    Room room31 = new Room(3l, 10000, 50, new Date(1650000000000l), "TFnus", "Lyvov");
    Room room41 = new Room(7l, 0, 3, new Date(1650000300000l), "Tranus", "Kiev");
    Room room51 = new Room(5l, 80, 1, new Date(1650000000200l), "Gannus", "Moscow");
    Room[] requestRooms2 = new Room[]{room31, room41, room51};

//передача массива комнат на  три API
    API[] api={new GoogleAPI(requestRooms),new BookingComAPI(requestRooms),new TripAdvisorAPI(requestRooms),};

    public  Room[] getRequestRooms() {
        return requestRooms;
    }

    public Room[] getRequestRooms2() {
        return requestRooms2;
    }

    public API[] getApi() {
        return api;
    }


    public static void main(String[] args) {
        Demo2 demo =new Demo2();
        Controller controller = new Controller(demo.getApi());

//запросы
     // 1+
//       System.out.println(Arrays.toString(controller.requestRooms(50, 3, "Kiev", "Tanus")));
       System.out.println(Arrays.toString(controller.requestRooms(100000, 50, "Lyvov", "TFnus")));
    // 2+
//        API api1 = new BookingComAPI(demo.getRequestRooms());
//        API api2 = new TripAdvisorAPI(demo.getRequestRooms2());
//        System.out.println(Arrays.toString(controller.check(api1, api2)));
//    // 3+
//        System.out.println(controller.cheapestRoom());



    }
}

