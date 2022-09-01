package B_ReadMe.B11_Input_Output;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;



    public class ExamZip {
        public final static String pathDIR = "C:\\Users\\Администратор\\Desktop\\DIR";
            public final static String pathFile = pathDIR + "\\EXAMZIP.txt";
            public final static String pathZip = pathDIR + "\\testZip.zip";
            public final static String pathZip2 = pathDIR + "\\ZipNotes.zip";
            public final static String pathDir = pathDIR + "\\testZip";
            public final static String DirToZip = pathDIR + "\\Тестовая папка";
            public final static String zipFolder = pathDIR + "\\тест.zip";
            public final static String ExtrPath = pathDIR + "\\Разархивировано";


        //-------------------------- методы для рекурсивной архивации папок и файлов -----------------------------------
        public static void exec(String DirToZip, String zipFolder) throws FileNotFoundException, IOException {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFolder));
                walkingDir(zos, DirToZip, "");
            zos.close();
        }

        public static void walkingDir(ZipOutputStream zos, String DirToZip, String path) throws IOException {
            String pathMethod = path;                                           //переменная, чтобы когда начался for,
            File[] dirList = new File(DirToZip).listFiles();                        // cохранялось значение тек директории

            for (File f : dirList) {
                if (f.isDirectory()) {
                    String pathNew = pathMethod + f.getName() + File.separator;    // форимурую новое значение пути
                    zos.putNextEntry(new ZipEntry(pathNew));
                    walkingDir(zos, f.getPath(), pathNew);
                    continue;
                } else {
                    try {
                        System.out.println("\t архивируется " + f.getPath());
                        FileInputStream fis = new FileInputStream(f.getPath());
                        zos.putNextEntry(new ZipEntry(pathMethod + f.getName()));

                        int bytesReader = 0;
                        byte[] readBuffer = new byte[2048];
                        while ((bytesReader = fis.read(readBuffer)) != -1) {
                            zos.write(readBuffer, 0, bytesReader);
                        }
                        fis.close();

                    } catch (FileNotFoundException fn) {
                        System.out.println("Error NotFound :" + fn.getMessage());
                    } catch (IOException ioe) {
                        System.out.println("Error :" + ioe.getMessage());
                    }
                }
            }
        }


        public static void main(String[] args) throws IOException {
            File DIR = new File(pathDIR);
                if (!DIR.exists())
                    DIR.mkdir();
            BufferedWriter buf = new BufferedWriter(new FileWriter(pathFile, true));
                buf.write("Good Morning people!");
                buf.newLine();
                buf.write("Привет мой свет!");
            buf.close();

            // ------------------------------------------- ZipOutputStream -------------------------------------------------
                // Создаем архив: копируем с файла в ZipEntry
                    // данные с файла перекопируется в последний по очереди - zip.putNextEntry()
                ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathZip));   // cоздаем Zip - поток
                    ZipEntry entry = new ZipEntry("newDoc.txt");                      // создаем файл хранящийся в архиве
                    ZipEntry entryss = new ZipEntry("newDocNEW.txt");
                    zout.putNextEntry(entry);
                    zout.putNextEntry(entryss);                                              // добавляем в поток ZipEntry
                    Files.copy(Paths.get(pathFile), zout);                                   // копируем данные в Zip - файл
                zout.close();

                // Cоздаем архив: копируем с файла -  в массив байтов  -  ZipEntry
                zout = new ZipOutputStream(new FileOutputStream(pathZip2));
                FileInputStream fis = new FileInputStream(pathFile);
                    ZipEntry ent = new ZipEntry("NOTES.txt");
                    zout.putNextEntry(ent);

                    byte[] buffer = new byte[fis.available()];                   // считываем содержимое файла в массив byte
                    fis.read(buffer);
                    zout.write(buffer);                                          // записываем содержимое массива в ZipEntry
                    zout.closeEntry();                                          // закрываем текущую запись для новой записи
                zout.close();
                fis.close();
                // P.S.:  в конце действий обязательно нужно закрывать  ZipEntry методом closeEntry()
                //             - только после этого можно добавлять в архив новые файлы
                //             - поэтому все вышеописанные действия для каждого нового файла повторяются


            // -------------------------------------------- ZipInputStream -------------------------------------------------
                // Cчитывание всех файлов с архива
                ZipInputStream zin = new ZipInputStream(new FileInputStream(pathZip));
                    ZipEntry zipEnt;
                    String name;
                    long size;

                    new File(pathDir).mkdir();                                              // папка для файлов
                    while ((zipEnt = zin.getNextEntry()) != null) {                            // проверяет есть еще ZipEntry
                        name = zipEnt.getName();
                        size = zipEnt.getSize();
                        System.out.printf("File name: %s \t File size: %d \n", name, size);

                    FileOutputStream fout = new FileOutputStream(pathDir + "\\" + name);
                        for (int c = zin.read(); c != -1; c = zin.read())
                            fout.write(c);
                        fout.flush();
                        zin.closeEntry();
                    fout.close();
                }
            zin.close();


        // --------------------------------- Рекурсивная архивация папок и файлов --------------------------------------
            System.out.println();
            System.out.println("--------- Архивация ---------");
                File allDir = new File(DirToZip);
                    if (!allDir.exists())
                        createFolder(allDir);

                try {
                    System.out.println("Начало архивации папки: " + DirToZip);
                        exec(DirToZip, zipFolder);
                    System.out.println("Архив был записан успешно: " + zipFolder);
                } catch (FileNotFoundException f) {
                    System.out.println(f.getMessage());
                } catch (IOException i) {
                    System.out.println(i.getMessage());
                }


        // --------------------------------- Рекурсивная разархивация папок и файлов -----------------------------------
            System.out.println();
            System.out.println("--------- Разархивирование ---------");
                final String SLASH_BACK = "\\";
                String zipFilePath = zipFolder;
                String ExtractPath = ExtrPath;

                new File(ExtractPath).mkdirs();                     // создаем папку, в которую будем Unzip

                ZipFile zf = new ZipFile(zipFilePath);                  // извлекаем элементы перечисления и записываем их в массив
                Enumeration<?> en = zf.entries();
                while (en.hasMoreElements()) {
                    ZipEntry ze = (ZipEntry) en.nextElement();          // получаем массив ZipEntry
                    String enName = ze.getName();


                    if (enName.endsWith(SLASH_BACK)) {
                        System.out.println("Cоздание директории <" + enName + "> ");
                        new File(ExtractPath + SLASH_BACK + enName.substring(0, enName.length() - 1)).mkdirs();
                        continue;
                    } else {
                        String path = ExtractPath + SLASH_BACK +  enName;
                        System.out.println("Чтение файла <" + path + ">");
                        new File(path).createNewFile();

                        try (InputStream fIns = zf.getInputStream(ze); FileOutputStream fos = new FileOutputStream(path)) {
                            byte[] but = new byte[fIns.available()];
                            fIns.read(but, 0, but.length);
                            fos.write(but, 0, but.length);
                        } catch (IOException e) {
                            System.out.println("Error :" + e.getMessage());
                        }
                    }
                }
            zf.close();
            System.out.println("Zip файл разархивирован!");

        //---------------------------------------- удаление всех файлов ------------------------------------------------
            deletedDirFiles(DIR);
        }


        // cоздаем Тестовую папку с файлами
        public static void createFolder(File allDir) throws IOException {
            allDir.mkdir();
                new File(DirToZip + "\\1").mkdir();
                    new File(DirToZip + "\\1" + "\\1.1").mkdir();
                    new File(DirToZip + "\\1" + "\\1.2").mkdir();
                        new File(DirToZip + "\\1" + "\\1.2"+"\\doc.txt").createNewFile();
                        new File(DirToZip  + "\\1" + "\\1.2"+"\\excel.doc").createNewFile();
                    new File(DirToZip  + "\\1" +  "\\1doc.txt").createNewFile();
                    new File(DirToZip  + "\\1" +  "\\2excel.txt").createNewFile();
                new File(DirToZip + "\\2").mkdir();
                    new File(DirToZip + "\\2"+"\\2.1").mkdir();
                        new File(DirToZip + "\\2"+"\\2.1" +"\\2.2").mkdir();
                new File(DirToZip + "\\3").mkdir();
                    new File(DirToZip + "\\3"+"\\doc.txt").createNewFile();
                    new File(DirToZip + "\\3"+"\\forward.doc").createNewFile();
                    new File(DirToZip + "\\3"+"\\log.xml").createNewFile();
                new File(DirToZip + "\\doc.txt").createNewFile();
                new File(DirToZip + "\\excel.txt").createNewFile();
        }


        // рекурсивное удаление папки
        public static void deletedDirFiles(File file){
            if (file.isDirectory()) {
                for(File f : file.listFiles())
                    deletedDirFiles(f);
            }
            file.delete();
        }
    }
