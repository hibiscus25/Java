package B_ReadMe.B11_Input_Output;

import java.io.*;
import java.util.Properties;

public class ExamInput_Output {
        public static final String pathDir = "src\\B_readMe\\B11_Input_Output\\TEMP";
        public static final String nameFile = "exam.txt";
        public static final String nameFile2 = "exam2.txt";
        public static final String nameFile3 = "data.properties";
        public static final String pathFile = pathDir + "\\" + nameFile;
        public static final String pathFile2 = pathDir + "\\" + nameFile2;
        public static final String pathFileData = pathDir + "\\examData.bin";
        public static final String pathFileBin = pathDir + "\\exam.bin";

        public static File dir = new File(pathDir);

        // cоздание папки с файлами на рабочем столе
        public static void createDirFiles() throws IOException{
            if(!dir.exists())
                dir.mkdir();
        }


        // рекурсивное удаление папки
        public static void deletedDirFiles(File file){
                if (file.isDirectory()) {
                    for(File f : file.listFiles())
                        deletedDirFiles(f);
                }
                file.delete();
        }


        public static void main(String[] args) throws IOException, ClassNotFoundException {
            createDirFiles();

        // ------------------------------------------- FileOutputStream ------------------------------------------------
            OutputStream os = new FileOutputStream(pathFile , true);
                    os.write(50);
                    os.write(50);
                    os.write(50);
                    os.write(10);
            os.close();

            // Запись строки в файл
            String text = "Hello World!\n";
            FileOutputStream fos = new FileOutputStream(pathFile , true);
                byte[] buffer = text.getBytes();
                fos.write(buffer, 3, buffer.length-3);
                // используя перегрузку метода write(), можно записать и одиночный байт:
                fos.write(buffer[0]);
                fos.write(10);                                                        // перенос на следующую строку
            fos.close();


        // ------------------------------------------- FileInputStream -------------------------------------------------
            System.out.println("----------- FileInputStream -----------");
            // Cчитывает данные из файла и вывод содержимого в консоль
            InputStream is = new FileInputStream(pathFile);
                System.out.println("Размер файла: " +  is.available() + " байт(а)");
                int s = 0;
                while( (s = is.read()) != -1)
                    System.out.print((char) s);
            is.close();

            // Данные файла можно считать в массив байтов:
            System.out.println();
            FileInputStream fis = new FileInputStream(pathFile);
            byte[] bufFis = new byte[fis.available()];
                fis.read (bufFis, 0, fis.available());                   // чтение файла в буфер
            for(int i = 0; i < bufFis.length; i++)
                System.out.print((char)bufFis[i]);
            fis.close();


            // Чтение файла свойств в кодировке UTF-8:
            System.out.println();
            String txt = "company=Рога и копыта\nmanager=Остап Бендер";
            byte[] bufTxt = txt.getBytes();
            fos = new FileOutputStream(nameFile3);
                fos.write(bufTxt);
            fis = new FileInputStream(nameFile3);
                Reader reader = new InputStreamReader(fis, "UTF-8");
                    Properties props = new Properties();
                        props.load(reader);
                    System.out.println(props.getProperty("company") + ", " + props.getProperty("manager"));
            fos.close();
            fis.close();

            // Перезапись содержимого из одного файла в другой:
            fis = new FileInputStream(pathFile);
            fos = new FileOutputStream(pathFile2);
                byte[] buff = new byte[fis.available()];
                fis.read(buff, 0, buff.length);                               // считываем буфер
                fos.write(buff, 0, buff.length);                              // записываем из буфера в файл
            fis.close();
            fos.close();

            // Копируем файл на диск
            fis = new FileInputStream(pathFile);
            fos = new FileOutputStream(pathFile2);
            byte[] but = new byte[1000];
            while (fis.available() > 0){
                int count = fis.read(but);
                fos.write(but, 0, count);
            }
            fis.close();
            fos.close();
                // count необходим чтобы:
                //   - когда мы читаем последний блок данных в файле, может оказаться, что байт осталось не 1000, а меньше
                //   - поэтому метод read при чтении последнего блока вернет равное количество прочитанных байтов
                //   - тоесть для всех чтений  - 1000, а для последнего меньше 1000

            // Подсчет суммы всех байт файла на диске
            System.out.println();
            fis = new FileInputStream(pathFile);
                long sum = 0;
                while (fis.available() > 0){                                         //пока остались непрочитанные байты
                    int data = fis.read();                                                 // прочитать очередной байт
                    sum += data;                                                           // добавить его к общей сумме
                }
            fis.close();
            System.out.println("Cумма всех байтов: " + sum);


        // --------------------------------------- ByteArrayOutputStream -----------------------------------------------
            System.out.println();
            System.out.println("----------- ByteArrayOutputStream -----------");
            // Запись в файл из массива байтов
            byte[] buf = text.getBytes();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bos.write(buf);
                    System.out.println(bos);
                byte[] array = bos.toByteArray();                       // вывод в консоль по символьно
                    for (byte b : array)
                        System.out.print((char) b);
            fos = new FileOutputStream(pathFile , true);
                bos.writeTo(fos);                                      // перенаправляет массив байтов в другой поток
            fos.close();

            //P.S.: В отличие от других классов потоков для закрытия объекта НЕ ТРЕБУЕТ вызывать метод close


        // ----------------------------------------- ByteArrayInputStream ----------------------------------------------
            System.out.println();
            System.out.println("----------- ByteArrayInputStream -----------");
            // Чтение массива байтов в консоль:
            byte[] array1 = {1, 3, 5, 7};
            ByteArrayInputStream bis = new ByteArrayInputStream(array1);
                int b;
                while((b = bis.read()) != -1)
                    System.out.print(b);

            System.out.println();
            byte[] array2 = "ByteArrayInputStream!".getBytes();
            ByteArrayInputStream bis2 = new ByteArrayInputStream(array2, 0, 9);
                while((b = bis2.read()) != -1)
                    System.out.print((char)b);

            //P.S.: В отличие от других классов потоков для закрытия объекта НЕ ТРЕБУЕТ вызывать метод close.


        // -------------------------------------- BufferedOutputStream -------------------------------------------------
            BufferedOutputStream bufOs = new BufferedOutputStream(new FileOutputStream(pathFile, true));
                byte[] bt = {50, 50, 50, 10};
                bufOs.write(bt);
                bufOs.write(buffer, 0, buffer.length);
            bufOs.close();


        // -------------------------------------- BufferedInputStream -------------------------------------------------
            System.out.println();
            System.out.println("----------- BufferedInputStream -----------");
            // Простой пример
            BufferedInputStream bufIs = new BufferedInputStream(new FileInputStream(pathFile));
            byte[] bytBuf = new byte[bufIs.available()];     // bufIs.available() - cоздает размер, сколько у нас символов
            while( bufIs.read(bytBuf) != -1)
                for (int i = 0; i < bytBuf.length; i++ )
                System.out.print(bytBuf[i]);
            bufIs.close();

            // Чтение с массива байтов
            System.out.println();
            byte[] bufByte = "Some BufferedInputStream".getBytes();
            bis = new ByteArrayInputStream(bufByte);
            bufIs = new BufferedInputStream(bis);
                int c;
                while((c = bufIs.read()) != -1)
                    System.out.print((char)c);
            bis.close();
            bufIs.close();
            System.out.println();


        // ---------------------------------------- DataOutputStream ---------------------------------------------------
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathFileData, true));
                dos.writeUTF("Киса Воробьянинов");
                dos.writeInt(30);
                dos.writeDouble(20.58);
                dos.writeBoolean(false);
            dos.close();


        // ----------------------------------------- DataInputStream ---------------------------------------------------
            System.out.println();
            System.out.println("----------- DataInputStream -----------");
            // Чтение из бинарного файла с использованием DataInputStream
            DataInputStream dis = new DataInputStream(new FileInputStream(pathFileData));
                String name     = dis.readUTF();
                int age         = dis.readInt();
                double height   = dis.readDouble();
                boolean married = dis.readBoolean();
                System.out.printf("Человека зовут: %s ; " +  "его возраст: %d , " +  "его рост: %f метров, "
                        +  "женат/замужем: %b", name, age, height, married);
            dis.close();
            System.out.println();


        // ------------------------------------------ PrintStream ------------------------------------------------------
            // Запись информации в файл
            PrintStream printStream = new PrintStream(new FileOutputStream(pathFile, true));
                printStream.print("\n" + "PrintStream");              // производится запись информации в выходной поток
            printStream.close();


        // ------------------------------------------ ObjectOutputStream -----------------------------------------------
            // Cериализации класса Person
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFileBin, true));
                oos.writeObject (new Person("Остап Бендер",35,175,false));
            oos.close();

            //PS: Сериализовать можно только те объекты, которые реализуют интерфейс Serializable


        // ------------------------------------------- ObjectInputStream -----------------------------------------------
            System.out.println();
            System.out.println("----------- ObjectInputStream -----------");
            // Десериализации класса Person
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFileBin));
                Person person = (Person) ois.readObject();
                System.out.printf("Имя: %s \t Возраст: %d \n", person.name, person.age);
            ois.close();
            System.out.println();


        // -------------------------------------------- PipedOutputStream ----------------------------------------------
