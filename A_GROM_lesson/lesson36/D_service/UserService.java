package A_GROM_lesson.lesson36.D_service;

import A_GROM_lesson.lesson36.B_model.ENUM.UserType;
import A_GROM_lesson.lesson36.B_model.User;
import A_GROM_lesson.lesson36.E_repository.UserRepository;
import A_GROM_lesson.lesson27.A_HW.lesson27B.Exception.BadRequestException;

import java.util.Map;

public class UserService {
    private static boolean statusActive = false;
    private static UserType userType=UserType.USER;
    private static UserRepository userRepository = new UserRepository();
    private static final String fileFromPath = "E:\\3.0_Java\\library\\dateBase\\UserDb.txt";


    public static void login(String UserName, String password) {
        try {
            validateUser(UserName, password, "");
            Map<Long, String> map = userRepository.searchFastFromFile(UserName, password, "", "", fileFromPath);
            if(map.isEmpty())
                throw new BadRequestException("Incorrect login or password");
            statusActive = true;
            long id=map.keySet().hashCode();
            userType=UserType.valueOf(map.get(id).split(",")[4]);
        } catch (BadRequestException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static User registerUser(User user) {
        User userNew=null;
        try {
            validateUser(user.getUserName(), user.getPassword(), user.getCountry());
            if (userRepository.readFromFile(user.getUserName(),  fileFromPath))
                throw new BadRequestException("User with this login exists");
            userNew = new User(userRepository.id(fileFromPath), user.getUserName(), user.getPassword(), user.getCountry(), UserType.USER);
            userRepository.addToFile(userNew.toString(), fileFromPath);
        } catch (BadRequestException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return userNew;
    }

    public static void logout() {
        statusActive = false;
        userType=UserType.USER;
    }

    public static boolean isStatus() {
        return statusActive;
    }

    public static UserType getUserType() {
        return userType;
    }

    private static void validateUser(String name, String password, String country) throws BadRequestException {
        if (name == null || password == null || country == null)
            throw new BadRequestException("Fields must not be empty");
    }
}
