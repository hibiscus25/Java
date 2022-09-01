package A_GROM_lesson.lesson15.A_HW.lesson15B;


public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room temp=new Room(0, price, persons, null, hotel,city);
        int count = totalRooms(temp);
        Room[] methodRoom = new Room[count];

        if(count==0){
            return methodRoom;
        }

        int number=0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(temp)) {
                methodRoom[number] = rooms[i];
                number++;
            }
        }
        return methodRoom;
    }



    @Override
    public Room[] getAll() {
        return rooms;
    }


    private int totalRooms(Room temp){
        int count = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(temp)) {
                count++;
            }
        }
       return count;
    }
}
