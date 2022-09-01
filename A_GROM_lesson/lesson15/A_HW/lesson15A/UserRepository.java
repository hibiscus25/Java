package A_GROM_lesson.lesson15.A_HW.lesson15A;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        checkUser(user);
        if (findUser(user) != null) {
            System.err.println("User is already in the database");
            System.exit(0);
        }

        int count = 0;
        for (int i=0;i<users.length;i++) {
            if (users[i] == null) {
                count++;
                return users[i] = user;
            }
        }

        if (count == 0) {
            System.err.println("There is no free space in the database");
            System.exit(0);
        }

        return user;
    }

    public User update(User user) {
        checkUser(user);
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId()==user.getId())
                return users[i] = user;
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                System.err.println("User id - " + users[i].getId() + " delete");
                users[i] = null;
            }
        }
    }

    public User findUser(User user) {
        checkUser(user);
        for (User el : users) {
            if (el != null && el.equals(user))
                return user;
        }
        return null;
    }


    private void checkUser(User user) {
        if (user == null) {
            System.err.println("User cannot be - null");
            System.exit(0);
        }
    }
}
