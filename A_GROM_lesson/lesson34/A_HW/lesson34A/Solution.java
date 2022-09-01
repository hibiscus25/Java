package A_GROM_lesson.lesson34.A_HW.lesson34A;

import java.io.*;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath)  {
        try {
            validate(fileFromPath, fileToPath);
        }catch(Exception e){
            System.err.println("error: "+e.getMessage());
            System.exit(0);
        }
        writeToFile(fileToPath, readFromFile(fileFromPath));
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permissions to read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permissions to read");
        }
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
            System.exit(0);
        }
    }
}
