package A_GROM_lesson.lesson15.A_HW.lesson15B;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
//массив комнат
        Room room1 = new Room(1l, 750, 3, new Date(1650000000000l), "Tanus", "Kiev");
        Room room2 = new Room(2l, 700, 1, new Date(1650000000000l), "Franus", "Dnepr");
        Room room3 = new Room(3l, 170, 2, new Date(1650000000000l), "TFnus", "Lyvov");
        Room room4 = new Room(4l, 100, 1, new Date(1650000000000l), "Tanrus", "English");
        Room room5 = new Room(5l, 150, 1, new Date(1650000000200l), "Gannus", "Moscow");
        Room room6 = new Room(6l, 55, 4, new Date(1650000200000l), "Lanus", "Germani");
        Room room7 = new Room(7l, 100, 2, new Date(1650000300000l), "Graguus", "Moscow");
        Room room8 = new Room(8l, 100, 2, new Date(1650000400000l), "Tanrus", "English");
        Room room9 = new Room(9l, 150, 1, new Date(1650000000200l), "Gannus", "Moscow");
        Room room10 = new Room(10l, 100, 1, new Date(1650000200000l), "Tanrus", "English");
        Room room11 = new Room(11l, 100, 1, new Date(1650000300000l), "Tanrus", "English");
        Room room12 = new Room(12l, 100, 3, new Date(1650000400000l), "Tanrus", "English");
        Room room13 = new Room(13l, 100, 2, new Date(1650000300000l), "Graguus", "Moscow");
        Room room14 = new Room(14l, 180, 2, new Date(1650000400000l), "Tanrus", "English");
        Room room15 = new Room(15l, 150, 1, new Date(1650000000200l), "Gannus", "Moscow");
        Room room16 = new Room(16l, 150, 1, new Date(1650000200000l), "Tanrus", "English");
        Room room17 = new Room(17l, 100, 1, new Date(1650000300000l), "Tanrus", "English");
        Room room18 = new Room(18l, 200, 1, new Date(1650000400000l), "Tanrus", "English");


        Room[] requestRooms = new Room[]{room1, room2, room3, room4, room5, room6, room7, room8,room9, room10, room11,room12,room13, room14,room15, room16, room17,room18};
//передача массива интерфейсных переменных в контроллер
//передача массива комнат на  три API
        API[] api=new API[3];
        api [0]= new BookingComAPI(requestRooms);
        api [1]= new TripAdvisorAPI(requestRooms);
        api [2]= new GoogleAPI(requestRooms);
        Controller controller = new Controller(api);

//запросы
     // 1+
       System.out.println(Arrays.toString(controller.requestRooms(150, 1, "English", "Tanrus")));
//       System.out.println(Arrays.toString(controller.requestRooms(100,1, "English", "Tanrus")));

    // 2+
//        API api1 = new BookingComAPI(requestRooms);
//        Room room31 = new Room(3l, 151, 2, new Date(1650000000000l), "TFnus", "Lyvov");
//        Room room41 = new Room(6l, 56, 4, new Date(1650000200000l), "Lanus", "Germani");
//        Room room51 = new Room(7l, 101, 2, new Date(1650000300000l), "Graguus", "Moscow");
//        Room[] requestRooms2 ={room31, room41, room51};
//        API api2 = new TripAdvisorAPI(requestRooms2);
//        System.out.println(Arrays.toString(controller.check(api1, api2)));

    // 3+
//        System.out.println(controller.cheapestRoom());

//            GoogleAPI googleAPI=new GoogleAPI(requestRooms);
//            BookingComAPI bookingComAPI=new BookingComAPI(requestRooms);
//            TripAdvisorAPI tripAdvisorAPI=new TripAdvisorAPI(requestRooms);
//
//
//            Room[] roomsResult=tripAdvisorAPI.findRooms(100, 2, "English", "Tanrus");
//            for(Room el: roomsResult){
//                System.out.println(el);
//            }
//
//            Room[] roomsResult2=bookingComAPI.findRooms(152, 7, "English", "Tanrus");
//            for(Room el: roomsResult2){
//                System.out.println(el);
//            }


    }
}