//            System.out.println();
//            System.out.println("----------- PipedOutputStream -----------");
//            // Пример
//            byte[] bytes = "Hello, World!".getBytes();
//            PipedOutputStream pos = new PipedOutputStream();
//            PipedInputStream  pis = new PipedInputStream();
//                pos.connect(pis);                                       // установление связи между "трубами"
//                for (int i = 0; i < bytes.length; i++)                  // запись данных в PipedOutputStream
//                    pos.write(bytes[i]);
//                int c;
//                while((c = pis.read() ) != -1)                          // чтение данных из PipedInputStream
//                    System.out.print((char) c);
//            pis.close();
//            pos.close();


        // -------------------------------------------- PipedInputStream -----------------------------------------------
//            Пример простого использования PipedInputStream :
//            InputStream input = new PipedInputStream (new PipedOutputStream());
//            int data = input.read();
//            while(data != -1) {
//                data = input.read();
//                System.out.println(data);
//            }
//            input.close();


        // ----------------------------------- удаление временных файлов -----------------------------------------------
            deletedDirFiles(dir);
            new File(nameFile3).delete();
        }
    }


    // класс для сериализации / десериализации
    class Person implements Serializable{
        private static final long serialVersionUID = 1L;

        public String  name;
        public int age;
        public double  height;
        public boolean married;

        Person(String name, int age, double height, boolean married){
            this.name    = name;
            this.age     = age;
            this.height  = height;
            this.married = married;
        }
    }
