package A_GROM_lesson.lesson15.A_HW.lesson15B;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = totalRooms(price, persons, city, hotel);
        Room[] methodRoom = new Room[count];

        if (count == 0) {
            return methodRoom;
        }

        int number = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price && rooms[i].getCityName().equalsIgnoreCase(city) && rooms[i].getHotelName().equalsIgnoreCase(hotel)) {
                if (((persons - 1) <= rooms[i].getPersons()) &&  (rooms[i].getPersons() <= (persons + 1))) {
                    methodRoom[number] = rooms[i];
                    number++;
                }
            }
        }
        return methodRoom;
    }


    @Override
    public Room[] getAll() {
        return rooms;
    }


    private int totalRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price && rooms[i].getCityName().equalsIgnoreCase(city) && rooms[i].getHotelName().equalsIgnoreCase(hotel)) {
                if (((persons - 1) <= rooms[i].getPersons()) &&  (rooms[i].getPersons() <= (persons + 1))) {
                    count++;
                }
            }
        }
        return count;
    }
}
