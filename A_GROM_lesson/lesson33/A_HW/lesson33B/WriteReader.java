package A_GROM_lesson.lesson33.A_HW.lesson33B;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

public class WriteReader {

    public static void writeToFileFromConsole(String path) {
        String content =content();

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter((writer));

            bufferedWriter.append(content);                             //для корректного отображения необходимо использовать язык html
        } catch (FileNotFoundException e) {                             //не понятно, так как он автоматически сам создает файл
            System.err.println("File with path - "+path+" not found");
        } catch (IOException e) {
            System.err.println("Can't write to file with path - "+path);
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }

    private static String  content(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String tmp=null;
        ArrayList<String> list=new ArrayList<>();

        System.out.println("Enter file content to write in the file: ");   //приветствие
        try {
            do{                                                            //запись с консоли
                tmp=br.readLine();
                list.add(tmp);
            }while (!tmp.equals("wr"));
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

        String content=list.get(0)+"\n";
        for(int i=1;i< (list.size()-1);i++) {
            content+=list.get(i)+"\n";
        }

    return content;
    }
}
