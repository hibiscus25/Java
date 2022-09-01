package A_GROM_lesson.lesson34.A_HW.lesson34D;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {

    public static void copyFileContent(String fileFromPath,String fileToPath) {
        try (FileInputStream readFile=new FileInputStream(fileFromPath); FileOutputStream writeFile=new FileOutputStream(fileToPath)) {
            int reads=readFile.read();
            while(reads!=-1){
                writeFile.write(reads);
                reads=readFile.read();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist ");
        } catch (IOException e) {
            System.err.println("File access error ");
        }
    }

    public static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest,true);
    }
}
