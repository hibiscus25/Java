package A_GROM_lesson.lesson32.A_HW.lesson32B;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import A_GROM_lesson.lesson32.A_HW.lesson32B.Exception.*;

public class Solution {

    public static void readNumbers() throws IOException {
        String txt=null;
        int result = 0;
        int n = 4;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Please enter your number");
                txt = scanner.nextLine();
                matcher(txt);
                result = summa(txt);
                break;
            } catch (BadRequestException e) {
                n--;
                if (n > 1)
                    System.out.println("You numbers are wrong. You have " + (n - 1) + " attempts to try again");
                else {
                    System.out.println("Your numbers are wrong. Number of attempts exceeded");
                    scanner.close();
                    System.exit(0);
                }
            }
        } while (true);
        System.out.println(result);
        scanner.close();
    }

    private static boolean matcher(String txt) throws BadRequestException {
        Pattern pattern = Pattern.compile("[\\p{L}\\p{S}\\p{M}\\p{P}]");
        Matcher m = pattern.matcher(txt);
        if (!m.find()) {
            return true;
        }
        throw new BadRequestException("введено не числовое значение");
    }

    private static int summa(String txt) throws BadRequestException {
        String[] arrays = txt.split(" ");
        if (arrays.length != 10)
            throw new BadRequestException("ввел не десять чисел");
        int result = 0;
        for (int i = 0; i < arrays.length; i++) {
            int tmp = Integer.parseInt(arrays[i]);
            if (tmp > 100)
                throw new BadRequestException("число больше 100");
            result += tmp;
        }
        return result;
    }
}

