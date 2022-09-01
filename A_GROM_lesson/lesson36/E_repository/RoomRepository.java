package A_GROM_lesson.lesson36.E_repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class RoomRepository {

    public static Map<String, String> searchFromFileAll(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, String idHotel, String path) {
        UserRepository.validate(path);
        String numberOfGuestsStr=Integer.toString(numberOfGuests);
        String priceStr=Double.toString(price);
        String breakfastIncludedStr=Boolean.toString(breakfastIncluded);
        String petsAllowedStr=Boolean.toString(petsAllowed);
        String dateAvailableFromStr=new SimpleDateFormat("dd-MM-yyyy").format(dateAvailableFrom);

        Map<String, String> map = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            map = new TreeMap<>();
            while ((line = br.readLine()) != null) {
                if (line.contains(numberOfGuestsStr) &&  line.contains(priceStr) &&  line.contains(breakfastIncludedStr)
                        &&  line.contains(petsAllowedStr) &&  line.contains(dateAvailableFromStr) &&  line.contains(idHotel)) {
                    map.put(line.split(",")[0], line);
                }
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
        return map;
    }
}
