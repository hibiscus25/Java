package A_GROM_lesson.lesson9.A_HW.lesson9E;

public class UserRepository {
    private User[] users;

    UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }


    //-----------------------------------------------------------------------------------------------------
    private int numberEmpty() {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                count++;
            }
        }
        return count;

    }

    public String[] getUserNames() {
        int count = numberEmpty();
        if (count == 0)
            return null;

        String[] strings = new String[count];
        int countPlace = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                strings[countPlace] = users[i].getName();
                countPlace++;
            }
        }
        return strings;
    }


    public Long[] getUserIds() {
        int count = numberEmpty();
        if (count == 0)
            return null;

        Long[] longs = new Long[count];
        int countPlace = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                longs[countPlace] = users[i].getId();
                countPlace++;
            }
        }
        return longs;
    }


    public String getUserNameById(long id) {
        String result = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && id == users[i].getId()) {
                return result = users[i].getName();
            }
        }
        return result;
    }

    //-----------------------------------------------------------------------------------------------------
    public User getUserByName(String name) {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && name.equals(users[i].getName())) {
                return user = users[i];
            }
        }
        return user;
    }

    public User getUserBySessionId(String sessionId) {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && sessionId.equals(users[i].getSessionId())) {
                return user = users[i];
            }
        }
        return user;
    }

//-----------------------------------------------------------------------------------------------------

    private User findById(long id) {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && id == users[i].getId()) {
                return user = users[i];
            }
        }
        return user;
    }

    public User save(User user) {
        if (findById(user.getId()) != null)
            return null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                return users[i] = user;
            }
        }
        return null;
    }

    //-----------------------------------------------------------------------------------------------------
    public User updater(User user) {
        if (findById(user.getId()) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && users[i].getId() == user.getId()) {
                    return users[i] = user;
                }
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                users[i] = null;
            }
        }
    }
}