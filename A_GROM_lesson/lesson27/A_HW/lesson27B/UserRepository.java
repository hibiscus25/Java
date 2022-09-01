package A_GROM_lesson.lesson27.A_HW.lesson27B;

import A_GROM_lesson.lesson27.A_HW.lesson27B.Exception.BadRequestException;
import A_GROM_lesson.lesson27.A_HW.lesson27B.Exception.InternalServerException;
import A_GROM_lesson.lesson27.A_HW.lesson27B.Exception.UserNotFoundException;

import java.util.ArrayList;

public class UserRepository {
    public static ArrayList<User> list = new ArrayList<>();
    private static User users;

    public static User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can`t save null user");

        if (list.size() >= 10)
            throw new InternalServerException("Not enough space to save user with id: " + user.getId());

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        list.add(user);
        return user;
    }

    public static User update(User user) throws BadRequestException {
        if (user == null)
            throw new BadRequestException("Can`t update null user");

        try {
            list.set(list.indexOf(findById(user.getId())), user);
        } catch (UserNotFoundException e) {
            System.err.println("Error1: " + e.getMessage());
            throw new BadRequestException("User with id: " + user.getId() + " not updated");
        }
        return user;
    }

    public static void delete(long id) {
        try {
            list.remove(list.indexOf(findById(id)));
        } catch (UserNotFoundException e) {
            System.err.println("Error2: " + e.getMessage());
        }
    }

    public static User findById(long id) throws UserNotFoundException {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (list.get(i).getId() == id) {
                users = list.get(i);
                return users;
            }
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public static ArrayList<User> getUsers() {
        return list;
    }
}
