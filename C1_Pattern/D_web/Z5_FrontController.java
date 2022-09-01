package C1_Pattern.D_web;

import java.util.Scanner;


class DispatcherServlet{
        void process(String url){
            switch (url){
                case "home" : new HomeController().show(); break;
                case "user" : new UserController().show(); break;
                default: new DefaultController().show();
            }
        }
}

//-----------------------------------------------------------------
class HomeController{
    void show(){
        System.out.println("this is home page");
    }
}

class UserController{
    void show(){
        System.out.println("this is user page");
    }
}

class DefaultController{
    void show(){
        System.out.println("error");
    }
}

//-----------------------------------------------------------------
public class Z5_FrontController {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            while(scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                new Thread(){
                    @Override
                    public void run(){
                        new DispatcherServlet().process(nextLine);
                    }
                }.start();

            }
        }
    }
}
