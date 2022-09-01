package A_GROM_lesson.lesson36.E_repository;

import java.io.*;
import java.util.*;

public class HotelRepository {

    //---------------------- -----------полный поиск всех совпадений  --------------------------------------------------
    public static Map<Long, String> searchFromFileOne(String one,String path) {
        UserRepository.validate(path);
        Map<Long, String> map = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            long count = 0;
            map = new TreeMap<>();
            while ((line = br.readLine()) != null) {
                count += line.length() + 1;
                if (line.contains(one)) {
                    map.put((count - line.length()), line);
                }
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
        return map;
    }

    public static Map<String, String> searchFromFileTwo(String one,String two,String path) {
        UserRepository.validate(path);
        Map<String, String> map = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            map = new TreeMap<>();
            while ((line = br.readLine()) != null) {
                if (line.contains(one) && line.contains(two) ) {
                    map.put(line.split(",")[0], line);
                }
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
        return map;
    }

//--------------------------------------- дополнительные --------------------------------------------------------------

    public static void deleteToFrom(Map<Long, String> map, String path) {
        UserRepository.validate(path);
        long count = map.keySet().hashCode();
        rewritingToFile(recordingFromFile(count, map.get(count).length(), path), path);
    }

    //считывание данных до позиции объекта и после (без удаляемого объекта)
    public static LinkedList<String> recordingFromFile(long number, int size, String path) {
            LinkedList<String> list=null;
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
            list = new LinkedList<>();
            String line;
            raf.seek(0);
            while (raf.getFilePointer() < (number - 2)) {
                list.add(line = raf.readLine());
                list.add("\n");
            }
            raf.seek(number + size);
            while ((line = raf.readLine()) != null) {
                list.add(line);
                list.add("\n");
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
    return list;}

    //перезапись файла c готовой структуры данных
    private static void rewritingToFile(LinkedList<String> list, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < list.size() - 1; i++) {
                bufferedWriter.append(list.get(i));
            }
        } catch (IOException e) {
            System.err.println("Can't write to file"+ path );
            System.exit(0);
        }
    }
}
