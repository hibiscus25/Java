package A_GROM_lesson.lesson15.A_HW.lesson15B;

public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
