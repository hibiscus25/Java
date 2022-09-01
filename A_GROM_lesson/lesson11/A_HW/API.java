package A_GROM_lesson.lesson11.A_HW;

public interface API {
    Room[] findRooms(int price,int persons,String city,String hotel);
    Room[] getAll();
}
