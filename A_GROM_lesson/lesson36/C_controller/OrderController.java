package A_GROM_lesson.lesson36.C_controller;

import A_GROM_lesson.lesson36.D_service.OrderService;
import java.util.Date;

public class OrderController {
    private static OrderService orderService=new OrderService();

    public static void bookRoom(long userId,long roomId,Date dateFrom, Date dateTo,double moneyPaid){
        orderService.bookRoom(userId,roomId,dateFrom,dateTo,moneyPaid);
    }

    public static void cancelReservation(long userId,long roomId,Date dateFrom, Date dateTo){
        orderService.cancelReservation(userId,roomId,dateFrom,dateTo);
    }
}
