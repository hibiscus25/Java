package A_GROM_lesson.lesson13.A_HW.homework11;

import java.util.Arrays;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        Room[] rooms11 = apis[0].findRooms(price, persons, city, hotel);
        Room[] rooms12 = apis[1].findRooms(price, persons, city, hotel);
        Room[] rooms13 = apis[2].findRooms(price, persons, city, hotel);

        if (rooms11 == null && rooms12 == null && rooms13 == null)
            return null;

        if (Arrays.deepEquals(rooms11, rooms12) && Arrays.deepEquals(rooms11, rooms13))
            return rooms11;

        int count = rooms11.length + 1 + rooms12.length + 1 + rooms13.length;
        int count1 = rooms11.length;
        int count2 = rooms11.length + 1 + rooms12.length;

        Room[] rooms1 = new Room[count];
        rooms1[count1] = null;
        rooms1[count2] = null;
        for (int i = 0; i < count1; i++) {
            rooms1[i] = rooms11[i];
        }
        int j = 0;
        for (int i = (count1 + 1); i < count2; i++) {
            rooms1[i] = rooms12[j];
            j++;
        }
        int k = 0;
        for (int i = (count2 + 1); i < count; i++) {
            rooms1[i] = rooms13[k];
            k++;
        }
        return rooms1;
    }

    //Необходимо прорабатывать момент, когда массив 2 больше массива 1
    //Необходимо прорабатывать вариант, чтобы перенсти все решение в АПИ
    public Room[] check(API api1, API api2) {
        int count = 0;
        int number = 0;
        Room[] rooms21 = api1.getAll();
        Room[] rooms22 = api2.getAll();

        for (int i = 0; i < rooms22.length; i++) {
            for (int j = 0; j < rooms21.length; j++) {
                if (rooms22[i].getPrice() == rooms21[j].getPrice() && rooms22[i].getPersons() == rooms21[j].getPersons() && rooms22[i].getCityName().equalsIgnoreCase(rooms21[j].getCityName()) && rooms22[i].getHotelName().equalsIgnoreCase(rooms21[j].getHotelName()))
                    count++;
            }
        }

        if (count == 0) {
            System.err.println("Cовпадений нет");
            return null;
        }

        Room[] rooms = new Room[count];
        for (int i = 0; i < rooms22.length; i++) {
            for (int j = 0; j < rooms21.length; j++) {
                if (rooms22[i].getPrice() == rooms21[j].getPrice() && rooms22[i].getPersons() == rooms21[j].getPersons() && rooms22[i].getCityName().equalsIgnoreCase(rooms21[j].getCityName()) && rooms22[i].getHotelName().equalsIgnoreCase(rooms21[j].getHotelName())) {
                    rooms[number] = rooms21[j];
                    number++;
                }
            }
        }
        return rooms;
    }


    //передает массив самых дешевых, если их несколько
//в методе уже берем самый первый  из массива
    public Room cheapestRoom() {
        Room[] rooms3 = apis[2].getAll();
        Room resultRoom = rooms3[0];
        return resultRoom;
    }
}