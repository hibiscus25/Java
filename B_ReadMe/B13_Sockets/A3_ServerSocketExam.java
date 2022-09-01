package B_ReadMe.B13_Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


    // пример с применением многопоточности
    public class A3_ServerSocketExam {
        public static void main(String[] args) throws IOException {
            try(ServerSocket serverSocket = new ServerSocket(8189)) {
                while (true) {
                    Socket socket = serverSocket.accept();
                    new Thread(new MyServer(socket)).start();               //cоздается новый поток
                }
            }
        }
    }


    // класс выполняет все действия в своем потоке
    class MyServer implements Runnable{
        Socket socket;

        public MyServer(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try(Scanner scanner = new Scanner(socket.getInputStream());
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
                if (scanner.hasNextLine())
                    printWriter.println("you write: " + scanner.nextLine());
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }