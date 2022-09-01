package B_ReadMe.B11_Input_Output;

import java.io.*;
import java.util.Scanner;

    public class ExamReadWrite {
        public static void main(String[] args) throws IOException {
            String pathFile = "src\\B_readMe\\B11_Input_Output\\0.0_ReadWrite.txt";

        // --------------------------------------------- FileWriter ----------------------------------------------------
            // Запись посимвольно
            Writer wr = new FileWriter(pathFile, true);
                wr.write("str1\n");
                wr.write("str2\n");
            wr.close();

        // --------------------------------------------- FileReader ----------------------------------------------------
            // Чтение по символьно
            System.out.println("----------- FileReader -----------");
            Reader rd = new FileReader(pathFile);
            int i = 0;
            while( (i = rd.read()) != -1)
                System.out.print((char) i);
            rd.close();


        // -------------------------------------------- BufferedWriter -------------------------------------------------
            // Запись строки в файл
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile, true));
                bw.write("Данную строку запишем в файл\n");
            bw.close();

            // Запись массив строк
            String[] array = { "one", "two", "three", "four" };
            bw = new BufferedWriter(new FileWriter(pathFile, true));
            for (String el : array)
                bw.write(el + "\n");
            bw.close();

            // Запись cтрок + перенос на новую линию
            bw = new BufferedWriter(new FileWriter(pathFile, true));
                bw.write("str3");
                bw.newLine();
                bw.write("str4");
                bw.newLine();
            bw.close();


        // -------------------------------------------- BufferedReader -------------------------------------------------
            System.out.println();
            System.out.println("----------- BufferedReader -----------");
            //чтение построчно
            BufferedReader buf = new BufferedReader(new FileReader(pathFile));
                String line;
                while((line = buf.readLine()) != null)
                    System.out.println(line);
            buf.close();

            // Вариант 1 - считываем данные с консоли и записываем в файл, через BufferedReader + InputStreamReader(System.in)
//            BufferedReader readIn = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter writFile = new BufferedWriter(new FileWriter(pathFile, true));
//                String lin;
//                while (!(lin = readIn.readLine()).equals("exit"))           // exit - прерывание записи
//                    writFile.write(lin);
//            readIn.close();
//            writFile.close();


            // Варинат 2 - cчитывание данных с консоли, через System.in
                // System.in (объект InputStream) — входящий поток и он привязан к системному устройству ввода данных — клавиатуре
                // System.in   — поток для получения данных с клавиатуры
                // System.out  — поток для отправки данных на консоль
//                while (true) {                                          // Результат  от  считывания:
//                    int x = System.in.read();                           // Я   - 208 175 10
//                    System.out.println(x);
//                }

            // Варинат 3 - cчитывание данных с консоли InputStreamReader(System.in)
//            InputStreamReader inRead = new InputStreamReader(System.in);
//                while (true) {                                           // Результат от считывания:
//                    int x = inRead.read();                               // Я   - 1071 10
//                    System.out.println(x);
//                }

            /*      Разница варианта 1 и варианта 2:
                        - последний байт - для переноса строки - остался без изменений  (число 10)
                        - считанная буква  “Я” была преобразована в единый код “1071”
                    Так как InputStreamReader умеет и считывать данные и  конвертировать байты в символы, он более лучше
                чем System.in, а учитывая что BufferedReader использует буфер (экономя ресурсы), поэтому лучше использовать
                BufferedReader + InputStreamReader, чем просто InputStreamReader
            */


        // ----------------------------------------- Scanner / PrintWriter ---------------------------------------------
        System.out.println();
        System.out.println("----------- Scanner / PrintWriter -----------");
        Scanner scn = new Scanner(new FileReader(pathFile));                            // читает из файла и выводит в консоль
            while (scn.hasNext())
                System.out.println(scn.next());
        scn.close();
        PrintWriter pw = new PrintWriter((new FileWriter(pathFile, true)));     // записывает в файл
            pw.write("\nstr22\n");
            pw.write("str33\n");
        pw.close();


        // ------------------------------------------ удаление файла ---------------------------------------------------
            new File(pathFile).delete();
        }
    }