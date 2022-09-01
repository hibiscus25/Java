package A_GROM_lesson.lesson34.A_HW.lesson34B;

import java.io.*;

public class Solution {

    public static void transferFileContent(String fileFromPath, String fileToPath) {
        try {
            validate(fileFromPath, fileToPath);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            System.exit(0);
        }
        writeToFile(fileToPath, readFromFile(fileFromPath), true);
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
            try {
            String line;
                while ((line = br.readLine()) != null) {
                    res.append(line);
                    res.append("\n");
                }
                deleteContentFromFile(path, res);
            } catch (OutOfMemoryError e) {
                System.err.println("It is not possible to transfer content ");
                System.exit(0);
            }
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
            System.exit(0);
        }
        return res;
    }

    private static void deleteContentFromFile(String path, StringBuffer res) {
        StringBuffer res2 = new StringBuffer(res);
        res2.delete(0, res2.length());
        writeToFile(path, res2, false);
    }

    private static void writeToFile(String path, StringBuffer contentToWrite, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
            System.exit(0);
        }
    }
}
