package A_GROM_lesson.lesson33.A_HW.lesson33C;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFile {
    public static void readFileByConsole() {
        System.out.println(readFile(readConsole()));
    }

    private static String readConsole() {                               //cчитываем данные с консоли+
        String path=null;
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please, enter file path to read: ");
        try {
            path = br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return path;
    }

    private static String readFile(String path) {                       //cчитываем данные с файла+
        String content=null;
        FileReader reader=null;

        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path - "+path+" not found");
            System.exit(0);
        }

        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                content = line;
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path - "+path);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return content;
    }
}
