package A_GROM_lesson.lesson32.A_HW.lesson32A;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class KeyboardReader {
    public static void main(String[] args) throws IOException {
        readKeyboardScanner();
        readKeyboardBufferedReader();
    }

    public static void readKeyboardScanner() {
        String txt=null;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Please enter your name");
            txt=scanner.nextLine();
        }
        while(!matcher(txt));{
            System.out.println("Hello, " + txt + "!");
        }
        scanner.close();
    }

    public static void readKeyboardBufferedReader() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String txt=null;
        do{
            System.out.println("Please enter your name");
            txt=br.readLine();
        }
        while(!matcher(txt));{
            System.out.println("Hello, " + txt + "!");
        }
    }

    private static boolean matcher(String txt) {
        Pattern pattern = Pattern.compile("[\\d\\s\\p{S}\\p{M}\\p{P}]");
        Matcher m = pattern.matcher(txt);
        if (!m.find()) {
            return true;
        }
            System.out.println("Incorrect name, try again...");
        return false;
    }
}