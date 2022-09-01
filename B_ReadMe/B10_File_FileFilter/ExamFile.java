package B_ReadMe.B10_File_FileFilter;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


    public class ExamFile {
            // File - 4
            public static void displayPath (File testFile) throws IOException {
                System.out.println("path : " + testFile.getPath());
                System.out.println("absolute path : " + testFile.getAbsolutePath());
                System.out.println("canonical path : " + testFile.getCanonicalPath());
            }

            // File - 6
            public static void recursiveDelete(File file) {
                if (file.isDirectory()) {
                for(File f : file.listFiles())
                    recursiveDelete(f);
                }
                file.delete();
                System.out.println("Удаленный файл или папка: " + file.getAbsolutePath());
            }



    public static void main(String[] args) throws IOException {
//----------------------------------------------- примеры File ---------------------------------------------------------
        final String path = "E:\\1_Java\\2.1_JavaСore\\0.0_архив\\2_проект\\0_Library\\examDir";
        final String path2 = "E:\\1_Java\\2.1_JavaСore\\0.0_архив\\2_проект\\0_Library\\examDir2";

    // 1. создание каталога / файла
            File dir = new File(path);
                dir.mkdir();
            File fl = new File(path + "\\examFile.txt");
                fl.createNewFile();


    // 2. открываем файл и извлекаем его характеристики
            System.out.println ("Имя файла: " + fl .getName());
                System.out.println ("Путь: " + fl.getPath());
                System.out.println ("Полный путь: " + fl.getAbsolutePath());
                System.out.println ("Родительский каталог: " + fl.getParent());
            System.out.println (fl.exists() ?   "Файл существует" : "Файл  не существует");
            System.out.println (fl.canWrite() ? "Свойство - можно записывать" : "Свойство - нельзя записывать");
            System.out.println (fl.canRead() ?  "Свойство - можно читать" : "Свойство - нельзя читать");
            System.out.println ("Это директория? " +   (fl.isDirectory() ? "да": " нет"));
            System.out.println ("Это обычный файл? " + (fl.isFile() ?  "да" : "нет"));
            System.out.println ("Последняя модификация файла : "    + fl. lastModified());
            System.out.println ("Размер файла : " + fl.length() + " bytes");


    // 3. cравнение файлов с помощью getCanonicalFile
            System.out.println("-------------------------------");
            File f1 = new File ("./test.txt");
            File f2 = new File ("test.txt");
                System.out.println(f1.equals(f2));              //false

            f1 = f1.getCanonicalFile();
            f2 = f2.getCanonicalFile();
                System.out.println(f1.equals(f2));              //true


    // 4. пример, как может быть много разных путей (и абсолютных путей) к одному и тому же файлу, но имеют один канонический путь
            //  Канонический путь полезен, если вы хотите знать, указывают ли два разных пути на один и тот же файл или нет
            System.out.println("-------------------------------");
            File child = new File(".././Java.txt");
                System.out.print("1. Path of the given file: ");
                displayPath(child);

            File parent = child.getParentFile();
                System.out.println();
                System.out.println("2. Path of the parent file :");
                displayPath(parent);

    // 5. переименование  / перемещение
            File newFile = new File(path + "\\newExamFile.txt");        // переименование файла
                fl.renameTo(newFile);

            File newDir = new File (path2);                                      // перемещение файла в новую папку
                newDir.mkdir();
            File toName = new File(newDir, newFile.getName());
                toName.createNewFile();

    // 6. удаление (рекурсивное)
            /* Если необходимо удалить определенную папку, нужно предварительно удалить все хранящиеся в ней файлы и папки
                 Для удаления папки удобно применить рекурсию:
                   -   метод получает список файлов и подпапок заданной папки и последовательно удаляет его элементы
                   -   если текущий элемент является папкой, то метод вызывает сам себя для этой подпапки и т.д.
                   -   также, нужно учесть, что для удаления папки требуются права доступа ко всей иерархии ее подпапок на удаление
             */
            System.out.println("-------------------------------");
            recursiveDelete(dir);
    //---------------------------------
            recursiveDelete(newDir);                                // удаляем директорию  examDir2

//----------------------------------------------- примеры Path ---------------------------------------------------------
        System.out.println("-------------------------------");
        Path pt = Paths.get(path2).toAbsolutePath();                // 1 - вариант получения пути до файла/каталога
//      pt = toName.toPath();                                       // 2 - вариант
            System.out.println(pt.getFileName());
            System.out.println(pt.getParent());
            System.out.println(pt.getRoot());

//---------------------------------------------- примеры Files ---------------------------------------------------------
        System.out.println("-------------------------------");
        File fil = new File("temp.txt");
            fil.createNewFile();

    //1. основной функционал
            // копирование файлов
                  // StandardCopyOption.REPLACE_EXISTING - используется, чтобы не было Exception, если такой файл уже есть
            Files.copy(Paths.get("temp.txt"), Paths.get("temp2.txt"),StandardCopyOption.REPLACE_EXISTING);

            // переименование файла
            Files.move(Paths.get("temp2.txt"), Paths.get("temp3.txt"),StandardCopyOption.REPLACE_EXISTING);

            // удаление файла
            Files.deleteIfExists(Paths.get("temp3.txt"));

    //2. свойства файла
            Path pts = fil.toPath();
                System.out.println(Files.size(pts));
                System.out.println(Files.isDirectory(pts));
                System.out.println(Files.isHidden(pts));
                System.out.println(Files.isExecutable(pts));
                System.out.println(Files.isReadable(pts));
                System.out.println(Files.isWritable(pts));

                // информация по значению  - "size"
                System.out.println(Files.getAttribute(pts, "size", LinkOption.NOFOLLOW_LINKS));

                // доступ до аттрибутов, которые похоже везде
                BasicFileAttributes  att = Files.readAttributes(pts, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
                    System.out.println(att.creationTime());  //потом можно посмотреть все методы att

                // доступ до всех аттрибутов при Линуксе
                    // PosixFileAttributes posix = Files.readAttributes(pts, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);

    //3. чтение/запись
                System.out.println("--------------------------------");
                byte[] bytes = Files.readAllBytes(pts);                                     // чтение массива байтов
                for (byte el : bytes)
                    System.out.println(el);

                System.out.println();
                List<String> list = Files.readAllLines(pts);                                // чтение построчно
                for (String el: list)
                    System.out.println(el);

                Files.write(pts, "blas\nnew str".getBytes(), StandardOpenOption.APPEND);     // запись массива байтов

                List<String> lt = new ArrayList<>();                                         // запись строки
                    lt.add("\nkol");
                    lt.add("mol\n");
                Files.write(pts, lt, StandardOpenOption.APPEND);

    //4. получение стримов
                InputStream inStr = Files.newInputStream(pts);
                OutputStream outStr = Files.newOutputStream(pts);
                Reader reader = Files.newBufferedReader(pts);
                Writer writer = Files.newBufferedWriter(pts);


    //5. перебор файлов
            System.out.println("-------------------------------");
                //возвращает список, что находится в папке
                try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get("E:\\1_Java\\2.1_JavaСore"))){
                    for(Path el : entries)
                        System.out.println(el);
                }

                //если хотим что-то сделать, тогда так
                System.out.println();
                Files.walkFileTree(Paths.get("E:\\1_Java\\2.1_JavaСore\\0.0_архив\\2_проект"), new MyFileVisitor());
                System.out.println();
                //new HashSet<FileVisitOption>(), 1 - используется для глубины сканирования
                Files.walkFileTree(Paths.get("E:\\1_Java\\2.1_JavaСore\\0.0_архив\\2_проект"), new HashSet<>(), 1, new MyFileVisitor());

        //----------------
                Files.deleteIfExists(Paths.get("temp.txt"));            // удаляем файл 6.temp.txt
        }
    }

    class MyFileVisitor extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException{
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }
