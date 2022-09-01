package A_GROM_lesson.lesson36.C_controller;

import A_GROM_lesson.lesson36.B_model.User;
import A_GROM_lesson.lesson36.D_service.UserService;

public class UserController {
    private static UserService userService=new UserService();

    public static void login(String UserName,String password)  {
            userService.login(UserName,password);
    }

    public static User registerUser(User user) {
        return userService.registerUser(user);
    }

    public static void logout(){
        userService.logout();
    }
}