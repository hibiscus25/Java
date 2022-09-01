package B_ReadMe.B8_Serializable;

import java.io.*;

// используется для ручной сериализации объекта - работает быстрее, чем сериализация

public class Z_Externalizer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
            house.rooms = 5;

        // записываем в файл
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src\\B_ReadMe\\B8_Serializable\\people.bin"));
            house.writeExternal(output);
        output.close();

        //читаем с файла
        House house2 = new House();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(("src\\B_ReadMe\\B8_Serializable\\people.bin")));
            house2.readExternal(input);
        System.out.println(house2.rooms);
    }

    static class House implements Externalizable{
        int rooms;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(rooms);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            rooms = in.readInt();
        }
    }
}
