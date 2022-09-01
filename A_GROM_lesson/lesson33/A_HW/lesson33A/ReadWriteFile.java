package A_GROM_lesson.lesson33.A_HW.lesson33A;

import org.apache.commons.io.IOUtils;
import java.io.*;

public class ReadWriteFile {

    public static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }
        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

    public static void writeFile(String path,String content) throws InterruptedException {
        FileWriter writer=null;
        BufferedWriter bufferedWriter=null;
        try {
            writer=new FileWriter(path,true);
            bufferedWriter=new BufferedWriter((writer));

            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }
}

