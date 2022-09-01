package A_GROM_lesson.lesson32;

import java.io.*;
import java.util.*;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException{
        readKeyboardWithIOStream();
    }

    private static void scannerOne() {
        Scanner scanner = new Scanner(System.in);
        int n = 2;
        while (scanner.hasNext()) {
            System.out.println(scanner.next() + "!");
            n--;
            if (n == 0)
                break;
        }
        scanner.close();
    }

    private static void readKeyboardWithScanner() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your name");
            System.out.println("Hello, "+scanner.nextLine());
        scanner.close();
    }

    private static void readKeyboardWithIOStream() throws IOException {
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(reader);
            System.out.println("Please enter your name");
            System.out.println("Hello, "+ br.readLine()+ "!");
    }
}
