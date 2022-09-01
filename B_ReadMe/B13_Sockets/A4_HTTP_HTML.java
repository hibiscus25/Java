package B_ReadMe.B13_Sockets;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class A4_HTTP_HTML {
    public static void main(String[] args) throws IOException {

        // достает  HTML - страницы
        URLConnection connection = new URL("http://www.google.com/").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
                scanner.useDelimiter("\\Z");                        // без этого условия, только <!doctype
                System.out.println(scanner.next());

        System.out.println();
        //достает Header ответа
        Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (Map. Entry<String, List<String>> el : headerFields.entrySet())
                System.out.println(el.getKey() + "/" + el.getValue());
    }
}
