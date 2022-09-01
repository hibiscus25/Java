package F_other;

import sun.misc.Unsafe;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


// размещение объектов вне хипа - только в высоко нагруженных приложениях

public class C_ObjectNoHeep {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);  // буфер пишет в native память
            System.out.println(buffer.position());                  // позиция курсора
            System.out.println(buffer.limit());                     // сколько всего есть данных
            System.out.println(buffer.remaining());                 // сколько осталось данных
            System.out.println(buffer.capacity() + "\n");           // сколько всего данных

        buffer.get(new byte[]{1,2,3});                              // записываем массив байтов в Буфер
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.remaining());
            System.out.println(buffer.capacity() + "\n");

        buffer.flip();                                              // возвращает курсор в начало
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.remaining());
            System.out.println(buffer.capacity()+ "\n");

        buffer.clear();                                         // если сохраняем напрямую в память, нужно чистить
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.remaining());
            System.out.println(buffer.capacity()+ "\n");

        // записываем целый файл в буффер
        FileInputStream fileInputStream = new FileInputStream("src\\B_ReadMe\\A_other\\0.OOП.txt");
        FileChannel file = fileInputStream.getChannel();
        int read = file.read(buffer);
        System.out.println(read);
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.remaining());
            System.out.println(buffer.capacity()+ "\n");
        buffer.clear();


        // Unsafe unsafe = Unsafe.getUnsafe();  // сделан для разработчиков Java - напрямую не запускается
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
            long startAdress = unsafe.allocateMemory(1024);         // выделяется память
//            System.out.println(startAdress + "\n");
//                unsafe.putInt(startAdress,5);
//                unsafe.putInt(startAdress + 4, 10);              // добавляем 4 байта (ушли на int 5)
//            System.out.println(unsafe.getInt(startAdress));            // указываю откуда я, хочу читать
//            System.out.println(unsafe.getInt(startAdress + 4));

            Student student = (Student) unsafe.allocateInstance(Student.class);
                student.name = "Smax";
            System.out.println(student.name);
            System.out.println(student.age);
        unsafe.freeMemory(startAdress);                               // очищает память
    }

    static class Student{
        String name;
        int age;

        public Student(){
            this.name = "Max";
            this.age = 22;
        }
    }
}
