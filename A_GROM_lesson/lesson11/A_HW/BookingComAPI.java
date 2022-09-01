package A_GROM_lesson.lesson11.A_HW;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = totalRooms(price, persons, city, hotel);
        Room[] methodRoom = new Room[count];

        if(count==0){
            return methodRoom;
        }

        int number=0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPersons() == persons && rooms[i].getCityName().equalsIgnoreCase(city) && rooms[i].getHotelName().equalsIgnoreCase(hotel)) {
                if((price - 100)<=rooms[i].getPrice() && rooms[i].getPrice()<=(price + 100)) {
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
            if (rooms[i].getPersons() == persons && rooms[i].getCityName().equalsIgnoreCase(city) && rooms[i].getHotelName().equalsIgnoreCase(hotel)) {
                if((price - 100)<=rooms[i].getPrice() && rooms[i].getPrice()<=(price + 100)) {
                    count++;
                }
            }
        }
        return count;
    }
}
