package B_ReadMe.B11_Input_Output;

import java.io.*;

public class ExamRandom {
        public static void main(String[] args) throws IOException {
            String pathFile = "src\\B_readMe\\B11_Input_Output\\0.0_ExmRandomAccess.txt";

            BufferedWriter buf = new BufferedWriter(new FileWriter(pathFile, true));
                buf.write("Good Morning people!");
                buf.newLine();
                buf.write("Привет мой свет!");
            buf.close();

       // --------------------------------------------------------------------------------------------------------------
        // ВАЖНО!!!  Не преобразует кириллицу из файла - выдает символы
        RandomAccessFile raf = new RandomAccessFile(pathFile, "r");
            raf.seek(5);                      // перемещаем курсор на 5 символ (по умолчанию стоит на 0)
            System.out.println(raf.readLine());
            System.out.println(raf.readLine());
            raf.seek(0);                     //перемещаем «курсор» на 0-й символ
            System.out.println(raf.readLine());
        raf.close();

        // чтение  - запись
            // ВАЖНО!!!  Байты не вставляются в середину файла, а заменяют те, которые были на их месте
        System.out.println();
        raf = new RandomAccessFile(pathFile, "rw");
            System.out.println(raf.readLine());
            raf.seek(0);
            raf.writeBytes("NEW INFO");
            raf.seek(0);
            System.out.println(raf.readLine());
            raf.seek(8);
            raf.writeBytes("  SUPRISE!");
            raf.seek(0);
            System.out.println(raf.readLine());
        raf.close();

        // -------------------------------------------------------------------------------------------------------------
            new File(pathFile).delete();
    }
}