package A_GROM_lesson.lesson36.D_service;

import A_GROM_lesson.lesson36.B_model.ENUM.UserType;
import A_GROM_lesson.lesson36.B_model.Hotel;
import A_GROM_lesson.lesson36.E_repository.HotelRepository;
import A_GROM_lesson.lesson36.E_repository.UserRepository;
import A_GROM_lesson.lesson27.A_HW.lesson27B.Exception.BadRequestException;

import java.util.*;

public class HotelService {
    private static final String fileFromPath = "E:\\3.0_Java\\library\\dateBase\\HotelDb.txt";
    private static HotelRepository hotelRepository = new HotelRepository();


    public static Set<Hotel> findHotel(String name) {
        return coollectHotel(hotelRepository.searchFromFileOne(name, fileFromPath));
    }


    public static Hotel addHotel(Hotel hotel) {
        Hotel hotelNew = null;
       if (UserService.isStatus() && UserService.getUserType() == UserType.ADMIN) {
            try {
                if (!(UserRepository.searchFastFromFile(hotel.getName(), hotel.getCountry(), hotel.getCity(), hotel.getStreet(), fileFromPath).isEmpty()))
                    throw new BadRequestException("Hotel with such parameters exists");
                hotelNew = new Hotel(UserRepository.id(fileFromPath), hotel.getName(), hotel.getCountry(), hotel.getCity(), hotel.getStreet());
                UserRepository.addToFile(hotelNew.toString(), fileFromPath);
            } catch (BadRequestException e) {
                System.err.println("Error: " + e.getMessage());
            }
       }
        return hotelNew;
    }

    public static void deleteHotel(long hotelId) {
        if (UserService.isStatus() && UserService.getUserType() == UserType.ADMIN)
            hotelRepository.deleteToFrom(UserRepository.searchFastFromFile(Long.toString(hotelId), "", "", "", fileFromPath), fileFromPath);
    }

    public static String getFileFromPath() {
        return fileFromPath;
    }


    private static Set<Hotel> coollectHotel(Map<Long, String> map) {
        Set<Hotel> list = new TreeSet<>();
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            String[] array = entry.getValue().split(",");
            list.add(new Hotel(Long.valueOf(array[0]), array[1], array[2], array[3], array[4]));
        }
        return list;
    }
}
