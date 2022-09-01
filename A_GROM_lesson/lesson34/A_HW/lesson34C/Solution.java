package A_GROM_lesson.lesson34.A_HW.lesson34C;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void transferSentences(String fileFromPath, String fileToPath,String wordToCheck) {
        try {
            validate(fileFromPath, fileToPath);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            System.exit(0);
        }
        writeToFile(fileToPath, readFromFile(fileFromPath,wordToCheck), true);
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

    private static ArrayList<String> readFromFile(String path,String wordToCheck) {
        ArrayList<String> res = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            try {
                String line;
                res = new ArrayList<>();
                ArrayList<String> delete = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    res.addAll(searchText(line, wordToCheck));
                    delete.add(line + "\n");
                }
                deleteAndWriteFromFile(delete, res,path);
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

    private static ArrayList<String> searchText(String txt, String word) {
        ArrayList<String> list = new ArrayList<>();
        if (matcher(txt.toLowerCase(), word)) {
            String[] array = txt.split("\\.");
            for (String el : array) {
                if (el.length() > 10) {
                    if (matcher(el.toLowerCase(), word)) {
                        list.add(el.trim() + "." + "\n");
                    }
                }
            }
        }
        return list;
    }

    private static boolean matcher(String txt, String word) {
        Pattern pattern = Pattern.compile(word.toLowerCase());
        Matcher m = pattern.matcher(txt);
        if (m.find()) {
            return true;
        }
        return false;
    }

    private static void deleteAndWriteFromFile(ArrayList<String> delete, ArrayList<String> res, String path) {
        for (int i = 0; i < delete.size(); i++) {
            for (int j = 0; j < res.size(); j++) {
                String tmp = res.get(j).substring(0, res.get(j).length() - 1) + " ";
                if (delete.get(i).contains(tmp)) {
                    delete.set(i, delete.get(i).replace(tmp, ""));
                    break;
                }
            }
        }
        writeToFile(path, delete, false);
    }

    private static void writeToFile(String path, ArrayList<String> list, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.append(list.get(i));
            }
        } catch (IOException e) {
            System.err.println("Can't write to file");
            System.exit(0);
        }
    }
}
