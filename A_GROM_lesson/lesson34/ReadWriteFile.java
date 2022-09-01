package A_GROM_lesson.lesson34;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) throws InterruptedException {
        readFile("C:/Users/Администратор/Desktop/test.txt");
        writeFile("C:\\Users\\Администратор\\Desktop\\test2.txt");
    }

    private static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file" + path + "failed");
        }
    }

    private static void writeFile(String path) throws InterruptedException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append("новая строка");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }
}

