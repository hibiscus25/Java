package A_GROM_lesson.lesson36.D_service;

import A_GROM_lesson.lesson36.E_repository.HotelRepository;
import A_GROM_lesson.lesson36.E_repository.OrderRepository;
import A_GROM_lesson.lesson36.E_repository.UserRepository;
import A_GROM_lesson.lesson27.A_HW.lesson27B.Exception.BadRequestException;

import java.text.*;
import java.util.*;


public class OrderService {
    private static final String fileFromPath = "E:\\3.0_Java\\library\\dateBase\\OrderDb.txt";
    private static OrderRepository orderRepository = new OrderRepository();
    private static SimpleDateFormat fr = new SimpleDateFormat("dd-MM-yyyy");


    public static void bookRoom(long userId, long roomId, Date dateFrom, Date dateTo, double moneyPaid) {
        if (UserService.isStatus()) {
            try {
                checkInDb(userId, roomId, dateFrom, dateTo, moneyPaid, fileFromPath);
                String addition = UserRepository.id(fileFromPath) + "," + userId + "," + roomId + "," + fr.format(dateFrom) + "," + fr.format(dateTo) + "," + moneyPaid;
                UserRepository.addToFile(addition, fileFromPath);
            } catch (ParseException | BadRequestException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }


    public static void cancelReservation(long userId, long roomId, Date dateFrom, Date dateTo) {
        if (UserService.isStatus()) {
            Map<Long, String> map = UserRepository.searchFastFromFile(Long.toString(userId), Long.toString(roomId), fr.format(dateFrom), fr.format(dateTo), fileFromPath);
            HotelRepository.deleteToFrom(map, fileFromPath);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------

    private static boolean roomDateFrom(String idRoom, Date dateFrom, String path) throws ParseException {
        Map<Long, String> map = UserRepository.searchFastFromFile(idRoom, "", "", "", path);
        if (map.isEmpty())
            return false;
        long key = map.keySet().hashCode();
        if (dateFrom.compareTo(fr.parse(map.get(key).split(",")[5])) < 0)
            return true;
        return false;
    }

    private static boolean orderDate(String idRoom, Date dateFrom, Date dateTo) throws ParseException {
        Map<Long, String> map = HotelRepository.searchFromFileOne(idRoom, fileFromPath);
        LinkedList<Date> list = new LinkedList<>();
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            String[] array = entry.getValue().split(",");
            list.add(fr.parse(array[3]));
            list.add(fr.parse(array[4]));
        }

        if (dateFrom.compareTo(list.get(0)) < 0 && dateTo.compareTo(list.get(0)) < 0)
            return true;
        if (list.get(list.size() - 1).compareTo(dateFrom) < 0 && list.get(list.size() - 1).compareTo(dateTo) < 0)
            return true;
        for (int i = 1; i < list.size() - 1; i += 2) {
            boolean a = false;
            boolean b = false;
            if (list.get(i).compareTo(dateFrom) < 0 && list.get(i).compareTo(dateTo) < 0)
                a = true;
            if (dateFrom.compareTo(list.get(i + 1)) < 0 && dateTo.compareTo(list.get(i + 1)) < 0)
                b = true;
            if (a == true && b == true) {
                return true;
            }
        }
        return false;
    }

    private static void checkInDb(long userId, long roomId, Date dateFrom, Date dateTo, double moneyPaid, String path) throws BadRequestException, ParseException {
        String idUser = Long.toString(userId);
        String idRoom = Long.toString(roomId);
        String dateFromSt = fr.format(dateFrom);
        String dateToSt = fr.format(dateTo);
        if (!UserRepository.searchFastFromFile(idUser, idRoom, dateFromSt, dateToSt, fileFromPath).isEmpty())
            throw new BadRequestException("You already have such a reservation -" + idRoom);
        if (roomDateFrom(idRoom, dateFrom, RoomService.getFileFromPath()))
            throw new BadRequestException("Room not available from -" + dateFrom);
        if (!orderDate(idRoom, dateFrom, dateTo))
            throw new BadRequestException("Room not available from - " + dateFrom + " to -" + dateTo);
    }
}
