package A_GROM_lesson.lesson36.D_service;

import A_GROM_lesson.lesson36.B_model.ENUM.UserType;
import A_GROM_lesson.lesson36.B_model.Filter;
import A_GROM_lesson.lesson36.B_model.Hotel;
import A_GROM_lesson.lesson36.B_model.Room;
import A_GROM_lesson.lesson36.E_repository.HotelRepository;
import A_GROM_lesson.lesson36.E_repository.RoomRepository;
import A_GROM_lesson.lesson36.E_repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RoomService {
    private static boolean statusActive = UserService.isStatus();
    private static UserType userType = UserService.getUserType();
    private static final String fileFromPath = "E:\\3.0_Java\\library\\dateBase\\RoomDb.txt";
    private static RoomRepository roomRepository = new RoomRepository();


    public static Set<Room> findRooms(Filter filter) {
        Set<Room> list = new TreeSet<>();
        Map<String, String> map = HotelRepository.searchFromFileTwo(filter.getCountry(), filter.getCity(), HotelService.getFileFromPath());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] array = entry.getValue().split(",");
            Hotel hotel = new Hotel(Long.valueOf(array[0]), array[1], array[2], array[3], array[4]);
            Map<String, String> mapAll = roomRepository.searchFromFileAll(filter.getNumberOfGuests(), filter.getPrice(), filter.isBreakfastIncluded(), filter.isPetsAllowed(), filter.getDateAvailableFrom(), entry.getKey(), fileFromPath);

            for (Map.Entry<String, String> en : mapAll.entrySet()) {
                String[] arrayRoom = en.getValue().split(",");
                try {
                    list.add(new Room(Long.valueOf(arrayRoom[0]), Integer.parseInt(arrayRoom[1]), Double.valueOf(arrayRoom[2]), Boolean.valueOf(arrayRoom[3]), Boolean.valueOf(arrayRoom[4]), new SimpleDateFormat("dd-MM-yyyy").parse(arrayRoom[5]), hotel));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static Room addRoom(Room room) {
        Room roomNew = null;
        if (UserService.isStatus() && UserService.getUserType() == UserType.ADMIN)  {
            roomNew = new Room(UserRepository.id(fileFromPath), room.getNumberOfGuests(), room.getPrice(), room.isBreakfastIncluded(), room.isPetsAllowed(), room.getDateAvailableFrom(), room.getHotel());
            UserRepository.addToFile(roomNew.toString(), fileFromPath);
        }
        return roomNew;
    }

    public static void deleteRoom(long roomId) {
        if (UserService.isStatus() && UserService.getUserType() == UserType.ADMIN)
        HotelRepository.deleteToFrom(UserRepository.searchFastFromFile(Long.toString(roomId), "", "", "", fileFromPath), fileFromPath);
    }

    public static String getFileFromPath() {
        return fileFromPath;
    }
}
