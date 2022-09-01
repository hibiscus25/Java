package A_GROM_lesson.lesson13.A_HW.homework11;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        Room[] googleArrays = googleAPI.findRooms(price, persons, city, hotel);

        if (googleArrays == null)
            return null;

        int count = 0;
        int count2 = 0;
        int number = 0;
        Room tmp = googleArrays[0];

        for (int i = 0; i < rooms.length; i++) {
            if (tmp.getPersons() != rooms[i].getPersons()) {
                if ((((tmp.getPersons() - 1) <= rooms[i].getPersons()) && (rooms[i].getPersons() < tmp.getPersons())) || ((rooms[i].getPersons() > tmp.getPersons()) && (rooms[i].getPersons() <= (tmp.getPersons() + 1)))) {
                    count2++;
                }

            }
        }

        Room[] methodRoom2 = new Room[googleArrays.length + count2];
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price && rooms[i].getPersons() == persons && rooms[i].getCityName().equalsIgnoreCase(city) && rooms[i].getHotelName().equalsIgnoreCase(hotel)) {
                methodRoom2[number] = rooms[i];
                number++;
            }
        }
        if (count2 != 0) {
            for (int i = 0; i < rooms.length; i++) {
                if (tmp.getPersons() != rooms[i].getPersons()) {
                    if (((tmp.getPersons() - 1) <= rooms[i].getPersons()) && (rooms[i].getPersons() < tmp.getPersons())) {
                        methodRoom2[number] = rooms[i];
                        number++;
                    }
                }
            }
            for (int i = 0; i < rooms.length; i++) {
                if (tmp.getPrice() != rooms[i].getPrice()) {
                    if ((rooms[i].getPersons() > tmp.getPersons()) && (rooms[i].getPersons() <= (tmp.getPersons() + 1))) {
                        methodRoom2[number] = rooms[i];
                        number++;
                    }
                }
            }
        }
        return methodRoom2;
    }


    @Override
    public Room[] getAll() {
        return rooms;
    }
}
