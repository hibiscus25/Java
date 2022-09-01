package A_GROM_lesson.lesson33;

import org.apache.commons.io.IOUtils;
import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) throws InterruptedException{
//       readFile("C:/Users/Администратор/Desktop/test.txt");
//       readFile("C:\\Users\\Администратор\\Desktop\\test23.txt");
       writeFile("C:\\Users\\Администратор\\Desktop\\test2.txt");
    }

    private static void readFile(String path) {
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

    private static void writeFile(String path) throws InterruptedException {
        FileWriter writer=null;
        BufferedWriter bufferedWriter=null;
        try {
            writer=new FileWriter(path,true);                //если писать FileWriter(path) - будет перезаписывать инфо в файле
//          writer=new FileWriter(new File("path",true);            //можно и так написать

            bufferedWriter=new BufferedWriter((writer));
            bufferedWriter.append("\n");
            bufferedWriter.append("новая строка");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }
}

