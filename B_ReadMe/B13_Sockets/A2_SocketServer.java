package B_ReadMe.B13_Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

    public class A2_SocketServer {
        public static void main(String[] args) throws IOException {
            try(ServerSocket serverSocket = new ServerSocket(8189); Socket socket = serverSocket.accept();
                Scanner scanner = new Scanner(socket.getInputStream())){

                    PrintWriter pWriter = new PrintWriter(socket.getOutputStream(), true);
                        pWriter.println("hello");

//                    while (scanner.hasNextLine()){                                    // чтобы постоянно работал
//                        String str = scanner.nextLine();
//                        pWriter.println("you've send: " + str);
//                        System.out.println(str);
//                        if(str.equals("exit"))
//                            break;
//                    }
            }
        }
    }
