package A_GROM_lesson.lesson36.A_demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) throws Exception {
        Date dateFrom=null;
        Date dateTo=null;
        try{
            String dateFromStr="15-01-2022";
            String dateToStr="20-01-2022";
            dateFrom=new SimpleDateFormat("dd-MM-yyyy").parse(dateFromStr);
            dateTo=new SimpleDateFormat("dd-MM-yyyy").parse(dateToStr);
        }catch(Exception e){
            System.out.println(e);
        }
// ----------------------------------------------- 1 блок -------------------------------------------------------------
//бронирование ордера
//        OrderController.bookRoom(107l, 4000000014l, dateFrom, dateTo, 200.45);
//
//        UserController.login("lorder","34592");

//такой ордер уже есть (такой ордер уже есть в базе данных)
//        OrderController.bookRoom(108l, 4000000027l, dateFrom, dateTo, 200.45);

//комната не доступна с указанного числа (с 15-01-2022 по 23-01-2022 - квартира доступна с 21-03-2022)
//        OrderController.bookRoom(102l, 4000000039l, dateFrom, dateTo, 199.30);

//комната не доступна в указанный отрезок времени (с 15-01-2022 по 23-01-2022 - проверяем 12-01-2022 по 22-01-2022)
//        OrderController.bookRoom(108l, 4000000027l, dateFrom, dateTo, 200.45);

//комната не доступна в указанный отрезок времени (с 15-01-2022 по 23-01-2022 - проверяем 24-01-2022 по 27-01-2022)
//        OrderController.bookRoom(108l, 4000000027l, dateFrom, dateTo, 200.45);


// ----------------------------------------------- 2 блок -------------------------------------------------------------
//удаление брони
        //(с 15-01-2022 по 20-01-2022)
//        OrderController.cancelReservation(106, 4000000033l, dateFrom, dateTo);
//
//        UserController.login("lorder","34592");
//        OrderController.cancelReservation(106, 4000000033l, dateFrom, dateTo);
    }
}