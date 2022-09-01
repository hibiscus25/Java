package A_GROM_lesson.lesson15.A_HW.lesson15B;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        //cоздаю двумерный массив, для возможности  собрать воедино неизвестное количество  AПИ
        Room[][] rooms = new Room[apis.length][];
        int countSize = 0;
        for (int i = 0; i < apis.length; i++) {
            rooms[i] = apis[i].findRooms(price, persons, city, hotel);
            countSize += rooms[i].length;
        }

        //проверка, есть совпадения или нет
        if (countSize == 0) {
            System.err.println("Cовпадений по заданным параметрам  не найдены");
            System.exit(0);
        }

        //конвертирую в одномерный массив
        Room[] roomTemp = new Room[countSize];
        int number = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                roomTemp[number++] = rooms[i][j];
            }
        }

        //зачищаю похожие  комнаты, если есть одинаковые комнаты из разных АПИ
        int countPlace = 0;
        for (int i = 0; i < roomTemp.length - 1; i++) {
            for (int m = i + 1; m < roomTemp.length; m++) {
                if ((roomTemp[i] != null && roomTemp[m] != null) && (roomTemp[i].getId() == roomTemp[m].getId())) {
                    roomTemp[m] = null;
                    countPlace++;
                }
            }
        }

        //удаляю null - результирующий массив
        int num = 0;
        Room[] roomResult = new Room[countSize-countPlace];
        for (int i = 0; i < roomTemp.length; i++) {
            if (roomTemp[i] != null) {
                roomResult[num++] = roomTemp[i];
            }
        }

        return roomResult;
    }


    public Room[] check(API api1, API api2) {
        Room[] roomsOne = api1.getAll();
        Room[] roomsTwo = api2.getAll();

        int count = 0;
        for (int i = 0; i < roomsTwo.length; i++) {
            for (int j = 0; j < roomsOne.length; j++) {
                if (roomsTwo[i].equals(roomsOne[j]))
                    count++;
            }
        }

        if (count == 0) {
            System.err.println("Cовпадений нет");
            System.exit(0);
        }

        Room[] rooms = new Room[count];
        int number = 0;
        for (int i = 0; i < roomsTwo.length; i++) {
            for (int j = 0; j < roomsOne.length; j++) {
                if (roomsTwo[i].equals(roomsOne[j])) {
                    rooms[number] = roomsOne[j];
                    number++;
                }
            }
        }
        return rooms;
    }


    public Room cheapestRoom() {
        Room result = null;
        Room[] roomsMin = apis[2].getAll();
        int min = roomsMin[0].getPrice();
        for (int i = 1; i < roomsMin.length; i++) {
            if (min >= roomsMin[i].getPrice()) {
                min = roomsMin[i].getPrice();
                result = roomsMin[i];
            }
        }
        return result;
    }
}