package A_GROM_lesson.lesson25.A_HW;

import A_GROM_lesson.lesson25.A_HW.exception.BadRequestException;
import A_GROM_lesson.lesson25.A_HW.exception.InternalServerException;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws BadRequestException, InternalServerException {
        User user = new User(5);
        User user1 = new User(7);
        User user2 = new User(9);
        User user3 = new User(12);
        User user4 = new User(16);
        GeneralDAO<User> usersDAO = new GeneralDAO<>();

        try {
            usersDAO.save(user);
            usersDAO.save(user1);
            usersDAO.save(user2);
            usersDAO.save(user3);
            usersDAO.save(user4);
            usersDAO.save(user3);
            usersDAO.save(user4);
            usersDAO.save(user3);

        } catch (BadRequestException e) {
            System.err.println("Error1: " + e.getMessage());
        } catch (InternalServerException e) {
            System.err.println("Error2: " + e.getMessage());
        }

        System.out.println(Arrays.deepToString(usersDAO.getAll()));
    }
}
