package B_ReadMe.B13_Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

    // обмена информацией через интернет
    public class A1_SocketClients {
        public static void main(String[] args) throws IOException {

            // запрос на внешний сервер
            try(Socket socket = new Socket()){
                // india.colorado.edu - IP адрес
                // 13 - порт
                // 2000 - время задержки
                socket.connect(new InetSocketAddress("india.colorado.edu", 13),2000);
                Scanner scanner = new Scanner(socket.getInputStream());
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    if (!str.equals(""))
                        System.out.println("Внешний сервер: " + str);
                }
            }

            // запрос на внутренний сервер
            try(Socket socket = new Socket()){
                // localhost - 127.0.0.1
                // вместо localhost можно InetAddress.getLocalHost()
                socket.connect(new InetSocketAddress("localhost",8189), 2000);
                Scanner scanner = new Scanner(socket.getInputStream());
                while (scanner.hasNextLine())
                    System.out.println("Локальный сервер: " + scanner.nextLine());
            }
        }
    }
