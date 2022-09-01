package A_GROM_lesson.lesson36.A_demo;

import A_GROM_lesson.lesson36.B_model.Filter;
import A_GROM_lesson.lesson36.C_controller.RoomController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) {
        Date dateFrom=null;
        Date dateTo=null;
        try{
            String dateFromStr="02-01-2022";
            String dateToStr="04-04-2022";
            dateFrom=new SimpleDateFormat("dd-MM-yyyy").parse(dateFromStr);
            dateTo=new SimpleDateFormat("dd-MM-yyyy").parse(dateToStr);
        }catch(Exception e){
            System.out.println(e);
        }
// ------------------------------------------------ 1 блок -------------------------------------------------------------
        System.out.println(RoomController.findRooms(new Filter(2,700.45,false,true,dateFrom,"Ukraine","Harkov")));

// ------------------------------------------------ 2 блок -------------------------------------------------------------
// добавление комнаты
//        System.out.println(RoomController.addRoom(new Room(2,700.25,true,false,new Date(),new Hotel(2000000019,"Reikartz","Russia","Moscow","Grum"))));
//
//        UserController.login("lorder","34592");
//        System.out.println(RoomController.addRoom(new Room(2,700.25,true,false,new Date(),new Hotel(2000000019,"Reikartz","Russia","Moscow","Grum"))));
//
//        UserController.login("frolov","aD12345*");
//        System.out.println(RoomController.addRoom(new Room(2,700.25,true,false,new Date(),new Hotel(2000000019,"Reikartz","Russia","Moscow","Grum"))));

// --------------------------------------------- 3 блок -----------------------------------------------------
// удаление комнаты (не делал - проверку есть такая комната или нет, так как нужны дополнительные парамметры
//        RoomController.deleteRoom(4000000063l);
//
//        UserController.login("lorder","34592");
//        RoomController.deleteRoom(4000000063l);
//
//        UserController.login("frolov","aD12345*");
//        RoomController.deleteRoom(4000000075l);
    }
}