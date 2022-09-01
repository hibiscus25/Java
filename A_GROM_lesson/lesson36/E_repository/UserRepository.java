package A_GROM_lesson.lesson36.E_repository;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class UserRepository {

//----------------------------------быстрый  поиск  до первого значения -----------------------------------------------
    public static Map<Long, String> searchFastFromFile(String one, String two, String three, String four, String path) {
        validate(path);
        Map<Long, String> map = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            long count = 0;
            map = new TreeMap<>();
            while ((line = br.readLine()) != null) {
                count += line.length() + 1;
                if (line.contains(one) && line.contains(two) && line.contains(three) && line.contains(four)) {
                    map.put((count - line.length()), line);
                    return map;
                }
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
        return map;
    }

    public static boolean readFromFile(String UserName, String path) {
        validate(path);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(UserName))
                    return true;
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
        return false;
    }


//---------------------------------- дополнительные -------------------------------------------------------------------
    public static void validate(String path) {
        try {
            File fileFrom = new File(path);
            if (!fileFrom.exists()) {
                throw new FileNotFoundException("File " + fileFrom + " not found");
            }
            if (!fileFrom.canExecute()) {
                throw new Exception("File " + fileFrom + " does not exist");
            }
            if (!fileFrom.canRead()) {
                throw new Exception("File " + fileFrom + " does not have permissions to read");
            }
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            System.exit(0);
        }
    }

    public static String readLastLine(String path) {
        String result = null;
        File file = new File(path);
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            long startIdx = file.length();
            while (startIdx >= 0 && (result == null || result.length() == 0)) {
                raf.seek(startIdx);
                if (startIdx > 0)
                    raf.readLine();
                result = raf.readLine();
                startIdx--;
            }
        } catch (IOException e) {
            System.err.println("Can't write to file"+path);
            System.exit(0);
        }
        return result;
    }

    public static long id(String path) {
        long count = Long.parseLong((readLastLine(path).split(",")[0]));
        count++;
        return count;
    }

    public static void addToFile(String addition, String path) {
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
            raf.seek(raf.length());
            raf.writeBytes("\n");
            raf.writeBytes(addition);
        } catch (IOException e) {
            System.err.println("Can't write to file"+path);
            System.exit(0);
        }
    }
}

