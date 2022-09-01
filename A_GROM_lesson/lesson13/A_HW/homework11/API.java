package A_GROM_lesson.lesson13.A_HW.homework11;

public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
