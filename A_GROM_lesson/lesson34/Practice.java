package A_GROM_lesson.lesson34;

import java.io.*;

public class Practice {
    public static void main(String[] args) throws Exception{
        copyFileContent("C:\\Users\\Администратор\\Desktop\\From.txt", "C:\\Users\\Администратор\\Desktop\\To.txt");
    }


    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath,fileToPath);
        writeToFile(fileToPath,readFromFile(fileFromPath));
    }


    private static void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom=new File(fileFromPath);
        File fileTo=new File(fileToPath);

        if(!fileFrom.exists()){                                         //файл - есть в наличии?
            throw new FileNotFoundException("File "+fileFrom+" does not exist");
        }
        if(!fileTo.exists()){
            throw new FileNotFoundException("File "+fileTo+" does not exist");
        }
        if(!fileFrom.canRead()){                                        //можно ли читать/записывать
            throw new Exception("File "+fileFrom+" does not have permissions to read");
        }
        if(!fileTo.canWrite()){
            throw new Exception("File "+fileTo+" does not have permissions to read");
        }

    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res=new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length()-1,res.length(),"");  //убираем последний пробел
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
        }
    return res;
    }

    private static void writeToFile(String path,StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }
}
