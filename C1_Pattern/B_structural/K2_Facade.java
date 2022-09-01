package C1_Pattern.B_structural;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//предназначен для того, чтобы спрятать всю сложность функционала за примитивным интерфейсом
class FileReaderFacade{
    String readFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        while((k = reader.read()) != - 1)
            stringBuilder.append((char) k);
        return stringBuilder.toString();
    }
}

public class K2_Facade {
    public static void main(String[] args) throws IOException {
        FileReaderFacade fileReaderFacade = new FileReaderFacade();
        System.out.println(fileReaderFacade.readFile("src\\C1_Pattern\\0_readMe.txt"));
    }
}
