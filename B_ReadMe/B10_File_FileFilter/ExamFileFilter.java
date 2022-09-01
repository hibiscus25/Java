package B_ReadMe.B10_File_FileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;



    //Для использования FileFilter необходимо создать объект и определить в нем соответствующий метод accept:
    class Filter implements FileFilter {
        String[] ext;                                                 // [png, jpeg]

        Filter(String ext){
            this.ext = ext.split(",");                         //  png, jpeg - по запятой в массив
        }

        private String getExtension(File pathname){
            String filename = pathname.getPath();                     // получаем полный путь
            int i = filename.lastIndexOf('.');                    // cчитает индекс от начала до последней .
            if ((i > 0) && (i < filename.length()-1)) {
                return filename.substring(i + 1).toLowerCase();       // возвращает расширение png, jpeg и тп
            }
            return "";
        }

        @Override
        public boolean accept(File pathname){                         // каждый файл попадает в этот метод
            if (!pathname.isFile())                                        //если это не файл - false
                return false;
            String extension = getExtension(pathname);                // получаем расширение файла
            for (String e : ext) {                                    // проверяем совпадает расширение с заданным массивом
                if (e.equalsIgnoreCase(extension))
                    return true;
            }
        return false;
        }
    }



    public class ExamFileFilter {
        // метод для рекурсивного удаления файлов
        public static void recursiveDelete(File file) {
            if (file.isDirectory()) {
                for(File f : file.listFiles())
                    recursiveDelete(f);
            }
            file.delete();
            System.out.println("Удаленный файл или папка: " + file.getAbsolutePath());
        }


        public static void main(String[] args) throws IOException {
            final String path = "C:\\Users\\Администратор\\Desktop\\test";      // путь на рабочий стол
            File dir = new File(path);                                                // создаем директорию
                dir.mkdir();

            new File(dir,"exam.txt").createNewFile();                           // создаем файлы в папке
            new File(dir,"exam.png").createNewFile();
            new File(dir,"exam.xls").createNewFile();
            new File(dir,"exam.doc").createNewFile();
            new File(dir,"exam.jpeg").createNewFile();

            System.out.println("Чтение полного списка файлов каталога:");
            File[] lst1 = dir.listFiles();
            for (File el: lst1)
                System.out.println(el);

            System.out.println();
            System.out.println("Чтение списка файлов каталога \"png\" и \"jpeg\":");
            File[] lst2 = dir.listFiles(new Filter("png,jpeg"));
                        // в методе dir.listFiles(Filter filter);
                                //  1. cоздается список всех файлов, которые входят в директорию
                                //  2. cоздается        ArrayList<File> files = new ArrayList<>();
                                //  3. пропускает все файлы через фильтр, запуская  метод accept в Filter для каждого файла
                                //                       for (String s : ss) {
                                //                       File f = new File(s, this);
                                //                          if ((filter == null) || filter.accept(f))
                                //                              files.add(f);
                                //                        }
                                //  4. возвращает массив файлов  return files.toArray(new File[files.size()]);
            for (File el: lst2)
                System.out.println(el);

            System.out.println();
            recursiveDelete(dir);                                                   // удаляем папку и ее содержимое
        }
    }
