package A_GROM_lesson.lesson13.A_HW.homework11;


public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        Room[] googleArrays = googleAPI.findRooms(price, persons, city, hotel);

        if (googleArrays == null)
            return null;

        int count2 = 0;
        int number = 0;
        Room tmp = googleArrays[0];

        for (int i = 0; i < rooms.length; i++) {
            if (tmp.getPrice() != rooms[i].getPrice()) {
                if ((((tmp.getPrice() - 50) <= rooms[i].getPrice()) && (rooms[i].getPrice() < tmp.getPrice())) || ((rooms[i].getPrice() > tmp.getPrice()) && (rooms[i].getPrice() <= (tmp.getPrice() + 50)))) {
                    count2++;
                }

            }
        }

        Room[] methodRoom1 = new Room[googleArrays.length + count2];
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price && rooms[i].getPersons() == persons && rooms[i].getCityName().equalsIgnoreCase(city) && rooms[i].getHotelName().equalsIgnoreCase(hotel)) {
                methodRoom1[number] = rooms[i];
                number++;
            }
        }
        if (count2 != 0) {
            for (int i = 0; i < rooms.length; i++) {
                if (tmp.getPrice() != rooms[i].getPrice()) {
                    if (((tmp.getPrice() - 50) <= rooms[i].getPrice()) && (rooms[i].getPrice() < tmp.getPrice())) {
                        methodRoom1[number] = rooms[i];
                        number++;
                    }
                }
            }
            for (int i = 0; i < rooms.length; i++) {
                if (tmp.getPrice() != rooms[i].getPrice()) {
                    if ((rooms[i].getPrice() > tmp.getPrice()) && (rooms[i].getPrice() <= (tmp.getPrice() + 50))) {
                        methodRoom1[number] = rooms[i];
                        number++;
                    }
                }
            }
        }
        return methodRoom1;
    }


    //общие параметры
    @Override
    public Room[] getAll() {
        return rooms;
    }
}
